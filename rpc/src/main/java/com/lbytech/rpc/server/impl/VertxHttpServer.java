package com.lbytech.rpc.server.impl;

import com.lbytech.rpc.handler.HttpServerHandler;
import com.lbytech.rpc.server.HttpServer;
import io.vertx.core.Vertx;
import lombok.extern.slf4j.Slf4j;

/**
 * Vertx HTTP服务器
 */
@Slf4j
public class VertxHttpServer implements HttpServer {

    /**
     * 启动服务器
     * @param port
     */
    @Override
    public void doStart(int port) {
        // 创建Vert.x实例
        Vertx vertx = Vertx.vertx();

        //创建HTTP服务器
        io.vertx.core.http.HttpServer server = vertx.createHttpServer();

        //监听端口并处理请求
        server.requestHandler(new HttpServerHandler());

        //启动HTTP服务器并监听指定端口
        server.listen(port, result -> {
            if (result.succeeded()) {
                log.info("server is listening on port: " + port);
            }
            else {
                log.error("Failed to start server: " + result.cause());
            }
        });
    }
}
