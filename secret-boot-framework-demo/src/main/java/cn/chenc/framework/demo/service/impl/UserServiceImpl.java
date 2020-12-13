package cn.chenc.framework.demo.service.impl;

import cn.chenc.framework.cache.annotation.RedisCache;
import cn.chenc.framework.core.model.response.ResponseVO;
import cn.chenc.framework.core.model.response.ResultUtil;
import cn.chenc.framework.demo.entity.User;
import cn.chenc.framework.demo.mapper.UserMapper;
import cn.chenc.framework.demo.service.UserService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 　@description: TODO
 * 　@author secret
 * 　@date 2020/11/30 10:09
 *
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    @RedisCache(expire = 0)
    public IPage queryUserPageList(User user) {
        IPage page=new Page(user.getPageIndex(),user.getPageSize());
        IPage iPage=this.page(page,null);
        return iPage;
    }

    @Override
    @Transactional
    @RedisCache(flush = true)
    public ResponseVO addUser(User user) {
        this.save(user);
        return ResultUtil.success("添加成功");
    }

    @Override
    @RedisCache(flush = true)
    public ResponseVO cheanCache(){
        return ResultUtil.success("清除缓存成功");
    }
}
