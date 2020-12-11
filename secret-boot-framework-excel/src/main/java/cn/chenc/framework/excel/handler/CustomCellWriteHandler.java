package cn.chenc.framework.excel.handler;

import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.metadata.Head;
import com.alibaba.excel.util.CollectionUtils;
import com.alibaba.excel.write.metadata.holder.WriteSheetHolder;
import com.alibaba.excel.write.style.column.AbstractColumnWidthStyleStrategy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 　@description: EasyExcel列宽自适应
 * 　@author 陈_C
 * 　@date 2020/9/18 9:16
 *
 */
public class CustomCellWriteHandler extends AbstractColumnWidthStyleStrategy {
    private static Logger LOG = LogManager.getLogger(CustomCellWriteHandler.class);

    private static final int MAX_COLUMN_WIDTH = 255;
    private Map<Integer, Map<Integer, Integer>> CACHE = new HashMap(8);

    @Override
    protected void setColumnWidth(WriteSheetHolder writeSheetHolder, List<CellData> cellDataList, Cell cell, Head head, Integer relativeRowIndex, Boolean isHead) {
        boolean needSetWidth = isHead || !CollectionUtils.isEmpty(cellDataList);
        if (needSetWidth) {
            Map<Integer, Integer> maxColumnWidthMap = (Map)CACHE.get(writeSheetHolder.getSheetNo());
            if (maxColumnWidthMap == null) {
                maxColumnWidthMap = new HashMap(16);
                CACHE.put(writeSheetHolder.getSheetNo(), maxColumnWidthMap);
            }

            Integer columnWidth = this.dataLength(cellDataList, cell, isHead);
            if (columnWidth >= 0) {
                if (columnWidth > 255) {
                    columnWidth = 255;
                } else if(columnWidth < 10){
                    columnWidth=10;
                }
//                LOG.info("columnWidth:"+columnWidth);
                Integer maxColumnWidth = (Integer)((Map)maxColumnWidthMap).get(cell.getColumnIndex());
                if (maxColumnWidth == null || columnWidth > maxColumnWidth) {
//                    LOG.info(maxColumnWidth+":"+true);
                    ((Map)maxColumnWidthMap).put(cell.getColumnIndex(), columnWidth);
                    writeSheetHolder.getSheet().setColumnWidth(cell.getColumnIndex(), columnWidth * 256);
                }

            }
        }
    }

    private Integer dataLength(List<CellData> cellDataList, Cell cell, Boolean isHead) {
        if (isHead) {
            return cell.getStringCellValue().getBytes().length;
        } else {
            CellData cellData = cellDataList.get(0);
            CellDataTypeEnum type = cellData.getType();
            if (type == null) {
                return 10;
            } else {
                switch (type) {
                    case STRING:
                        return cellData.getStringValue().getBytes().length;
                    case BOOLEAN:
                        return cellData.getBooleanValue().toString().getBytes().length;
                    case NUMBER:
                        return cellData.getNumberValue().toString().getBytes().length;
                    default:
                        return 10;
                }
            }
        }
    }

}

