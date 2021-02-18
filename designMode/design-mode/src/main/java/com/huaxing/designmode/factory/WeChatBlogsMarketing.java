package com.huaxing.designmode.factory;

/**
 * @Description 微信公众号营销
 * @author: 姚广星
 * @time: 2021/2/17 20:48
 */
public class WeChatBlogsMarketing implements IBlogsMarketing {
    @Override
    public void create(String msg) {
        System.out.println("发送微信公众号图文博客：【" + msg + "】");
    }
}
