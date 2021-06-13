package com.yulong.springframework.beans.factory.support;

import com.yulong.springframework.beans.BeansException;
import com.yulong.springframework.beans.factory.config.BeanDefinition;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

/**
 * @author baiyl3@lenovo.com
 * @version 0.0.1
 * @since 0.0.1
 **/
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

    private final InstantiationStrategy instantiationStrategy = new CglibSubclassingInstantiationStrategy();

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException {
        return createBeanInstance(beanDefinition, beanName, args)
                .map(o -> {
                    addSingleton(beanName, o);
                    return o;
                })
                .orElseThrow(() -> new BeansException("Instance bean " + beanName + " failed."));
    }

    protected Optional<Object> createBeanInstance(BeanDefinition beanDefinition, String beanName, Object[] args) {
        return Arrays.stream(beanDefinition.getBeanClass().getDeclaredConstructors())
                .filter(c -> Objects.nonNull(args) && c.getParameterTypes().length == args.length)
                .findFirst()
                .map(c -> instantiationStrategy.instantiate(beanDefinition, beanName, c, args));
    }
}
