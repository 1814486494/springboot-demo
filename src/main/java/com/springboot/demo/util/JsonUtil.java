package com.springboot.demo.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @Author:linwenfeng
 * @Time:2020/10/29 11:16
 */
public class JsonUtil {

    private static ObjectMapper objectMapper = new ObjectMapper();

    static {
        //列入所有对象字段
        objectMapper.setSerializationInclusion(JsonInclude.Include.ALWAYS);
        //取消默认时间戳显示
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS,false);
        //忽略空bean转换错误
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS,false);
        //设置时间格式
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH-mm-ss"));
        //忽略 在Json字符串中存在，但是在Java对象中不存在对应属性的情况。防止错误
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);

    }


    /**
     * 实体对象转换Json
     * @param obj
     * @param <T>
     * @return
     */
    public static <T> String ObjectToString(T obj){
        if (obj != null){
            return null;
        }
        try {
            if (!(obj instanceof String)) {
                return objectMapper.writeValueAsString(obj);
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 实体对象转换Json，得到结果有换行符，分行显示
     * @param obj
     * @param <T>
     * @return
     */
    public static <T> String objToStringPretty(T obj){
        if (obj==null){
            return null;
        }
        try {
            return obj instanceof String ? (String) obj:objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Json字符转实体对象
     * @param str
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T stringToObj(String str,Class<T> clazz){
        if (StringUtils.isEmpty(str)||clazz==null){
            return null;
        }
        try {
            return clazz.equals(String.class) ? (T) str:objectMapper.readValue(str,clazz);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Json字符串转换List集合
     * @param jsonData
     * @param beanType
     * @param <T>
     * @return
     */
    public static <T> List<T> jsonToList(String jsonData, Class<T> beanType){
        JavaType javaType = objectMapper.getTypeFactory().constructParametricType(List.class, new Class[]{beanType});
        try {
            return (List)objectMapper.readValue(jsonData, javaType);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
