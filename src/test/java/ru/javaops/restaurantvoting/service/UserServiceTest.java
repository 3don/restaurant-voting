package ru.javaops.restaurantvoting.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.javaops.restaurantvoting.UserTestData;
import ru.javaops.restaurantvoting.model.User;

import static ru.javaops.restaurantvoting.UserTestData.USER_ID;
import static ru.javaops.restaurantvoting.UserTestData.USER_MATCHER;

@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserService service;

    @Test
    public void get() {
        User user = service.get(USER_ID);
        USER_MATCHER.assertMatch(user, UserTestData.user);
    }


}