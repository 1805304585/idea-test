package com.lianglongwei.utils;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

/**
 * @Author LLW
 * @Date 2020/3/30.
 * @Description TODO
 **/
public class JsonUtils {
    //私有构造方法
    private JsonUtils(){}
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
/**
 * @Author LLW
 * @Description 对象转换json字符转
 * @Date 2020/3/30
 * @Param [object]
 * @return java.lang.String
 **/
    public static String toJsonString(Object object) {
        try {
            String jsonString = OBJECT_MAPPER.writeValueAsString(object);
            return jsonString;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * @Author LLW
     * @Description json转对象  beanType所需要转换对象的目标类型
     * @Date 2020/3/30
     * @Param [jsonData, beanType]
     * @return T
     **/
    public static <T> T toObject(String jsonData, Class<T> beanType) {
        try {
            T t = OBJECT_MAPPER.readValue(jsonData, beanType);
            return t;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * @Author LLW
     * @Description json转list
     * @Date 2020/3/30
     * @Param
     * @return
     **/
    public static <T> List<T> toList(String jsonData, Class<T> beanType) {
        JavaType javaType = OBJECT_MAPPER.getTypeFactory().constructParametricType(List.class, beanType);
        try {
            if(jsonData!=null&&!"".equals(jsonData)){
                List<T> list = OBJECT_MAPPER.readValue(jsonData, javaType);
                return list;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
