package com.yulong.springframework.beans.factory;

import com.yulong.springframework.beans.BeansException;

/**
 * @author baiyl3@lenovo.com
 * @version 0.0.1
 * @since 0.0.1
 **/
public interface BeanFactory {

    Object getBean(String name) throws BeansException;
}
