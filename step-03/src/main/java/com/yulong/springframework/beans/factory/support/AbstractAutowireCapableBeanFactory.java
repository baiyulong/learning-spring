package com.yulong.springframework.beans.factory.support;

import com.yulong.springframework.beans.BeansException;
import com.yulong.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Objects;

/**
 * @author baiyl3@lenovo.com
 * @version 0.0.1
 * @since 0.0.1
 **/
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

    private final InstantiationStrategy instantiationStrategy = new CglibSubclassingInstantiationStrategy();

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException {
        var bean = createBeanInstance(beanDefinition, beanName, args);
        addSingleton(beanName, bean);
        return bean;
    }

    protected Object createBeanInstance(BeanDefinition beanDefinition, String beanName, Object[] args) {
        return Arrays.stream(beanDefinition.getBeanClass().getDeclaredConstructors())
                .filter(c -> Objects.nonNull(args) && c.getParameterTypes().length == args.length)
                .findFirst()
                .map(c -> instantiationStrategy.instantiate(beanDefinition, beanName, c, args))
                .orElse(null);
    }
}
