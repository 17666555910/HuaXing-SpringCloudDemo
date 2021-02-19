package com.huaxing.designmode.singletonpattern.hungry;

import lombok.extern.slf4j.Slf4j;

/**
 * @Description 饿汉式单例测试类
 * @author: 姚广星
 * @time: 2021/2/19 17:56
 */
@Slf4j
public class HungrySingletonPatternTest {
    public static void main(String[] args) {
        HungrySingletonPattern hungrySingletonPattern = HungrySingletonPattern.getInstance();
        HungrySingletonPattern hungrySingletonPattern1 = HungrySingletonPattern.getInstance();
        System.out.println(hungrySingletonPattern);
        System.out.println(hungrySingletonPattern1);
    }
}
