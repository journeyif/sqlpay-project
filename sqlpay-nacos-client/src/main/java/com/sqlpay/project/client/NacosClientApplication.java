package com.sqlpay.project.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Nacos Client 工程启动入口
 *
 * @author xiangy
 */
@ServletComponentScan
@EnableDiscoveryClient
@SpringBootApplication
public class NacosClientApplication {

    public static void main(String[] args) {

        SpringApplication.run(NacosClientApplication.class, args);
    }
}
