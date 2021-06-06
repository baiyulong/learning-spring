package com.yulong.springframework.beans.factory.config;

/**
 * @author baiyl3@lenovo.com
 * @version 0.0.1
 * @since 0.0.1
 **/
public class BeanDefinition {

    private Class<?> beanClass;

    public BeanDefinition(Class<?> beanClass) {
        this.beanClass = beanClass;
    }

    public Class<?> getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class<?> beanClass) {
        this.beanClass = beanClass;
    }
}
