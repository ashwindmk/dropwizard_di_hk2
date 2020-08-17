package com.ashwin.java.di;

import com.ashwin.java.DiHk2Configuration;
import com.ashwin.java.data.repositoryimpl.UserRepositoryImpl;
import com.ashwin.java.data.serviceimpl.UserServiceImpl;
import com.ashwin.java.data.source.UserSource;
import com.ashwin.java.data.source.local.LocalUserSource;
import com.ashwin.java.domain.repository.UserRepository;
import com.ashwin.java.domain.service.UserService;
import com.ashwin.java.resource.UserResource;
import org.glassfish.hk2.utilities.binding.AbstractBinder;

import javax.inject.Singleton;

public class DiHk2Module extends AbstractBinder {
    private DiHk2Configuration config;

    public DiHk2Module(DiHk2Configuration config) {
        this.config = config;
    }

    @Override
    protected void configure() {
        bind(LocalUserSource.class).to(UserSource.class).in(Singleton.class);
        bind(UserRepositoryImpl.class).to(UserRepository.class).in(Singleton.class);
        bind(UserServiceImpl.class).to(UserService.class).in(Singleton.class);
        bind(this.config.getTemplate()).named("msg-template").to(String.class);
        bind(this.config.getDefaultName()).named("default-name").to(String.class);
        bind(UserResource.class).to(UserResource.class).in(Singleton.class);
    }
}
