package ru.javaops.restaurantvoting;

import ru.javaops.restaurantvoting.model.Restaurant;

import java.util.Date;

import static ru.javaops.restaurantvoting.Utils.getYesterday;
import static ru.javaops.restaurantvoting.model.AbstractBaseEntity.START_SEQ;

public class RestaurantTestData {

    public static final MatcherFactory.Matcher<Restaurant> RESTAURANT_MATCHER = MatcherFactory.usingIgnoringFieldsComparator();

    public static final int RESTAURANT1_ID = START_SEQ + 5;
    public static final int RESTAURANT2_ID = START_SEQ + 6;
    public static final int RESTAURANT3_ID = START_SEQ + 7;
    public static final int RESTAURANT4_ID = START_SEQ + 8;
    public static final int NOT_FOUND = 10;

    public static final Restaurant restaurant1 = new Restaurant(RESTAURANT1_ID, "Mac", "FastFood, address etc", getYesterday());
    public static final Restaurant restaurant2 = new Restaurant(RESTAURANT2_ID, "7/11", "FastFood2, address etc", getYesterday());
    public static final Restaurant restaurant3 = new Restaurant(RESTAURANT3_ID, "Fried chicken", "FastFood3, description", getYesterday());
    public static final Restaurant restaurant4 = new Restaurant(RESTAURANT4_ID, "Bochka", "restaurant", getYesterday());


    public static Restaurant getNew() {
        return new Restaurant(null, "NewRestaurant", "description of new restaurant", new Date());
    }

    public static Restaurant getUpdated() {
        Restaurant updated = new Restaurant(restaurant1);
        updated.setName("UpdatedName");
        updated.setDescription("UpdatedDescription");
        return updated;
    }
}
