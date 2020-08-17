package com.ashwin.java.domain.repository;

import com.ashwin.java.domain.model.User;

public interface UserRepository {
    public User get(long id);
}
