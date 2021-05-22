package com.yulong.springframework.beans.factory.support;

import com.yulong.springframework.beans.BeansException;
import com.yulong.springframework.beans.factory.BeanFactory;
import com.yulong.springframework.beans.factory.config.BeanDefinition;

import java.util.Objects;

/**
 * @author baiyl3@lenovo.com
 * @version 0.0.1
 * @since 0.0.1
 **/
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

    @Override
    public Object getBean(String name) throws BeansException {
        Object bean = getSingleton(name);
        if (Objects.nonNull(bean)) {
            return bean;
        }
        var beanDefinition = getBeanDefinition(name);
        return createBean(name, beanDefinition);
    }

    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException;
}
