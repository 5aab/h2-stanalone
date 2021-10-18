package com.org;

import org.h2.tools.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.SQLException;

@SpringBootApplication
public class H2Application {

    public static void main(String[] args) {
        SpringApplication.run(H2Application.class, args);
    }

    @Bean(initMethod = "start", destroyMethod = "stop")
    public Server initH2TCPServer() throws SQLException {
        return Server.createTcpServer("-ifNotExists", "-tcp", "-tcpAllowOthers", "-tcpPort", "9093");
    }
}
