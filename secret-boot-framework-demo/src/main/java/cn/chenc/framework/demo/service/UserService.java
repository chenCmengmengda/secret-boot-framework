package cn.chenc.framework.demo.service;

import cn.chenc.framework.core.model.response.ResponseVO;
import cn.chenc.framework.demo.entity.User;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 　@description: TODO
 * 　@author secret
 * 　@date 2020/11/30 10:06
 *
 */
public interface UserService extends IService<User> {
    IPage queryUserPageList(User user);
    ResponseVO addUser(User user);
}
