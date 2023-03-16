package com.x14n.stuCase.controller;


import com.x14n.stuCase.redisDemo.RedisDemoApplication;
import com.x14n.stuCase.redisDemo.bo.Product;
import com.x14n.stuCase.redisDemo.constant.ResponseEnum;
import com.x14n.stuCase.redisDemo.utils.RedisCache;
import com.x14n.stuCase.redisDemo.utils.RedisUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.annotation.Target;
import java.util.HashMap;



@SpringBootTest(classes = RedisDemoApplication.class)
public class RedisTest {

    @Autowired
    RedisCache redisCache;


    @Test
    public void saveObject(){
        HashMap<String, String> objectObjectHashMap = new HashMap<>();
        Product product = new Product(1,"levis","white","33",100,"xxxxx/xxxxx/xxxx");
        objectObjectHashMap.put("id",product.getId().toString());
        objectObjectHashMap.put("brand",product.getBrand());
        redisCache.setCacheObject("产品",objectObjectHashMap);
    }
}
