package com.huaxing.designmode.factory.simplefactory;

import com.huaxing.designmode.factory.IBlogsMarketing;
import com.huaxing.designmode.factory.IBlogsMarketing;

/**
 * @Description 博客营销工厂
 * @author: 姚广星
 * @time: 2021/2/17 20:52
 */
public class BlogsMarketingFactory {

    /**
     * 获取具体的博客营销方式
     *
     * @param clazz
     * @return
     */
    public static IBlogsMarketing getBlogsMarketing(Class<? extends IBlogsMarketing> clazz) {
        if (null != clazz) {
            try {
                return clazz.newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
