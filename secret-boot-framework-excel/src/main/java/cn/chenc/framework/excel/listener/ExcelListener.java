package cn.chenc.framework.excel.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * 　@description: easyExcel监听封装，用于数据导入
 * 　@author 陈_C
 * 　@date 2020/8/21 11:29
 *
 */
public class ExcelListener extends AnalysisEventListener {
    //可以通过实例获取该值
    private List<Object> datas = new ArrayList<Object>();

    @Override
    public void invoke(Object o, AnalysisContext analysisContext) {
        /**
         * 数据量超过一定量后存储数据库，防止过多数据在内存，容易OOM
         */
        if (datas.size()< 1000) {
            datas.add(o);//数据存储到list，供批量处理，或后续自己业务逻辑处理。
            doSomething(o);//根据自己业务做处理
        }
    }

    private void doSomething(Object object) {
        //1、入库调用接口
    }

    public List<Object> getDatas() {
        return datas;
    }

    public void setDatas(List<Object> datas) {
        this.datas = datas;
    }

    //解析结束执行
    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
