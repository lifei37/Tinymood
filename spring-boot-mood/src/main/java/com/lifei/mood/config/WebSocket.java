package com.lifei.mood.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lifei.mood.services.PersonMessageTableService;
import com.lifei.mood.services.WordMessageTableService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@Component
@ServerEndpoint("/websocket/{username}")
public class WebSocket {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    // 在线人数
    public static int onlineNumber=0;
    //以用户的姓名为key，websocket为对象保存起来
    private static Map<String, WebSocket> clients = new ConcurrentHashMap<String, WebSocket>();
    //会话
    private Session session;
    // 用户名称
    private String username;
    //注入服务
    private static WordMessageTableService wordMessageTableService;
    private static PersonMessageTableService personMessageTableService;
    // 建立连接
    @OnOpen
    public void onOpen(@PathParam("username") String username, Session session){
        onlineNumber++;
        logger.info("现在来连接的客户id："+session.getId()+"用户名："+username);
        this.username = username;
        this.session = session;
        logger.info("有新连接加入！ 当前在线人数" + onlineNumber);
        try{
            //messageType 1代表上线，2代表下线，3代表在线名单4代表普通消息
            //先给所有人发送通知，说我上线了
            Map<String,Object> map1 = new HashMap<>();
            map1.put("messageType", 1);
            map1.put("username", username);
            sendMessageAll(JSON.toJSONString(map1), username);
            //把自己的信息加入到map中去
            clients.put(username, this);
            //给自己发一条消息 告诉自己现在都有谁在线
            Map<String, Object> map2 = new HashMap<>();
            map2.put("messageType", 3);
            Set<String> set = clients.keySet();
            map2.put("onlineUser", set);
//            sendMessageTo(JSON.toJSONString(map2), username, username);
        }catch (IOException e){
            logger.info(username+"上线的时候通知所有人发生了错误");
        }
    }

    @OnError
    public void onError(Session session, Throwable error){
        logger.info("服务器发生了错误" + error.getMessage());
    }


    @OnClose
    public void onClose(){
        onlineNumber--;
        clients.remove(username);
        try {
            //messageType 1代表上线，2代表下线，3代表在线名单4代表普通消息
            Map<String, Object> map1 = new HashMap<>();
            map1.put("messageType", 2);
            map1.put("onlineUsers", clients.keySet());
            map1.put("username", username);
            sendMessageAll(JSON.toJSONString(map1), username);
        }catch (IOException e){
            logger.info(username+"通知所有人下线时发生了错误");
        }
    }

    @OnMessage
    public void onMessage(String message, Session session){
        try{
            logger.info("来自客户端的消息是：" + message + "客户端的id是：" + session.getId());
            JSONObject jsonObject = JSON.parseObject(message);
            String textMessage = jsonObject.getString("message");
            String otherNickName = jsonObject.getString("nickname");
            String fromusername = jsonObject.getString("username");
            String avatar = jsonObject.getString("avatar");
            String tousername = jsonObject.getString("to");
            Integer userId = jsonObject.getInteger("userid");
            Integer toUserId = jsonObject.getInteger("touserid");
            //如果不是发给所有人，那么就是发给一个人
            //messageType 1代表上线，2代表下线，3代表在线名单4代表普通消息
            Map<String,Object> map1 = new HashMap<>();
            map1.put("messageType",4);
            map1.put("textMessage",textMessage);
            map1.put("otherNickName",otherNickName);
            map1.put("username", fromusername);
            map1.put("avatar", avatar);
            map1.put("userId", userId);

            if(tousername.equals("All")){
                map1.put("tousername", "所有人");
                System.out.println(map1+"====22");
                sendMessageAll(JSON.toJSONString(map1),fromusername);
                int w = insertWordMsg(map1);
            }else {
                map1.put("tousername", tousername);
                map1.put("toUserId", toUserId);
                System.out.println(map1+"====");
                sendMessageTo(JSON.toJSONString(map1), tousername, fromusername);
                int p = insertPersonMsg(map1);
            }
        }catch (IOException e){
            logger.info("发生错误了" );
        }
    }

    public void sendMessageTo(String message,String ToUserName,String FromUserName) throws  IOException{
        for(WebSocket item : clients.values()){
            if(item.username.equals(ToUserName)||item.username.equals(FromUserName)){
                item.session.getAsyncRemote().sendText(message);
            }

        }
    }


    public void sendMessageAll(String message, String FromUserName) throws IOException {
        for(WebSocket item : clients.values()){
            item.session.getAsyncRemote().sendText(message);
        }
    }

    public static synchronized int getOnlineNumber(){
        return onlineNumber;
    }

    @Autowired
    public void setWordMessageTableService(WordMessageTableService wordMessageTableService){
        WebSocket.wordMessageTableService = wordMessageTableService;
    }
    @Autowired
    public void setPersonMessageTableService(PersonMessageTableService personMessageTableService){
        WebSocket.personMessageTableService = personMessageTableService;
    }

    public int insertWordMsg(Map map1){
        int w = wordMessageTableService.insertWordMessage(map1);
        return w;
    }

    public int insertPersonMsg(Map map1){
        int p = personMessageTableService.insertPersonMessage(map1);
        return p;
    }


}
