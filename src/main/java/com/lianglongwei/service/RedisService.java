package com.lianglongwei.service;


import com.lianglongwei.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisCluster;

import java.util.List;

/**
 * @Author LLW
 * @Date 2020/3/30.
 * @Description redis的service
 **/
@Service
public class RedisService<T> {
    @Autowired
    JedisCluster cluster;
    /**
     * @Author LLW
     * @Description 往redis中存数据
     * @Date 2020/3/30
     * @Param [key, value]
     * @return java.lang.String
     **/
    public Boolean set(String key,Object value){
         return cluster.set(key, JsonUtils.toJsonString(value)).toUpperCase().equals("OK");
    }
    /**
     * @Author LLW
     * @Description 从redis中删除数据
     * @Date 2020/3/30
     * @Param [key]
     * @return java.lang.Long
     **/
    public Boolean delete(String key){
        return cluster.del(key)>0;
    }
    /**
     * @Author LLW
     * @Description 从redis中获取
     * @Date 2020/3/30
     * @Param [key]
     * @return java.util.List<T>
     **/
    public List<T> getList(String key){
        try {
            return (List<T>) JsonUtils.toList(cluster.get(key),Object.class);
        } catch (Exception e) {
            // System.out.println("list为空");
            e.printStackTrace();
        }
        return null;
    }
}
