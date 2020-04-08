package com.item.configure;

//import org.springframework.web.socket.WebSocketSession;

//import org.springframework.web.socket.WebSocketSession;

//import org.springframework.web.socket.WebSocketSession;

import org.springframework.web.socket.WebSocketSession;

import javax.servlet.http.HttpSession;
import java.util.Hashtable;
import java.util.Map;

/**
 * 公共属性
 */
public class PublicAttribute {

    /**
     * account session
     */
    public static Map<String, HttpSession> sessionMap =new Hashtable<>();

    /**
     * webSocketSessionId account
     */
    public static Map<String,String> sessionIdMap =new Hashtable<>();

    /**
     * account webSocketSessionId
     */
    public static Map<String,String> accountIdMap =new Hashtable<>();

    /**
     * webSocketSessionId webSocketSession
     */
    public static Map<String, WebSocketSession> webSocketMap=new Hashtable<>();
}
