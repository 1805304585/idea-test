package com.lianglongwei.config;


import com.lianglongwei.properrties.RedisProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author LLW
 * @Date 2020/3/30.
 * @Description redis配置类
 **/
@Configuration
public class RedisConfig {
    @Autowired
    private RedisProperties redisProperties;
    @Bean
    public JedisCluster getJedisCluster(){
        String nodes = redisProperties.getNodes();
        String[] ipAndPorts = nodes.split(",");
        Set<HostAndPort> set = new HashSet<>();
        for (String ipAndPort : ipAndPorts) {
            String[] hostPort = ipAndPort.split(":");
            HostAndPort hostAndPort = new HostAndPort(hostPort[0],Integer.parseInt(hostPort[1]));
            set.add(hostAndPort);
        }
        JedisCluster cluster = new JedisCluster(set,redisProperties.getCommandTimeout(),redisProperties.getMaxAttempts());
        return cluster;
    }
}
