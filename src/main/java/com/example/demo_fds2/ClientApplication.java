package com.example.demo_fds2;

import com.example.demo_fds2.TransactionEnginee.NetworkCfg.NetworkCfg;
import reactor.core.publisher.Mono;
import reactor.netty.ByteBufFlux;
import reactor.netty.Connection;
import reactor.netty.http.client.HttpClient;
import reactor.netty.tcp.TcpClient;

import java.util.List;

public class ClientApplication {
    public static void main(String[] args) {
        HttpClient client = HttpClient.create();

        client.post()
                .uri("https://example.com/")
                .send(ByteBufFlux.fromString(Mono.just("hello")))
                .response()
                .block();
    }
}

