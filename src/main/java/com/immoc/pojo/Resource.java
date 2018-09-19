package com.immoc.pojo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration // 代表这是一个配置文件会引用一些配置
@ConfigurationProperties(prefix = "com.imooc.opensource") // 配置参数的前缀，对应资源文件的参数名前缀
@PropertySource(value = "classpath:resource.properties") // 资源文件的地址
@Data
public class Resource {

    private String name;

    private String website;

    private String language;
}
