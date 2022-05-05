package ru.javaops.restaurantvoting;

import ru.javaops.restaurantvoting.model.Dish;

import java.time.LocalDate;
import java.util.List;

import static ru.javaops.restaurantvoting.model.AbstractBaseEntity.START_SEQ;

public class DishTestData {
    public static final MatcherFactory.Matcher<Dish> DISH_MATCHER = MatcherFactory.usingIgnoringFieldsComparator("restaurant");

    public static final int NOT_FOUND = 10;
    public static final int DISH_PAST_ID = START_SEQ + 9;
    public static final int DISH_ID = DISH_PAST_ID + 11;

    public static final Dish dish1_past = new Dish(DISH_PAST_ID, "Mac Burger", "Fat", 100, LocalDate.now().minusDays(1));
    public static final Dish dish2_past = new Dish(DISH_PAST_ID + 1, "Mac Fries", "Fast", 50, LocalDate.now().minusDays(1));
    public static final Dish dish3_past = new Dish(DISH_PAST_ID + 2, "Mac Tea", "0 kkal", 20, LocalDate.now().minusDays(1));
    public static final Dish dish4_past = new Dish(DISH_PAST_ID + 3, "7/11 Burger", "Fat", 130, LocalDate.now().minusDays(1));
    public static final Dish dish5_past = new Dish(DISH_PAST_ID + 4, "7/11 Donut", "Fat", 80, LocalDate.now().minusDays(1));
    public static final Dish dish6_past = new Dish(DISH_PAST_ID + 5, "7/11 SevenUp", "cool", 200, LocalDate.now().minusDays(1));
    public static final Dish dish7_past = new Dish(DISH_PAST_ID + 6, "FC Burger", "Fat", 90, LocalDate.now().minusDays(1));
    public static final Dish dish8_past = new Dish(DISH_PAST_ID + 7, "FC wings", "Fat", 60, LocalDate.now().minusDays(1));
    public static final Dish dish9_past = new Dish(DISH_PAST_ID + 8, "FC Cola", "vanilla", 90, LocalDate.now().minusDays(1));
    public static final Dish dish10_past = new Dish(DISH_PAST_ID + 9, "Bochka business lunch", "lunch", 180, LocalDate.now().minusDays(1));
    public static final Dish dish11_past = new Dish(DISH_PAST_ID + 10, "Bochka beer", "lunch", 80, LocalDate.now().minusDays(1));

    public static final Dish dish1 = new Dish(DISH_ID, "Mac CheeseBurger", "today s Fat", 110, LocalDate.now());
    public static final Dish dish2 = new Dish(DISH_ID + 1, "Mac Fries", "today s Fast", 45, LocalDate.now());
    public static final Dish dish3 = new Dish(DISH_ID + 2, "Mac Tea", "today s 0 kkal", 30, LocalDate.now());
    public static final Dish dish4 = new Dish(DISH_ID + 3, "7/11 Burger", "today s Fat", 110, LocalDate.now());
    public static final Dish dish5 = new Dish(DISH_ID + 4, "7/11 Donut", "today s Fat", 70, LocalDate.now());
    public static final Dish dish6 = new Dish(DISH_ID + 5, "7/11 SevenUp", "today s cool", 200, LocalDate.now());
    public static final Dish dish7 = new Dish(DISH_ID + 6, "FC Burger", "today s Fat", 90, LocalDate.now());
    public static final Dish dish8 = new Dish(DISH_ID + 7, "FC wings", "today s Fat", 60, LocalDate.now());
    public static final Dish dish9 = new Dish(DISH_ID + 8, "FC Cola", "today s vanilla", 90, LocalDate.now());
    public static final Dish dish10 = new Dish(DISH_ID + 9, "Bochka business lunch", "today s lunch", 180, LocalDate.now());
    public static final Dish dish11 = new Dish(DISH_ID + 10, "Bochka beer", "today s beer", 80, LocalDate.now());

    public static final List<Dish> dishes = List.of(dish1, dish2, dish3, dish4, dish5, dish6, dish7, dish8, dish9, dish10, dish11);

    public static Dish getNew() {
        return new Dish(null, "Bochka dinner", "today s dinner", 200, LocalDate.now());
    }

    public static Dish getUpdated() {
        return new Dish(DISH_ID, "Updated Name", "Updated description", 200, dish1.getDate_menu());
    }
}
