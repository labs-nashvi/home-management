package com.nashvi.labs.web.repositories;

import org.springframework.stereotype.Repository;

import com.nashvi.labs.domain.User;

@Repository
public class UserDAO extends AbstractJpaDAO < User >
{

    public UserDAO ( )
    {
        super.setClazz ( User.class );
    }

}
