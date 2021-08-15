package com.sqlpay.project.admin;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 监控中心服务器启动入口
 *
 * @author xiangy
 */
@EnableAdminServer
@SpringBootApplication
public class AdminApplication {

    public static void main(String[] args) {

        SpringApplication.run(AdminApplication.class, args);
    }
}
