package com.yulong.springframework.beans.factory.support;

import com.yulong.springframework.beans.BeansException;
import com.yulong.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * @author baiyl3@lenovo.com
 * @version 0.0.1
 * @since 0.0.1
 **/
public interface InstantiationStrategy {

    Object instantiate(
            BeanDefinition beanDefinition,
            String beanName,
            Constructor<?> constructor,
            Object[] args
    ) throws BeansException;
}
