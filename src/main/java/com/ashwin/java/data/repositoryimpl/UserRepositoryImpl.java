package com.ashwin.java.data.repositoryimpl;

import com.ashwin.java.data.source.UserSource;
import com.ashwin.java.domain.model.User;
import com.ashwin.java.domain.repository.UserRepository;

import javax.inject.Inject;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {
    private UserSource userSource;
    private List<User> userList;

    @Inject
    public UserRepositoryImpl(UserSource source) {
        userSource = source;
        userList = userSource.get();
    }

    @Override
    public User get(long id) {
        for (User user: userList) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }
}
