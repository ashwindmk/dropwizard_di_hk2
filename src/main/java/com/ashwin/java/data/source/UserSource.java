package com.ashwin.java.data.source;

import com.ashwin.java.domain.model.User;

import java.util.List;

public interface UserSource {
    List<User> get();
}
