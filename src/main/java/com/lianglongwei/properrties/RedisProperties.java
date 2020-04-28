package com.lianglongwei.properrties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author LLW
 * @Date 2020/3/30.
 * @Description redis配置文件
 **/
@Component
@Data
@ConfigurationProperties(prefix = "hhn.redis")
public class RedisProperties {
    String nodes;
    private Integer maxAttempts;
    private Integer commandTimeout;
}
