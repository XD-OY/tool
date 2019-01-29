package com.chaos.tool.dao;

import com.chaos.tool.entity.UserInfo;

public interface userDao {

    UserInfo findByUserCode(String userCode);
}
