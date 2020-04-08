package com.item.controller;

import com.item.bean.Chat;
import com.item.bean.User;
import com.item.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ChatController {
    @Autowired
    ChatService service;
//    @RequestMapping("contentByUser")
//    public HttpEntity getChatContentByUser(User user){
//
//        return new HttpEntity(null);
//    }

    @PostMapping("getLastChatAcceptId")
    public String getLastChatAcceptId(@RequestParam("user") User user){
        return service.getLastChatId(user);
    }

    @PostMapping("getLastChatContent")
    public List<Chat> getLastChatContent(@RequestParam("send") String send, @RequestParam("accept") String accpet){
        return service.getChatContent(send,accpet);
    }
    @PostMapping("addChatRecord")
    public boolean addChatRecord(@RequestParam("chat") Chat chat){
        boolean r=false;
        try {
            r=service.sendMessage(chat);
        }catch (Exception e){

        }
       return r;
    }
}
