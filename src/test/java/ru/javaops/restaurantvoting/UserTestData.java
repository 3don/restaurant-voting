package ru.javaops.restaurantvoting;

import ru.javaops.restaurantvoting.model.Role;
import ru.javaops.restaurantvoting.model.User;

import java.util.Collections;
import java.util.Date;
import java.util.Set;

import static ru.javaops.restaurantvoting.Utils.getYesterday;
import static ru.javaops.restaurantvoting.model.AbstractBaseEntity.START_SEQ;

public class UserTestData {
    public static final MatcherFactory.Matcher<User> USER_MATCHER = MatcherFactory.usingIgnoringFieldsComparator(User.class, "registered", "password");

    public static final int USER_ID = START_SEQ;
    public static final int USER2_ID = START_SEQ + 1;
    public static final int USER3_ID = START_SEQ + 2;
    public static final int ADMIN_ID = START_SEQ + 3;
    public static final int ADMIN2_ID = START_SEQ + 4;
    public static final int NOT_FOUND = 10;
    public static final String USER_MAIL = "user@gmail.com";
    public static final String ADMIN_MAIL = "admin@gmail.com";

    public static final User user = new User(USER_ID, "user@gmail.com", "User_First", "User_Last", "password", getYesterday(), Set.of(Role.USER));
    public static final User user2 = new User(USER2_ID, "user@javaops.ru", "User2_First", "User2_Last", "user", getYesterday(), Set.of(Role.USER));
    public static final User user3 = new User(USER3_ID, "user@user.ru", "User3_First", "User3_Last", "user", getYesterday(), Set.of(Role.USER));
    public static final User admin = new User(ADMIN_ID, "admin@javaops.ru", "Admin_First", "Admin_Last", "admin", getYesterday(), Set.of(Role.ADMIN, Role.USER));
    public static final User admin2 = new User(ADMIN2_ID, "admin@admin.ru", "Second_admin", "Admin_Last_2", "admin", getYesterday(), Set.of(Role.ADMIN, Role.USER));

    public static User getNew() {
        return new User(null, "new@gmail.com", "New_First", "New_Last", "New_pass", new Date(), Collections.singleton(Role.USER));
    }

    public static User getUpdated() {
        User updated = new User(user);
        updated.setEmail("update@gmail.com");
        updated.setFirstName("UpdatedName");
        updated.setPassword("newPass");
        updated.setRoles(Set.of(Role.ADMIN));
        return updated;
    }
}