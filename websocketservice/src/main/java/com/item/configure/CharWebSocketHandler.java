package com.item.configure;

import com.alibaba.fastjson.JSON;
import com.item.bean.Chat;
import com.item.service.ChatService;
import com.item.tool.StringToBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.*;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.Map;

@Component
public class CharWebSocketHandler implements WebSocketHandler {
    Logger logger= LoggerFactory.getLogger(getClass());
    @Autowired
    ChatService service;
    @Override
    public void afterConnectionEstablished(WebSocketSession webSocketSession) throws Exception {

        Map<String,Object> map=webSocketSession.getAttributes();

        String account=map.get("userAccount").toString();

        String username=map.get("userName").toString();

        PublicAttribute.webSocketMap.put(webSocketSession.getId(),webSocketSession);

        PublicAttribute.accountIdMap.put(account,webSocketSession.getId());

        PublicAttribute.sessionIdMap.put(webSocketSession.getId(),account);

//        WebSocketMessage<?> webSocketMessage=new TextMessage("系统通知:"+username+"大摇大摆的进入了聊天室");

//        sendMessageAll(webSocketSession,webSocketMessage,true);

        System.out.println(username+"------连接建立");

    }

//    @Override
//    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
//
//    }

    @Override
    public void handleMessage(WebSocketSession webSocketSession, WebSocketMessage<?> message) throws Exception {
        

//        Object requestBody=webSocketMessage.getPayload();
//        TextMessage textMessage= (TextMessage)webSocketMessage;
//        logger.info(requestBody);
//        System.out.println(JSON.parseObject((String) webSocketMessage.getPayload()));

//        System.out.println(message.getPayload());
//        System.out.println(message.toString());
        String sendAccount=webSocketSession.getAttributes().get("userAccount").toString();

        Map<String,Object> map= JSON.parseObject(message.getPayload().toString(),Map.class);
        Object he=map.get("header");
        Object bo=map.get("body");

        Map<String,Object> header= JSON.parseObject(he.toString(),Map.class);
        Map<String,Object> body= JSON.parseObject(bo.toString(),Map.class);

        String status=header.get("status").toString();
        String acceptAccount=header.get("accept").toString();
        String text=body.get("message").toString();

        addToDatabase(StringToBean.stringToChat(sendAccount,acceptAccount,text));

        System.out.println(acceptAccount);

        sendMessageToUser(acceptAccount,message);

//        String sendAccount=webSocketSession.getAttributes().get("userAccount").toString();
//

//
//        String message=requestBody.get("message").toString();
//
//        String time=requestBody.get("time").toString();
//

//
//
//
//        sendMessageToUser(sendAccount,webSocketMessage);

    }


    public boolean addToDatabase(Chat chat){
        boolean p=service.sendMessage(chat);
        return p;
    }
    @Override
    public void handleTransportError(WebSocketSession webSocketSession, Throwable throwable) throws Exception {

    }

    @Override
    public void afterConnectionClosed(WebSocketSession webSocketSession, CloseStatus closeStatus) throws Exception {
        String id= webSocketSession.getId();
        String account=PublicAttribute.sessionIdMap.get(id);
        PublicAttribute.webSocketMap.remove(id);
        PublicAttribute.sessionIdMap.remove(id);
        PublicAttribute.accountIdMap.remove(account);
        System.out.println(PublicAttribute.accountIdMap.get(account));


        new Thread(()->{

            try {
                //判断用户是断开连接还是下线
                Thread.sleep(5000);
                if (PublicAttribute.accountIdMap.get(account)==null){
                    System.out.println(account+"-------已下线");
                    PublicAttribute.sessionMap.remove(account);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }

    public void sendMessageAll(WebSocketSession webSocketSession,WebSocketMessage<?> webSocketMessage,boolean system) throws IOException {
        for (WebSocketSession session:PublicAttribute.webSocketMap.values()) {
            new Thread(()->{
                try {
                    if (!session.getId().equals(webSocketSession.getId()))
                        session.sendMessage(webSocketMessage);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        }

    }
    public void sendMessageToUser(String acceptAccount,WebSocketMessage<?> webSocketMessage){

        WebSocketSession webSocketSession=null;
        try {

            String sessionId=PublicAttribute.accountIdMap.get(acceptAccount);

            webSocketSession=PublicAttribute.webSocketMap.get(sessionId);

            System.out.println(webSocketSession==null);

            if (webSocketSession==null)
                return;

            webSocketSession.sendMessage(webSocketMessage);

        }catch (IOException e){
            logger.info("message send error path com.item.configure.sendMessageToUser");
        }
        catch (Exception e){
            logger.info("webSocketSession is empty user no online");
            return;
        }


    }
}
