package com.yulong.springframework.beans.factory.support;

import cn.hutool.core.bean.BeanUtil;
import com.yulong.springframework.beans.BeansException;
import com.yulong.springframework.beans.factory.config.BeanDefinition;
import com.yulong.springframework.beans.factory.config.BeanReference;

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
        Object bean;
        try {
            bean = createBeanInstance(beanDefinition, beanName, args);
        } catch (Exception e) {
            throw new BeansException("Instantiation of bean failed", e);
        }
        applyPropertyValues(beanName, bean, beanDefinition);
        addSingleton(beanName, bean);
        return bean;
    }

    protected Object createBeanInstance(BeanDefinition beanDefinition, String beanName, Object[] args) {
        var ctor = Arrays.stream(beanDefinition.getBeanClass().getDeclaredConstructors())
                .filter(c -> Objects.nonNull(args) && c.getParameterTypes().length == args.length)
                .findFirst()
                .orElse(null);
        return getInstantiationStrategy().instantiate(beanDefinition, beanName, ctor, args);
    }

    protected void applyPropertyValues(String beanName, Object bean, BeanDefinition beanDefinition) throws BeansException {
        try {
            beanDefinition.getPropertyValues().getPropertyValues().parallelStream().forEach(o -> {
                var value = o.getValue();
                if (value instanceof BeanReference) {
                    var beanReference = (BeanReference) value;
                    value = getBean(beanReference.getBeanName());
                }
                BeanUtil.setFieldValue(bean, o.getName(), value);
            });
        } catch (Exception e) {
            throw new BeansException("Error setting property values：" + beanName);
        }
    }

    public InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }
}
