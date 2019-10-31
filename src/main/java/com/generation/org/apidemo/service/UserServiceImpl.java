package com.generation.org.apidemo.service;

import com.generation.org.apidemo.model.User;
import com.generation.org.apidemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserServiceImpl
    implements UserService
{
    @Autowired
    protected UserRepository userRepository;

    @Override
    public User getUser( String id )
    {
        Optional<User> user = userRepository.findById( id );
        if ( user != null && user.isPresent() )
        {
            return user.get();
        }
        return null;
    }

    @Override
    public User save( User user )
    {
        return userRepository.save( user );
    }

    @Override
    public void delete( String id )
    {
        userRepository.deleteById( id );
    }

}
