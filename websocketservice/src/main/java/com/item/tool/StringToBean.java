package com.item.tool;

import com.item.bean.Chat;
import com.item.bean.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringToBean {
    static Logger logger= LoggerFactory.getLogger(StringToBean.class);
    public static Chat stringToChat(String sendAccount, String acceptAccount, String message){
        Chat chat=new Chat();
        try {
            chat.setSend(new User(sendAccount));
            chat.setAccept(new User(acceptAccount));
            chat.setMessage(message);
        }catch (Exception e){
            logger.error("string to Chat error path com.item.tool.StringToBean.stringToChat");
        }

        return chat;
    }



    public static Timestamp stringToTime(String time){
        Timestamp timestamp = null;

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Date date = null; //初始化date

        try {

            date = sdf.parse(time); //Mon Jan 14 00:00:00 CST 2013
            timestamp  = new Timestamp(date.getTime());
        } catch (ParseException e) {
            logger.error("string to time error path com.item.tool.StringToBean.stringToTime");

        }
        return timestamp;
    }
}
