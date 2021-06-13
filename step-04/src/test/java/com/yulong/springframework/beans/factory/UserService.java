package com.yulong.springframework.beans.factory;

/**
 * @author baiyl3@lenovo.com
 * @version 0.0.1
 * @since 0.0.1
 **/
public class UserService {

    private String userId;

    private UserRepository repository;

    public UserService() {
    }

    public String queryUserInfo() {
        return repository.queryUserName(userId);
    }
}
