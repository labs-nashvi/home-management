package com.nashvi.labs.web.repositories;

import java.sql.Timestamp;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.nashvi.labs.domain.User;

@RunWith ( SpringJUnit4ClassRunner.class )
@ContextConfiguration ( locations = { "classpath:spring/app-db-context.xml", "classpath:spring/bean-context.xml" } )
@TransactionConfiguration ( transactionManager = "txManager", defaultRollback = true )
@Transactional
public class TestUserDAO
{

    @PersistenceContext ( unitName = "emf" )
    private EntityManager entityManager;

    @Autowired
    private UserDAO userDAO;

    @Test
    @Transactional
    public void testCreateUser ( )
    {
        User newUser = new User ( );
        Timestamp timestamp = new Timestamp ( System.currentTimeMillis ( ) );
        newUser.setCreateTimestamp ( timestamp );
        newUser.setLastLoginTimestamp ( timestamp );
        newUser.setUserName ( "labs.nashvi" );
        newUser.setPassword ( "password" );
        newUser.setStatus ( "A" );

        userDAO.save ( newUser );

        int userId = newUser.getUserId ( );

        System.out.println ( "Generated user-id: " + userId );
    }
}
