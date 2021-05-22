package com.yulong.springframework;

/**
 * @author baiyulong2009@hotmail.com
 * @version 0.0.1
 * @since 0.0.1
 **/
public class BeanDefinition {

    private Object bean;

    public BeanDefinition(Object bean) {
        this.bean = bean;
    }

    public Object getBean() {
        return bean;
    }
}
