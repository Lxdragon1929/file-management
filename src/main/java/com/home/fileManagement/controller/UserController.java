package com.home.fileManagement.controller;

import com.home.fileManagement.module.common.Pagination;
import com.home.fileManagement.module.req.UserReq;
import com.home.fileManagement.module.res.UserRes;
import com.home.fileManagement.servie.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author LX
 * @since 2021/3/24 9:54
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 添加或修改用户
     * @param req
     * @return
     */
    @PostMapping("/addOrUpdate")
    public UserRes addOrUpdate(@RequestBody UserReq req){
        return userService.addOrUpdate(req);
    }

    /**
     * 删除用户
     * @param id
     * @return
     */
    @PostMapping("/delete")
    public boolean delete(String id) {
        return userService.delete(id);
    }

    /**
     * 用户详情
     * @param id
     * @return
     */
    @GetMapping("/detail")
    public UserRes detail(String id){
        return userService.detail(id);
    }

    /**
     * 用户列表
     * @param userName
     * @param page
     * @param pageSize
     * @return
     */
    @GetMapping("/list")
    public Pagination<UserRes> list(String userName, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10")int pageSize){
        return userService.list(userName, page, pageSize);
    }



}
