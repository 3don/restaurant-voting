package ru.javaops.restaurantvoting.web.restaurant;

import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import ru.javaops.restaurantvoting.web.AbstractControllerTest;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static ru.javaops.restaurantvoting.DishTestData.DISH_MATCHER;
import static ru.javaops.restaurantvoting.RestaurantTestData.*;
import static ru.javaops.restaurantvoting.UserTestData.ADMIN_ID;
import static ru.javaops.restaurantvoting.UserTestData.ADMIN_MAIL;

class AdminRestaurantRestControllerTest extends AbstractControllerTest{

    private static final String REST_URL = AdminRestaurantRestController.REST_URL + '/';

    @Test
    void delete() {
    }

    @Test
    @WithUserDetails(value = ADMIN_MAIL)
    void getWithDishById() throws Exception {
        perform(MockMvcRequestBuilders.get(REST_URL + RESTAURANT1_ID +"/with-dishes"))
                .andExpect(status().isOk())
                .andDo(print())
                // https://jira.spring.io/browse/SPR-14472
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(RESTAURANT_WITH_DISHES_MATCHER.contentJson(restaurant1));
    }

    @Test
    void create() {
    }

    @Test
    void update() {
    }
}