package com.item.tool;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.item.bean.User;

/**
 * 基本工具
 */
public class MessageParse {

    /**
     * user消息转换
     * @param
     * @return
     */
    public User userParse(String message){
//        String message=headerStringParse(val);
        JSONObject parseObject = JSONArray.parseObject(message);
        String userstring=parseObject.getString("User");
        System.out.println("得到字符串--------"+userstring);
        User user=JSONObject.parseObject(userstring,User.class);
        return user;
    }

    /**
     * 去符号
     */

    public String headerStringParse(String obj){
        String val=obj.substring(1,obj.length()-1);
        return val;
    }
}
