package com.yulong.springframework;

import com.yulong.springframework.bean.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author baiyl3@lenovo.com
 * @version 0.0.1
 * @since 0.0.1
 **/
public class BeanFactoryTest {

    @Test
    @DisplayName("Test bean factory")
    void testBeanFactory() {

        // 1. Initial bean factory
        var factory = new BeanFactory();
        var beanDefinition = new BeanDefinition(new UserService());

        // 2. Register bean
        final var userService = "userService";
        factory.registerBeanDefinition(userService, beanDefinition);

        // 3. Get bean
        final var bean = factory.getBean(userService);
        final var service = bean.getBean();
        Assertions.assertTrue((service instanceof UserService));
        ((UserService) service).queryUserInfo();
    }
}
