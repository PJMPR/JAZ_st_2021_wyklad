package com.pjwstk.websockets.client;

import com.pjwstk.websockets.contract.MyMessage;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;

import java.util.Scanner;

@SpringBootApplication
public class WebsocketsClientApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(WebsocketsClientApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        WebSocketClient client = new StandardWebSocketClient();

        WebSocketStompClient stompClient = new WebSocketStompClient(client);
        stompClient.setMessageConverter(new MappingJackson2MessageConverter());


        var connection = stompClient.connect("ws://localhost:8080/chat", new ChatStompSesionHandler());

        new Scanner(System.in).nextLine();

        connection.get().send("/websocket/chat", new MyMessage("nowy", "kolejny test"));
        new Scanner(System.in).nextLine();
    }
}
