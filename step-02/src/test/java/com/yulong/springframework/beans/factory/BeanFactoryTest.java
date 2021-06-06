package com.yulong.springframework.beans.factory;

import com.yulong.springframework.beans.factory.bean.UserService;
import com.yulong.springframework.beans.factory.config.BeanDefinition;
import com.yulong.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author baiyl3@lenovo.com
 * @version 0.0.1
 * @since 0.0.1
 **/
class BeanFactoryTest {

    @Test
    void testBeanFactory() {

        var factory = new DefaultListableBeanFactory();

        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        final var userService = "userService";
        factory.registryBeanDefinition(userService, beanDefinition);

        final var bean = factory.getBean(userService);
        assertTrue(bean instanceof UserService);
    }

}