package org.rubberduckies;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

public class UserControllerTest {
    @BeforeClass
    public static void oneTimeSetup() {

    }

    @Before
    public static void setup() {

    }

    @After
    public static void teadDown() {

    }

    @AfterClass
    public static void oneTimeTearDown() {

    }

    @Test
    public void initControllerNotNull() {
        UserController controller = UserController.getController();
        assertNotNull(controller);
    }

    @Test
    public void loginValidUser() {
        // best used when User passwords are hashed
        UserController controller = UserController.getController();
        String testUsername = "this_is_a_test_user";
        String testPassword = "this_is_a_test_password";
        User testUser = new User(testUsername, testPassword);
        controller._addUser(testUser);
        assertTrue(controller.login(testUsername, testPassword));
        assertEquals(controller.getCurrentUser(), testUser);
    }

    @Test
    public void loginValidUserSamePassword() {
        UserController controller = UserController.getController();
        String testUsername1 = "this_is_a_test_user";
        String testPassword1 = "this_is_a_test_password";
        User testUser1 = new User(testUsername1, testPassword1);
        controller._addUser(testUser1);
        String testUsername2 = "this_is_a_test_user";
        String testPassword2 = "this_is_a_test_password";
        User testUser2 = new User(testUsername2, testPassword2);
        controller._addUser(testUser2);
        assertTrue(controller.login(testUsername2, testPassword2));
        assertEquals(controller.getCurrentUser(), testUser2);
    }

    @Test
    public void loginInvalidUser() {
        // best used when User passwords are hashed
        UserController controller = UserController.getController();
        String testUsername = "this_is_a_test_user";
        String testPassword = "this_is_a_test_password";
        User testUser = new User(testUsername, testPassword);
        controller._addUser(testUser);
        assertFalse(controller.login(testUsername, "non_matching_password"));
        assertNotEquals(controller.getCurrentUser(), testUser);
    }

    @Test 
    public void loadCorrectNumberUsers() {
        UserController controller = UserController.getController();
        assertEquals(controller._getNumberOfUsers(), controller._getNumberOfUserDirs());
    }

    @Test
    public void returnCorrectUserData() {
        UserController controller = UserController.getController();
        String testUsername = "this_is_a_test_user";
        String testPassword = "this_is_a_test_password";
        User testUser = new User(testUsername, testPassword);
        UserData testUserData = new UserData("firstName", "lastName", "email", "phone", LocalDateTime.parse("2000-12-17T00:00:00"), "xxxxxx", "xxxxxx");
        testUser.setData(testUserData);
        controller._addUser(testUser);
        assertEquals(testUserData, controller.dataFor(testUser.getUsername()));
    }

    @Test
    public void returnCorrectUserPreferences() {
        UserController controller = UserController.getController();
        String testUsername = "this_is_a_test_user";
        String testPassword = "this_is_a_test_password";
        User testUser = new User(testUsername, testPassword);
        UserPreferences testUserPreferences = new UserPreferences(new ArrayList<Search>(), "this_is_a_test_nickname");
        testUser.setPreferences(testUserPreferences);
        controller._addUser(testUser);
        assertEquals(testUserPreferences, controller.preferencesFor(testUser.getUsername()));
    }
}
