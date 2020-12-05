package cn.chenc.framework.demo.controller;

import cn.chenc.framework.core.model.response.ResponseVO;
import cn.chenc.framework.core.model.response.ResultUtil;
import cn.chenc.framework.demo.entity.User;
import cn.chenc.framework.demo.service.UserService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 　@description: TODO
 * 　@author secret
 * 　@date 2020/11/30 10:13
 *
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/test")
    public ResponseVO test(){
        return ResultUtil.success("访问成功");
    }

    @GetMapping("/test2")
    public String test2(){
        return "success";
    }

    @GetMapping("/test3")
    public User test3(){
        return new User();
    }

    @GetMapping("/test4")
    public ResponseVO test4(){
        return ResultUtil.success(new User());
    }

    @PostMapping("/list")
    public ResponseVO queryUserPageList(@RequestBody User user){
        IPage iPage=userService.queryUserPageList(user);
        return ResultUtil.success(iPage);
    }

    @PostMapping("/add")
    public ResponseVO addUser(@RequestBody User user) {
        return userService.addUser(user);
    }


}
