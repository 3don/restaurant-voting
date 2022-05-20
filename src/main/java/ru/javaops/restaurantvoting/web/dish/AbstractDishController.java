package ru.javaops.restaurantvoting.web.dish;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import ru.javaops.restaurantvoting.model.Dish;
import ru.javaops.restaurantvoting.repository.DishRepository;

import java.time.LocalDate;
import java.util.List;

@Slf4j
public class AbstractDishController {

    @Autowired
    private DishRepository repository;

    public Dish get(int id, int restaurantId) {
        log.info("get dish {} of Restaurant {}", id, restaurantId);
        return repository.get(id, restaurantId).orElse(null);
    }

    public List<Dish> getAllByRestaurant(int restaurantId) {
        log.info("get all dishes of restaurant");
        return repository.getAllByRestaurant(restaurantId);
    }

    public List<Dish> getMenuByRestaurantByDate(int restaurantId, @Nullable LocalDate dateMenu) {
        log.info("get all dishes of restaurant");
        return repository.getMenuByRestaurantByDate(restaurantId, dateMenu);
    }
}
