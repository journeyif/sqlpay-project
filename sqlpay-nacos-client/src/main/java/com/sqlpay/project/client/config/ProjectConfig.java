package com.sqlpay.project.client.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 数据配置绑定
 *
 * @author xiangy
 */
@Data
@Component
@ConfigurationProperties(prefix = "project")
public class ProjectConfig {

    private String name;
    private String org;
    private String version;
    private String author;
}
