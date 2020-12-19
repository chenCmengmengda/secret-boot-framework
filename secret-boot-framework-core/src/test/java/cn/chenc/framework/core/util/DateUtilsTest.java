package cn.chenc.framework.core.util;


import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.Map;

/**
 * 　@description: TODO
 * 　@author secret
 * 　@date 2020/12/12 15:57
 *
 */
public class DateUtilsTest {

    @Test
    public void getCurrentWeekTest(){
        Map map1=DateUtils.getCurrentWeek(false);
        Map map2=DateUtils.getCurrentWeek(true);
        return ;
    }

    @Test
    public void getYearFirstTest(){
        Date date=DateUtils.getYearFirst(1998);
        return;
    }
}
