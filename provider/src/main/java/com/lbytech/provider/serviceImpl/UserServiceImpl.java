package com.lbytech.provider.serviceImpl;

import com.lbytech.common.model.User;
import com.lbytech.common.service.UserService;

/**
 * 用户服务实现类
 */
public class UserServiceImpl implements UserService {

    @Override
    public User getUser(User user) {
        System.out.println("用户名" + user.getName());
        return user;
    }
}
