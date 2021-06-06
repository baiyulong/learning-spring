package com.yulong.springframework.beans.factory.support;

import com.yulong.springframework.beans.BeansException;
import com.yulong.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Objects;
import java.util.Optional;

/**
 * @author baiyl3@lenovo.com
 * @version 0.0.1
 * @since 0.0.1
 **/
public class SimpleInstantiationStrategy implements InstantiationStrategy {

    @Override
    public Object instantiate(
            BeanDefinition beanDefinition,
            String beanName,
            Constructor<?> constructor,
            Object[] args
    ) throws BeansException {
        final var clazz = beanDefinition.getClass();
        try {
            if (Objects.nonNull(constructor)) {
                return clazz.getDeclaredConstructor(constructor.getParameterTypes()).newInstance(args);
            } else {
                return clazz.getDeclaredConstructor().newInstance();
            }
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new BeansException("Failed to instantiate [" + clazz.getName() + "]", e);
        }
    }
}
