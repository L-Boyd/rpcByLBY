package com.lbytech.provider.starter;

import com.lbytech.rpc.server.HttpServer;
import com.lbytech.rpc.server.impl.VertxHttpServer;

public class ProviderStarter {

    public static void main(String[] args) {
        //启动web服务
        HttpServer httpServer = new VertxHttpServer();
        httpServer.doStart(8080);
    }
}
