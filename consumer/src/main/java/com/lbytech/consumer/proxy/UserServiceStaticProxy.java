package com.lbytech.consumer.proxy;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import com.lbytech.common.model.User;
import com.lbytech.common.service.UserService;
import com.lbytech.rpc.model.RpcRequest;
import com.lbytech.rpc.model.RpcResponse;
import com.lbytech.rpc.serializer.Serializer;
import com.lbytech.rpc.serializer.impl.JdkSerializer;

import java.io.IOException;

/**
 * 静态代理
 */
public class UserServiceStaticProxy implements UserService {
    @Override
    public User getUser(User user) {
        // 指定序列化器
        Serializer serializer = new JdkSerializer();

        // 发请求
        RpcRequest rpcRequest = RpcRequest.builder()
                .serviceName(UserService.class.getName())
                .methodName("getUser")
                .parameterTypes(new Class[]{User.class})
                .args(new Object[]{user})
                .build();

        try {
            byte[] bodyBytes = serializer.serialize(rpcRequest);
            byte[] result;
            // 下面这个try是jdk7引入的新写法，HttpResponse会自动close
            try (HttpResponse httpResponse = HttpRequest.post("http://localhost:8080")
                    .body(bodyBytes)
                    .execute()) {
                result = httpResponse.bodyBytes();
            }
            RpcResponse rpcResponse = serializer.deserialize(result, RpcResponse.class);
            return (User) rpcResponse.getData();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
