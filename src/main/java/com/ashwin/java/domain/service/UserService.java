package com.ashwin.java.domain.service;

import com.ashwin.java.domain.model.User;

public interface UserService {
    public String greet(long id);

    public String greet(User user);
}
