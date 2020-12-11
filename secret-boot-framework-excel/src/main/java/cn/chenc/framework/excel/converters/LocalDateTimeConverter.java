package cn.chenc.framework.excel.converters;


import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.metadata.GlobalConfiguration;
import com.alibaba.excel.metadata.property.ExcelContentProperty;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/**
 * 　@description: TODO
 * 　@author 陈_C
 * 　@date 2020/8/26 16:32
 *
 */
public class LocalDateTimeConverter implements Converter<LocalDateTime> {

    /**
     * 不使用{@code @LocalDateTimeFormat}注解指定日期格式时,默认会使用该格式.
     */
    private static final String DEFAULT_PATTERN = "yyyy-MM-dd";

    /**
     * 读取时候的格式.
     */
    private static final String READ_PATTERN = "yyyy-MM-dd";


    @Override
    public Class supportJavaTypeKey() {
        return LocalDateTime.class;
    }

    @Override
    public CellDataTypeEnum supportExcelTypeKey() {
        return CellDataTypeEnum.STRING;
    }

    /**
     * 这里读的时候会调用
     *
     * @param cellData            excel数据 (NotNull)
     * @param contentProperty     excel属性 (Nullable)
     * @param globalConfiguration 全局配置 (NotNull)
     * @return 读取到内存中的数据
     */
    @Override
    public LocalDateTime convertToJavaData(CellData cellData, ExcelContentProperty contentProperty, GlobalConfiguration globalConfiguration) {
        DateTimeFormat annotation = contentProperty.getField().getAnnotation(DateTimeFormat.class);
        LocalDate localDate = LocalDate.parse(cellData.getStringValue(), DateTimeFormatter.ofPattern(Objects.nonNull(annotation) ? annotation.value() : READ_PATTERN));
        LocalDateTime localDateTime = localDate.atStartOfDay();
//        return LocalDateTime.parse(cellData.getStringValue(),
//                DateTimeFormatter.ofPattern(Objects.nonNull(annotation) ? annotation.value() : DEFAULT_PATTERN));
        return localDateTime;
    }


    /**
     * 写的时候会调用
     *
     * @param value               java value (NotNull)
     * @param contentProperty     excel属性 (Nullable)
     * @param globalConfiguration 全局配置 (NotNull)
     * @return 写出到excel文件的数据
     */
    @Override
    public CellData convertToExcelData(LocalDateTime value, ExcelContentProperty contentProperty, GlobalConfiguration globalConfiguration) {
        DateTimeFormat annotation = contentProperty.getField().getAnnotation(DateTimeFormat.class);
        return new CellData(value.format(DateTimeFormatter.ofPattern(Objects.nonNull(annotation) ? annotation.value() : DEFAULT_PATTERN)));
    }

}
