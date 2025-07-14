package com.jspiders.journalApp.service;

import com.jspiders.journalApp.entity.User;
import com.jspiders.journalApp.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UserDetails;
import org.mockito.Mockito.*;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;

import static org.mockito.Mockito.when;

//@SpringBootTest  //Here we were playing with ApplicationContext means beans was creating. that's why we were using @Autowired and @MockBean
//public class UserDetailsServiceImplTests {
//
//    @Autowired
//    private UserDetailsServiceImpl userDetailsService;
//
//
//    @MockBean  //@MockBean we will use when we are using ApplicationContext means Without using @SpingBootTest if we have to use @Mock bcz we will play with dummy actual repository.
//    private UserRepository userRepository;
//
//    @Test
//    void loadUserByUsernameTest()
//    {
//        when(userRepository.findByUserName(ArgumentMatchers.anyString())).thenReturn(User.builder().userName("ram").password("inrkiinrik").roles(new ArrayList<>()).build());
//        UserDetails user = userDetailsService.loadUserByUsername("ram");
//        Assertions.assertNotNull(user);
//    }
//}


//Here we are not using SpringContext
@ActiveProfiles("dev") //so developement profile will be used
public class UserDetailsServiceImplTests{

    @InjectMocks //It is used to inject all the dependencies and it will search for Mock annotated dependency.
    private UserDetailsServiceImpl userDetailsService;

    @Mock
    private UserRepository userRepository;  //It will be inject to @InjectMocks annotated dependency.

    @BeforeEach
    void setUp()
    {
        MockitoAnnotations.initMocks(this);  //Here we are initializing all the mocks before executing any Test
    }

    @Disabled //for sonarQUbe i made it disabled
    @Test
    void loadUserByUsernameTest() {
        when(userRepository.findByUserName(ArgumentMatchers.anyString())).thenReturn(User.builder().userName("ram").password("inrkiinrik").roles(new ArrayList<>()).build());
        UserDetails user = userDetailsService.loadUserByUsername("ram");
        Assertions.assertNotNull(user);
    }
}