package com.yulong.springframework.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * @author baiyl3@lenovo.com
 * @version 0.0.1
 * @since 0.0.1
 **/
public class PropertyValues {

    private final List<PropertyValue> propertyValues = new ArrayList<>();

    public void addPropertyValue(PropertyValue propertyValue) {
        propertyValues.add(propertyValue);
    }

    public List<PropertyValue> getPropertyValues() {
        return propertyValues;
    }

    public PropertyValue getPropertyValue(String propertyName) {
        return propertyValues.parallelStream()
                .filter(o -> o.getName().equals(propertyName))
                .findFirst()
                .orElse(null);
    }
}
