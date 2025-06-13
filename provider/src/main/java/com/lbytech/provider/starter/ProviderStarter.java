package com.lbytech.provider.starter;

import com.lbytech.common.service.UserService;
import com.lbytech.provider.serviceImpl.UserServiceImpl;
import com.lbytech.rpc.registry.LocalRegistry;
import com.lbytech.rpc.server.HttpServer;
import com.lbytech.rpc.server.impl.VertxHttpServer;

public class ProviderStarter {

    public static void main(String[] args) {
        // 注册服务
        LocalRegistry.register(UserService.class.getName(), UserServiceImpl.class);

        // 启动web服务
        HttpServer httpServer = new VertxHttpServer();
        httpServer.doStart(8080);
    }
}
