package com.atguigu.gmall.order.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmall.bean.UserInfo;
import com.atguigu.gmall.service.UserInfoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserInfoController {

    @Reference
    private UserInfoService userInfoService;
    //查询所有
    @RequestMapping("getAll")
    public List<UserInfo> getAllUser(){
        List<UserInfo> allUser = userInfoService.getAll();
        return allUser;
    }
    //添加
    @RequestMapping("add")
    public String addUserInfo(UserInfo userInfo){
        userInfoService.addUserInfo(userInfo);
        return "ok";
    }
    //修改 <= id
    @RequestMapping("updateById")
    public String updateById(String id){
        userInfoService.updateById(id);
        return "ok";
    }
    //修改<= condition
    @RequestMapping("updateByCondition")
    public boolean updateByCondition(UserInfo userInfo){

        return userInfoService.updateByCondition(userInfo);
    }
    //删除 <= id
    @RequestMapping("deleteById")
    public boolean deleteById(String id){
        return userInfoService.deleteById(id);
    }
    //删除 <= condition
    @RequestMapping("deleteByCondition")
    public boolean deleteByCondition(UserInfo userInfo){
        return userInfoService.deleteByCondition(userInfo);
    }
}
