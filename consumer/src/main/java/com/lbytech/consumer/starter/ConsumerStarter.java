package com.lbytech.consumer.starter;

import com.lbytech.common.model.User;
import com.lbytech.common.service.UserService;

public class ConsumerStarter {

    public static void main(String[] args) {
        //todo 需要获取UserService的实现类对象
        UserService userService = null;

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
