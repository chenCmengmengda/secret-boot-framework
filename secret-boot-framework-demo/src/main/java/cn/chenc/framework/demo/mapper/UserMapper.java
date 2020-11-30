package cn.chenc.framework.demo.mapper;

import cn.chenc.framework.demo.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 　@description: TODO
 * 　@author secret
 * 　@date 2020/11/30 10:03
 *
 */
@Mapper
@Repository
public interface UserMapper extends BaseMapper<User> {
}
