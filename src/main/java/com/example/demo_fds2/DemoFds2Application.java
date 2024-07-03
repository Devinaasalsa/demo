package com.example.demo_fds2;

import com.example.demo_fds2.TransactionEnginee.NetworkCfg.NetworkCfg;
import com.example.demo_fds2.TransactionEnginee.NetworkCfg.NetworkCfgService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.core.Ordered;
// import reactor.core.publisher.Mono;
import reactor.netty.DisposableServer;
import reactor.netty.http.server.HttpServer;
import reactor.netty.tcp.TcpServer;

import java.util.List;

// import com.example.demo_fds2.PortConfig.PortValidationFilter;

@SpringBootApplication

public class DemoFds2Application {
    @Autowired
    private NetworkCfgService networkService;

    public static void main(String[] args) {
        SpringApplication.run(DemoFds2Application.class, args);
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
