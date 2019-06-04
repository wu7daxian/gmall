package com.atguigu.gmall.order.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmall.bean.UserAddress;
import com.atguigu.gmall.service.UserAddressService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class OrderController {

    @Reference
    private UserAddressService userAddressService;

    @RequestMapping("getAddressByUserId")
    @ResponseBody
    public List<UserAddress> getAddressByUserID(String userId){

        return userAddressService.getUserAddressList(userId);
    }

}
