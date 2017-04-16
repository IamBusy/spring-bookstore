package com.william.web;

import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by william on 16/04/2017.
 */
@ServerEndpoint(value = "chatroom")
@Component
public class Chatroom {

    private static long onlineCount = 0;

    private static CopyOnWriteArrayList<Chatroom> chatrooms = new CopyOnWriteArrayList<Chatroom>();

    private Session session;

    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
        chatrooms.add(this);
        addOnlineCount();

    }

    @OnClose
    public void onClose() {
        chatrooms.remove(this);
        subOnlineCount();

    }

    @OnMessage
    public void onMessage(String message, Session session) {
        for (Chatroom chatroom:chatrooms) {
            try {
                chatroom.sendMessage(message);
            }catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @OnError
    public void onError(Session session, Throwable t) {
        System.out.println("发生错误");
        t.printStackTrace();
    }

    public void sendMessage(String message) throws IOException {
        this.session.getBasicRemote().sendText(message);

    }

    public static synchronized long getOnlineCount() {
        return Chatroom.onlineCount;
    }

    public static synchronized void addOnlineCount() {
        Chatroom.onlineCount++;
    }

    public static synchronized void subOnlineCount() {
        Chatroom.onlineCount--;
    }



}
