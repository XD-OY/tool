package com.chaos.tool.service;

import com.chaos.tool.entity.UserInfo;

public interface IuserService {
    UserInfo findByUserCode(String userCode);
}
