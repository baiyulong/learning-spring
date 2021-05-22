package com.yulong.springframework.beans.factory.support;

import com.yulong.springframework.beans.factory.config.BeanDefinition;

/**
 * @author baiyl3@lenovo.com
 * @version 0.0.1
 * @since 0.0.1
 **/
public interface BeanDefinitionRegistry {

    /**
     * Registry bean definition to registry table
     *
     * @param beanName       java.lang.String
     * @param beanDefinition com.yulong.springframework.beans.factory.config.BeanDefinition
     * @return void
     * @version 0.0.1
     * @author baiyl3@lenovo.com
     * @since 0.0.1
     */
    void registryBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
