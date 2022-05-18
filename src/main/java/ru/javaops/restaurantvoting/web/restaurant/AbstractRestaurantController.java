package ru.javaops.restaurantvoting.web.restaurant;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import ru.javaops.restaurantvoting.model.Restaurant;
import ru.javaops.restaurantvoting.repository.RestaurantRepository;

import java.util.List;

@Slf4j
public abstract class AbstractRestaurantController {

    @Autowired
    private RestaurantRepository repository;

    public Restaurant get(int id) {
        log.info("get restaurant {}", id);
        return repository.findById(id).orElse(null);
    }

    public List<Restaurant> getAll() {
        log.info("get all restaurants");
        List<Restaurant> restaurants = repository.findAll();
        return restaurants;
    }

    public Restaurant getWithDishById(int id){
        log.info("get restaurant with its all dishes");
        return repository.getWithDishes(id);
    }

    public List<Restaurant> getAllWithDish(){
        log.info("get all restaurants with theirs all dishes");
        return repository.getAllWithDishes();
    }

    public Restaurant getWithTodaysDishById(int id){
        log.info("get restaurant with its today's dishes");
        return repository.getWithTodaysDishes(id);
    }

    public List<Restaurant> getAllWithTodaysDish(){
        log.info("get all restaurants with theirs today's dishes");
        return repository.getAllWithTodaysDishes();
    }
}
