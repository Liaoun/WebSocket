package com.item.mapper;

import com.item.bean.Chat;
import com.item.bean.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

@Mapper
public interface ChatMapper {

    /**
     * 得到用户最后一个聊天的id
     * @return
     */
    @Select("SELECT `acceptAccount` FROM chat WHERE sendAccount=${account} ORDER BY time DESC LIMIT 0,1")
    String getLastChatId(User user);

    /**
     * 分页查询 后期在做
     * 得到用户最后的聊天内容
     * @return
     */
//    @Select("SELECT `message`,`file`,`time`,`type` FROM chat where sendid " +
//            "in (${send},${accept}) and acceptid in (${send},${accept}) " +
//            "order BY `time` DESC  LIMIT ${page},${count}")
//    Chat getLastChatContent(int send,int accept,int page,int count);
    @Select("SELECT `message`,`file`,`time`,`type`,`sendAccount`,`acceptAccount` FROM chat where sendAccount " +
            "in (${send},${accept}) and acceptAccount in (${send},${accept}) " +
            "order BY `time` asc")
    @Results({
            @Result(column = "sendAccount",property = "send",one = @One(select = "com.item.mapper.ChatMapper.getSendUser",fetchType= FetchType.EAGER))
    })
    List<Chat> getLastChatContent(String send, String accept);

    @Select("select * from user where account= ${sendAccount}")
    User getSendUser(String sendAccount);

    /**
     * 发送消息
     */
    @Insert("INSERT INTO chat(sendAccount,acceptAccount,message,time,type) VALUES('${send.account}','${accept.account}','${message}',NOW(),1)")
    int sendMessage(Chat chat);
}
