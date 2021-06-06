package com.yulong.springframework.beans;

import com.yulong.springframework.beans.bean.UserService;
import com.yulong.springframework.beans.factory.config.BeanDefinition;
import com.yulong.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertTrue;

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

        final var bean = factory.getBean(userService, "YuLong");
        assertTrue(bean instanceof UserService);
        var name = ((UserService) bean).getName();
        assertTrue(Objects.nonNull(name));
        System.out.println(name);
    }

}