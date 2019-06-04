package com.atguigu.gmall.user.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.atguigu.gmall.bean.UserInfo;
import com.atguigu.gmall.service.UserInfoService;
import com.atguigu.gmall.user.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    /**
     * 查询所有用户信息
     * @return
     */
    @Override
    public List<UserInfo> getAll() {
        List<UserInfo> userInfos = userInfoMapper.selectAll();
        return userInfos;
    }

    /**
     * 增加一条用户信息
     * @param userInfo
     */
    @Override
    public void addUserInfo(UserInfo userInfo) {
        UserInfo userInfo1 = new UserInfo();
        userInfo.setLoginName("测试添加");
        userInfo.setPasswd("202cb962ac59075b964b07152d234b70");
        userInfo.setEmail("ceshi@qq.com");
        userInfoMapper.insertSelective(userInfo);
    }

    /**
     * 根据id修改
     * @param id
     */
    @Override
    public void updateById(String id) {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(id);
        userInfo.setLoginName("测试修改");
        userInfoMapper.updateByPrimaryKeySelective(userInfo);
    }

    /**
     * 根据condition修改
     * @param userInfo
     * @return
     */
    @Override
    public boolean updateByCondition(UserInfo userInfo) {
        UserInfo user = new UserInfo();
        user.setLoginName("根据condition修改");
        Example example = new Example(UserInfo.class);
        example.createCriteria().andEqualTo("name","张三");
        int i = userInfoMapper.updateByExampleSelective(user, example);
        return i>0;
    }

    /**
     * 根据id 删除
     * @param id
     * @return
     */
    @Override
    public boolean deleteById(String id) {
        int i = userInfoMapper.deleteByPrimaryKey(id);
        return i>0;
    }

        @Override
        public boolean deleteByCondition(UserInfo userInfo) {

            int delete = userInfoMapper.delete(userInfo);

            return delete>0;
    }

}
