package com.atguigu.gmall.service;


import com.atguigu.gmall.bean.UserInfo;

import java.util.List;

public interface UserInfoService {
    List<UserInfo> getAll();

    void addUserInfo(UserInfo userInfo);

    void updateById(String id);

    boolean updateByCondition(UserInfo userInfo);

    boolean deleteById(String id);

    boolean deleteByCondition(UserInfo userInfo);
}
