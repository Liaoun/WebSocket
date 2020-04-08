package com.item.controller;

import com.alibaba.fastjson.JSON;
import com.item.bean.Chat;
import com.item.bean.User;
import com.item.functionInterface.controller.Login;
import com.item.service.ChatService;
import com.item.tool.MessageParse;
import com.item.configure.PublicAttribute;
import com.item.service.UserService;
import javafx.geometry.Pos;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RequestMapping("user")
@RestController
public class UserController {
    MessageParse messageParse=new MessageParse();
    @Autowired
    UserService service;
    @Autowired
    ChatService chatService;
    Logger logger=LoggerFactory.getLogger(getClass());

    /**
     * version 2.0
     * @param us
     * @return
     */
    @PostMapping("login")
    public Map<String,String> userLogin(User us){
        Map<String,String> map=new HashMap<>();

        User user=service.userLogin(us);
        if (user==null){
            map.put("status","404");
        }

        map.put("data",user.toString());
        map.put("status","200");
        return map;
    }


    /**
     * version 2.0
     * @param user
     * @return
     */
    @PostMapping("signUp")
    public Boolean signUpUser(User user){
        Boolean r=false;
        try {
            r= service.signUpUser(user);
        }catch (Exception e){
            logger.error("add an exception ----添加出现异常");
        }

        return r;

    }


    /**
     * version 1.0
     * @param entity
     * @return
     */
//    @PostMapping("signUp")
//    public HttpEntity signUpUser(HttpEntity entity){
//
//        String body=entity.getHeaders().get("user").toString();
//        User user=messageParse.userParse(body);
//        Boolean r=false;
//        try {
//            r= service.signUpUser(user);
//        }catch (Exception e){
//            logger.error("add an exception ----添加出现异常");
//        }
//        HttpEntity httpEntity=new HttpEntity(r);
//        return httpEntity;
//
//    }

    /**
     * version 1.0
     * @param entity
     * @param request
     * @return
     */
//    @PostMapping("login")
//    public HttpEntity userLogin(HttpEntity entity,HttpServletRequest request){
//        /**
//         * result为返回给前端的数据
//         */
//        Map<String,Object> result=new HashMap<>();
//        /**
//         * map 为前端传的数据
//         */
//        Map<String,Object> map= (Map<String, Object>) entity.getBody();
//        Object userstring=map.get("user");
//        User user= JSON.parseObject(userstring.toString(),User.class);
//
//
//        HttpSession session=request.getSession();
//        HttpEntity httpEntity =null;
//        if (PublicAttribute.sessionMap.get(user.getAccount())!=null){
//            result.put("status","already");
//            httpEntity=new HttpEntity(JSON.toJSONString(result));
//            return httpEntity;
//        }
//        User ret=service.userLogin(user);
//        if (ret==null){
//            result.put("status","error account or password error");
//            httpEntity=new HttpEntity(JSON.toJSONString(result));
//            return httpEntity;
//        }
//        String acceptAccount=chatService.getLastChatId(ret);
//        List<Chat> chats=chatService.getChatContent(ret.getAccount(),acceptAccount);
//        result.put("status","loginSucceed");
//        session.setAttribute("acceptAccount",acceptAccount);
//        session.setAttribute("lastchat",chats);
//
//        httpEntity=new HttpEntity(JSON.toJSONString(result));
//        session.setAttribute("user",ret);
//        PublicAttribute.sessionMap.put(user.getAccount(),session);
//        return httpEntity;
//    }
//
//    @PostMapping("signUp")
//    public HttpEntity signUpUser(HttpEntity entity){
//
//        String body=entity.getHeaders().get("user").toString();
//        User user=messageParse.userParse(body);
//        Boolean r=false;
//        try {
//           r= service.signUpUser(user);
//        }catch (Exception e){
//            logger.error("add an exception ----添加出现异常");
//        }
//        HttpEntity httpEntity=new HttpEntity(r);
//        return httpEntity;
//
//    }

    /**
     * version 2.0
     * @param user
     * @return
     */
    @PostMapping("updatePwd")
    public boolean updatePwd(User user){
        boolean r=false;
        try {
            r=service.updatePwd(user);
        }catch (Exception e){
            logger.error("run time exception update user password");
        }

        return r;
    }

    /**
     * version 1.0
     * @param entity
     * @return
     */
//    @PostMapping("updatePwd")
//    public HttpEntity updatePwd(HttpEntity entity){
//
//        String val=entity.getHeaders().get("user").toString();
//        User user=messageParse.userParse(val);
//        Boolean r=service.updatePwd(user);
//        return new HttpEntity(r);
//    }
}
