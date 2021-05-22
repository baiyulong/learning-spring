package com.yulong.springframework.beans.factory.config;

/**
 * @author baiyl3@lenovo.com
 * @version 0.0.1
 * @since 0.0.1
 **/
public interface SingletonBeanRegistry {

    Object getSingleton(String beanName);
}
