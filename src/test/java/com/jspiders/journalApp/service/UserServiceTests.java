package com.jspiders.journalApp.service;

import com.jspiders.journalApp.entity.User;
import com.jspiders.journalApp.repository.UserRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@Disabled //i have mede it diable while sonarQube
@SpringBootTest//without this annotation spring application context will not be injected and other @component or @Autowired annotation will be null(component will not be created). This annotation tells that we have to start the application context or just like i am starting my application.
public class UserServiceTests {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

//    @Test //Any method if we want to run as test then we have to annotate it by using @Test annotation.
//    public void testAdd()
//    {
//        assertEquals(4, 2+2);
//    }

//    @Test
//    public void testFindByUserName() {

    /// /        assertEquals(4, 2+2);
//        assertNotNull(userRepository.findByUserName("ram"));
//    } //This complete method block is called one Test.

//    @Disabled //If we don't want to run this test then we'll use this @Disabled annotations.
//    @Test
//    public void testFindByUserName() {
//        User user = userRepository.findByUserName("ram");
//        assertTrue(!user.getJournalEntries().isEmpty());
//    }
//    @BeforeEach  //This is used if you wanna initialize anything and before each test then we can use this annotation
//    public void setUp() {
//
//    }

//    @BeforeAll  //it will run if there any thounds of test cases are there. Then this will execute first.
//    public void toRead() {
//
//    }

//    @AfterEach //this will execute after executing all the tests all and the tests
//    public void setUpp()
//    {
//
//    }

//    @AfterAll //It will run after ending the execution of all the test.
//    public void setupe()
//    {
//
//    }

    @Disabled
    @ParameterizedTest
    @CsvSource({
            "1, 1, 2",   //1st test case
            "2, 10, 12",
            "3, 3, 9"
    })
    public void test(int a, int b, int expected)
    {
        assertEquals(expected, a+b); //a or b i don't want to hardcode i want to give multiple values then will use @ParameterizedTest annotations(its value like working loops will rise a, b then expected, a b then expected) so values will rise from @CsvSource()
    }

    //we can also use this test to check for parametrized test
    @Disabled //i have mede it diable while sonarQube
    @ParameterizedTest
    @ValueSource(strings = {     // if we check integer value then will use ints  //Here we can use EnumSource even we can create CustomSource
            "ram",
            "shyam",
            "vipul"
    })
    public void testFindByUserName(String name){
        assertNotNull(userRepository.findByUserName(name), "failed for: "+ name); //here we are writing some message but it is giving in console like which component has not worked.
    }

    @Disabled //i have mede it diable while sonarQube
    //We can also create one custom source
    @ParameterizedTest
    @ArgumentsSource(UserArgumentsProvider.class)
    public void testSaveNewUser(User user) {
        assertTrue(userService.saveNewUser(user));
    }
}
