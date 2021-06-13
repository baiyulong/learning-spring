package com.yulong.springframework.beans.factory;

import com.yulong.springframework.beans.PropertyValue;
import com.yulong.springframework.beans.PropertyValues;
import com.yulong.springframework.beans.factory.config.BeanDefinition;
import com.yulong.springframework.beans.factory.config.BeanReference;
import com.yulong.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author baiyl3@lenovo.com
 * @version 0.0.1
 * @since 0.0.1
 **/
class BeanFactoryTest {

    @Test
    void test_bean_factory() {
        // 1. Initial bean factory
        var factory = new DefaultListableBeanFactory();
        // 2. Register user repository
        BeanDefinition userRepository = new BeanDefinition(UserRepository.class);
        final var repository = "UserRepository";
        factory.registryBeanDefinition(repository, userRepository);
        // 3. Set user service's properties
        var propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("userId", "1001"));
        propertyValues.addPropertyValue(new PropertyValue("repository", new BeanReference(repository)));
        // 4. Register user service
        final var userService = "UserService";
        factory.registryBeanDefinition(userService, new BeanDefinition(UserService.class, propertyValues));
        // 5. Get user service from bean factory
        var service = (UserService) factory.getBean(userService);
        final var user = service.queryUserInfo();
        System.out.println(user);
        Assertions.assertEquals(user, "yulong");
    }

}