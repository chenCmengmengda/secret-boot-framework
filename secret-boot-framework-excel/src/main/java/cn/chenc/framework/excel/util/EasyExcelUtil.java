package cn.chenc.framework.excel.util;

import cn.chenc.framework.excel.handler.CustomCellWriteHandler;
import cn.chenc.framework.excel.listener.ExcelListener;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.read.metadata.ReadSheet;
import com.alibaba.excel.write.metadata.WriteSheet;
import org.apache.poi.ss.formula.functions.T;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.List;

/**
 * 　@description: easyExcel工具类封装
 * 　@author 陈_C
 * 　@date 2020/8/21 11:38
 *
 */
public class EasyExcelUtil {

    //excel导出
    /**
     * @description: TODO
     * @param response
     * @param listdata   导出数据
     * @param filename   导出文件名称
     * @param clazz       导出的实体类
     * @return void
     * @throws
     * @author 陈_C
     * @date 2020/8/21 陈_C
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static void toExcle(HttpServletResponse response, List listdata, String filename, Class clazz) {
        try {
            //设置响应格式
            response.setContentType("application/vnd.ms-excel");
            response.setCharacterEncoding("utf-8");
            String name = URLEncoder.encode(filename, "UTF-8");
            response.setHeader("Content-Disposition", "attachment;filename="+name+".xlsx");

            //获取输出流
            ServletOutputStream outputStream= response.getOutputStream();


            //获取工作簿对象
            ExcelWriter excelWriter = EasyExcel.write(outputStream, clazz).registerWriteHandler(new CustomCellWriteHandler()).build();


            //获取工作表数量
            Integer sheetnum=1;
            if ( listdata.size()<1000000) {
                sheetnum=1;
            }else {
                sheetnum=listdata.size()%1000000==0 ? listdata.size()/1000000 :listdata.size()/1000000+1;//这里我是根据自身工作需要设置每一百万条数据一个sheet
            }

            // 去调用写入,这里我调用了sheetnum次，实际使用时根据数据库分页的总的页数来。这里最终会写到sheetnum个sheet里面
            List<T> subList =null;
            for (int i = 0; i < sheetnum; i++) {
                // 每次都要创建writeSheet 这里注意必须指定sheetNo
                WriteSheet writeSheet = EasyExcel.writerSheet(i,filename+"("+i+")").build();
                //这里是将查询的数据分为若干个sheet页
                subList = listdata.subList(i*1000000,i==sheetnum-1 ? listdata.size() : (i+1)*1000000);
                excelWriter.write(subList, writeSheet);
            }


            //finish 会帮忙关闭流
            excelWriter.finish();

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public static List<Object> readExcel(InputStream inputStream,Class clazz){
        ExcelListener listener = new ExcelListener();
        ExcelReader excelReader=EasyExcel.read(inputStream, clazz,listener ).build();
        ReadSheet readSheet = EasyExcel.readSheet(0).build();
        excelReader.read(readSheet);
        //获取数据
        List<Object> list = listener.getDatas();
        return list;
    }

}
