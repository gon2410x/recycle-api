package com.juy.recycle_api.service;

import com.juy.recycle_api.domain.User;
import com.juy.recycle_api.domain.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private  final UserRepository repository;

    public UserDetailsServiceImpl(UserRepository repository) {
        this.repository = repository;
//        repository.save(new User("user", "us@gmail.com", "$2a$10$NVM0n8ElaRgg7zWO1CxUdei7vWoPg91Lz2aYavh9.f9q0e4bRadue",null));
    }

    @Override
    public UserDetails loadUserByUsername(String user) throws UsernameNotFoundException {
        System.out.println("--------> 2: " + user);

        Optional<User> user2 = repository.findByUser(user);
        System.out.println("--------> : " + user2.get().getUser() + " : " + user2.get().getRol().getRol() );
        org.springframework.security.core.userdetails.User.UserBuilder builder = null;
        if(user2.isPresent()){
            User currentUser = user2.get();
            builder = org.springframework.security.core.userdetails.User.withUsername(user);
            builder.password(currentUser.getPassword());
            builder.roles(currentUser.getRol().getRol());
        }else{
            throw  new UsernameNotFoundException("User not found.");
        }

        return builder.build();
    }
}
