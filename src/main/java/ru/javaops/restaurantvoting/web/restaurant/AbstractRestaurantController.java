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

    public void delete(int id){
        log.info("delete {}", id);
        repository.deleteExisted(id);
    }

    public Restaurant getWithDishById(int id){
        return repository.getWithDishes(id);
    }

    public List<Restaurant> getAllWithDish(){
        return repository.getAllWithDishes();
    }
}
