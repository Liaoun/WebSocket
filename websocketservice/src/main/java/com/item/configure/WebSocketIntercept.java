package com.item.configure;

import com.alibaba.fastjson.JSON;
import com.item.bean.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;

import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketHandler;

import org.springframework.web.socket.server.HandshakeInterceptor;

import java.util.Map;

@Component
public class WebSocketIntercept implements HandshakeInterceptor{

    @Override
    public boolean beforeHandshake(ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse, WebSocketHandler webSocketHandler, Map<String, Object> map) throws Exception {

        if (serverHttpRequest instanceof ServletServerHttpRequest){
            ServletServerHttpRequest request=(ServletServerHttpRequest)serverHttpRequest;
//            javax.servlet.http.HttpServletRequest servletRequest = request.getServletRequest();
//            String user1=
            User user= (User)request.getServletRequest().getSession().getAttribute("user");
            if (user!=null){
                map.put("userAccount",user.getAccount());
                map.put("userName",user.getUsername());
                return true;

            }
//            System.out.println("name2"+name2);
//            map.put("name",name2);
        }
        return false;
    }

    @Override
    public void afterHandshake(ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse, WebSocketHandler webSocketHandler, Exception e) {

    }
}
