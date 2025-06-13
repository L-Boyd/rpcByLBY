package com.lbytech.consumer.starter;

import com.lbytech.common.model.User;
import com.lbytech.common.service.UserService;
import com.lbytech.consumer.proxy.UserServiceStaticProxy;

public class ConsumerStarter {

    public static void main(String[] args) {
        // 测试静态代理
        UserService userService = new UserServiceStaticProxy();

        User user = new User();
        user.setName("lby");

        //调用
        User newUser = userService.getUser(user);
        if (newUser != null) {
            System.out.println(newUser.getName());
        }
        else {
            System.out.println("user is null");
        }
    }
}
