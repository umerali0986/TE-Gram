package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.RegisterUserDto;
import com.techelevator.model.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public class JdbcUserDaoTests extends BaseDaoTests {
    protected static final User USER_1 = new User(1, "user1", "name", "user1", "ROLE_USER", "email.com", "yourPic");
    protected static final User USER_2 = new User(2, "user2", "name", "user2", "ROLE_USER", "email.net", "yourPic");
    private static final User USER_3 = new User(3, "user3", "name", "user3", "ROLE_USER", "email.gov", "myPic");

    private JdbcUserDao sut;

    @Before
    public void setup() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        sut = new JdbcUserDao(jdbcTemplate);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getUserByUsername_given_null_throws_exception() {
        sut.getUserByUsername(null);
    }

    @Test
    public void getUserByUsername_given_invalid_username_returns_null() {
        Assert.assertNull(sut.getUserByUsername("invalid"));
    }

    @Test
    public void getUserByUsername_given_valid_user_returns_user() {
        User actualUser = sut.getUserByUsername(USER_1.getUsername());

        Assert.assertEquals(USER_1, actualUser);
    }

    @Test
    public void getUserById_given_invalid_user_id_returns_null() {
        User actualUser = sut.getUserById(-1);

        Assert.assertNull(actualUser);
    }

    @Test
    public void getUserById_given_valid_user_id_returns_user() {
        User actualUser = sut.getUserById(USER_1.getId());

        Assert.assertEquals(USER_1, actualUser);
    }

    @Test
    public void getUsers_returns_all_users() {
        List<User> users = sut.getUsers();

        Assert.assertNotNull(users);
        Assert.assertEquals(3, users.size());
        Assert.assertEquals(USER_1, users.get(0));
        Assert.assertEquals(USER_2, users.get(1));
        Assert.assertEquals(USER_3, users.get(2));
    }

    @Test(expected = DaoException.class)
    public void createUser_with_null_username() {
        RegisterUserDto registerUserDto = new RegisterUserDto();
        registerUserDto.setUsername(null);
        registerUserDto.setPassword(USER_3.getPassword());
        registerUserDto.setRole("ROLE_USER");
        sut.createUser(registerUserDto);
    }

    @Test(expected = DaoException.class)
    public void createUser_with_existing_username() {
        RegisterUserDto registerUserDto = new RegisterUserDto();
        registerUserDto.setUsername(USER_1.getUsername());
        registerUserDto.setPassword(USER_3.getPassword());
        registerUserDto.setRole("ROLE_USER");
        sut.createUser(registerUserDto);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createUser_with_null_password() {
        RegisterUserDto registerUserDto = new RegisterUserDto();
        registerUserDto.setUsername(USER_3.getUsername());
        registerUserDto.setPassword(null);
        registerUserDto.setRole("ROLE_USER");
        sut.createUser(registerUserDto);
    }

    @Test
    public void createUser_creates_a_user() {
        RegisterUserDto user = new RegisterUserDto();
        user.setUsername("new");
        user.setPassword("user");
        user.setRole("ROLE_USER");
        user.setEmail("new@gmail.com");
        User createdUser = sut.createUser(user);

        Assert.assertNotNull(createdUser);

        User retrievedUser = sut.getUserByUsername(createdUser.getUsername());
        Assert.assertEquals(retrievedUser, createdUser);
    }

//    @Test
//    public void updateUser_should_update_user_in_db(){
//        User user = sut.getUserById(1);
//        user.setName("user1");
//
//        User updatedUser = sut.updateUser(user);
//
//        Assert.assertNotNull(updatedUser);
//
//        User retrievedUser = sut.getUserById(1);
//
//        assertUserMatch(updatedUser,retrievedUser);
//
//    }

    // @Test
    // public void deleteUserById_should_delete_User(){
    //     int numberOfRows = sut.deleteUserById(USER_1.getId());

    //     Assert.assertEquals("Number of rows affected doesn't match",1, numberOfRows);

    //     User user = sut.getUserById(USER_1.getId());
    //     Assert.assertNull(user);
    // }

    @Test(expected = IllegalArgumentException.class)
    public void getUserByEmail_given_null_throws_exception() {
        sut.getUserByEmail(null);
    }

    @Test
    public void getUserByEmail_given_invalid_email_returns_null() {
        Assert.assertNull(sut.getUserByEmail("invalid"));
    }

    @Test
    public void getUserByEmail_given_valid_user_returns_user() {
        User actualUser = sut.getUserByEmail(USER_1.getEmail());

        Assert.assertEquals(USER_1, actualUser);
    }


    public void assertUserMatch(User expect, User actual){

        Assert.assertEquals("User Id doesn't match",expect.getId(), actual.getId());
        Assert.assertEquals("User avatar doesn't match",expect.getAvatar(), actual.getAvatar());
        Assert.assertEquals("User authorities doesn't match",expect.getAuthorities(), actual.getAuthorities());
        Assert.assertEquals("User email doesn't match",expect.getEmail(), actual.getEmail());
        Assert.assertEquals("User name doesn't match",expect.getName(), actual.getName());
        Assert.assertEquals("User username doesn't match",expect.getUsername(), actual.getUsername());
        Assert.assertEquals("User password doesn't match",expect.getPassword(), actual.getPassword());

    }

}
