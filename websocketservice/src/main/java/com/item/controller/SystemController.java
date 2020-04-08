package com.item.controller;

import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("system")
public class SystemController {

    /**
     * 实现session共享需要客服端在请求服务端时进行一次握手
     */
    @RequestMapping("handshake")
    public HttpEntity handshake(HttpEntity entity, HttpServletRequest request){
        System.out.println("handShake succeed"+request.getSession().getId());
        HttpEntity httpEntity=new HttpEntity("handShake succeed");
        return httpEntity;
    }

    @GetMapping("gateway")
    @ResponseBody
    public String gatewayDemo(){
        return "gateway";
    }
}
