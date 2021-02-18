package com.huaxing.designmode.factory.simplefactory;

import com.huaxing.designmode.factory.CsdnBlogsMarketing;
import com.huaxing.designmode.factory.IBlogsMarketing;
import com.huaxing.designmode.factory.WeChatBlogsMarketing;


/**
 * @Description 简单工厂模式测试类
 * @author: 姚广星
 * @time: 2021/2/17 20:58
 */
public class SimpleFactoryTest {
    public static void main(String[] args) {
//        IBlogsMarketing blogsMarketing = BlogsMarketingFactory.getBlogsMarketing(WeChatBlogsMarketing.class);
//        blogsMarketing.create("这是华星详谈的一篇博文");
        IBlogsMarketing blogsMarketing = BlogsMarketingFactory.getBlogsMarketing(CsdnBlogsMarketing.class);
        blogsMarketing.create("这是华星详谈的一篇博文");
    }
}
