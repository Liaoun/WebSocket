package com.item.service;

import com.item.bean.Chat;
import com.item.bean.User;
import com.item.mapper.ChatMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ChatService {

//    @Value("${pageHelper.count}")
    private int count;

//    @Value("${pageHelper.soncount}")
    private int soncount;

    /**
     * 当前获取总页数
     */
    private int nowcount;

    List<Chat> list;
    @Autowired
    ChatMapper mapper;

    /**
     * 分页查询 后期在做
     * @param
     * @return
     */
//    public List<Chat> getChatContent(User user,int page){
//
//        int accept=mapper.getLastChatId(user);
//
//
//
//
//    }

//    @Cacheable
    public List<Chat> getChatContent(String sendAccount,String acceptAccount){
       List<Chat> chats= mapper.getLastChatContent(sendAccount,acceptAccount);
       System.out.println(chats.get(0).getSend().getUsername());
       return chats;
    }

    public String getLastChatId(User user){
        String accept=mapper.getLastChatId(user);
        return accept;
    }

    public List<Chat> getData(int page){
        return null;
    }

    public Boolean sendMessage(Chat chat){
        int i=mapper.sendMessage(chat);
        return i>0?true:false;
    }
}
