package com.chaos.tool.service.impl;

import com.chaos.tool.entity.UserInfo;
import com.chaos.tool.dao.userDao;
import com.chaos.tool.service.IuserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class userService implements IuserService{

    @Autowired
    userDao userDao;

    @Override
    public UserInfo findByUserCode(String userCode) {
        return userDao.findByUserCode(userCode);
    }
}
