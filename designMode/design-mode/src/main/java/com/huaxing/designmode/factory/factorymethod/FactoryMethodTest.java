package com.huaxing.designmode.factory.factorymethod;

import com.huaxing.designmode.factory.CsdnBlogsMarketing;
import com.huaxing.designmode.factory.IBlogsMarketing;
import com.huaxing.designmode.factory.simplefactory.BlogsMarketingFactory;
import org.slf4j.ILoggerFactory;
import org.springframework.beans.factory.BeanFactory;


/**
 * @Description 抽象工厂模式测试类
 * @author: 姚广星
 * @time: 2021/2/17 20:58
 */
public class FactoryMethodTest {
    public static void main(String[] args) {
//        BlogsMarketingFactoryMethod factoryMethod = new WeChatBlogsMarketingFactory();
//        IBlogsMarketing blogsMarketing = factoryMethod.getBlogsMarketing();
//        blogsMarketing.create("这是华星详谈的一篇博文");
        BlogsMarketingFactoryMethod factoryMethod = new CsdnBlogsMarketingFactory();
        IBlogsMarketing blogsMarketing = factoryMethod.getBlogsMarketing();
        blogsMarketing.create("这是华星详谈的一篇博文");
    }
}
