package com.ashwin.java.data.serviceimpl;

import com.ashwin.java.domain.model.User;
import com.ashwin.java.domain.repository.UserRepository;
import com.ashwin.java.domain.service.UserService;

import javax.inject.Inject;
import javax.inject.Named;

public class UserServiceImpl implements UserService {
    private String template;
    private String defaultName;
    private UserRepository userRepository;

    @Inject
    public UserServiceImpl(UserRepository repository, @Named("msg-template") String template, @Named("default-name") String defaultName) {
        this.userRepository = repository;
        this.template = template;
        this.defaultName = defaultName;
    }

    @Override
    public String greet(long id) {
        User user = userRepository.get(id);

        return greet(user);
    }

    @Override
    public String greet(User user) {
        String msg = null;
        if (user != null) {
            msg = String.format(template, user.getName());
        } else {
            msg = String.format(template, this.defaultName);
        }
        return msg;
    }
}
