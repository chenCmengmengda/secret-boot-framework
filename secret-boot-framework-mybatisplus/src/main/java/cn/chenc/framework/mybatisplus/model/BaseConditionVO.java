package cn.chenc.framework.mybatisplus.model;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author yadong.zhang (yadong.zhang0415(a)gmail.com)
 * @website https://www.zhyd.me
 * @version 1.0
 * @date 2018/4/16 16:26
 * @since 1.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class BaseConditionVO {
    public final static int DEFAULT_PAGE_SIZE = 10;


    //每页数
    @TableField(exist = false)
    private int pageSize = 0;

    //分页当前索引
    @TableField(exist = false)
    private int pageIndex = 0;

    //排序字段
    @TableField(exist = false)
    private String orderField;

    //排序方向
    @TableField(exist = false)
    private String orderDirection;

    //关键字
    @TableField(exist = false)
    private String keywords;

    //开始时间
    @TableField(exist = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startDate;

    //结束时间
    @TableField(exist = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endDate;

    //数据校验是否通过,0通过,1未通过,默认空则为通过
    @TableField(exist = false)
    private Integer isValidator;


    public int getPageSize() {
        return pageSize > 0 ? pageSize : DEFAULT_PAGE_SIZE;
    }

    public int getPageStart() {
        return pageIndex > 0 ? (pageIndex - 1) * getPageSize() : 0;
    }


}
