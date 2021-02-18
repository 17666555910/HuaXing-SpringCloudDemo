package com.huaxing.designmode.factory;

/**
 * @Description CSDN 博客营销
 * @author: 姚广星
 * @time: 2021/2/17 20:50
 */
public class CsdnBlogsMarketing implements IBlogsMarketing {
    @Override
    public void create(String msg) {
        System.out.println("发送CSDN博客：【" + msg + "】");
    }
}
