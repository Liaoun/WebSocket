package com.item.controller;

import com.item.bean.Chat;
import com.item.bean.User;
import com.item.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("chat")
public class ChatController {
    @Autowired
    ChatService service;
    @RequestMapping("contentByUser")
    public HttpEntity getChatContentByUser(User user){

        return new HttpEntity(null);
    }

    @RequestMapping("getLastChatAcceptId")
    public String getLastChatAcceptId(User user){
        return service.getLastChatId(user);
    }

    @RequestMapping("getLastChatContent")
    public List<Chat> getLastChatContent(String send,String accpet){
        return service.getChatContent(send,accpet);
    }
    @PostMapping("addChatRecord")
    public boolean addChatRecord(Chat chat){
        boolean r=false;
        try {
            r=service.sendMessage(chat);
        }catch (Exception e){

        }
       return r;
    }
}
