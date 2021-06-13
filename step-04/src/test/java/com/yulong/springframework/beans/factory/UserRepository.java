package com.yulong.springframework.beans.factory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author baiyl3@lenovo.com
 * @version 0.0.1
 * @since 0.0.1
 **/
public class UserRepository {

    private static final Map<String, String> values = new HashMap<>(16);

    static {
        values.put("1001", "yulong");
        values.put("1002", "yulong2");
        values.put("1003", "yulong3");
    }

    public String queryUserName(String userId) {
        return values.get(userId);
    }
}
