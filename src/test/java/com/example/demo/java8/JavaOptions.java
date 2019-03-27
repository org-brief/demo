package com.example.demo.java8;

import com.example.demo.java8.domain.Apple;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class JavaOptions {

    public static Map<Integer, Apple> appleListToMap(List<Apple> apples) {
        return apples.stream().collect(Collectors.toMap(Apple::getId, a -> a, (k1, k2) -> k1));
    }

    public static void main(String[] args) {
        List<Apple> appleList = new ArrayList<>();//存放apple对象集合

        Apple apple1 =  new Apple(1,"苹果1",new BigDecimal("3.25"),10);
        Apple apple12 = new Apple(1,"苹果2",new BigDecimal("1.35"),20);
        Apple apple2 =  new Apple(2,"香蕉",new BigDecimal("2.89"),30);
        Apple apple3 =  new Apple(3,"荔枝",new BigDecimal("9.99"),40);

        appleList.add(apple1);
        appleList.add(apple12);
        appleList.add(apple2);
        appleList.add(apple3);

        Map<Integer, Apple> map = JavaOptions.appleListToMap(appleList);
        map.keySet().stream().forEach(i -> {
            System.out.println(i);
        });

        try {
            Thread.sleep(200000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
