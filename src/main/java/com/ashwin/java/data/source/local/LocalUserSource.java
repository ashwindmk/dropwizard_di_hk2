package com.ashwin.java.data.source.local;

import com.ashwin.java.data.source.UserSource;
import com.ashwin.java.domain.model.User;

import java.util.ArrayList;
import java.util.List;

public class LocalUserSource implements UserSource {
    private final List<User> userList;

    public LocalUserSource() {
        userList = new ArrayList<>();
        userList.add(new User(1L, "Alice"));
        userList.add(new User(2L, "Bob"));
        userList.add(new User(3L, "Clara"));
        userList.add(new User(4L, "Daniel"));
    }

    @Override
    public List<User> get() {
        return userList;
    }
}
