package ru.javaops.restaurantvoting.web.restaurant;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.javaops.restaurantvoting.model.Restaurant;

import java.util.List;

@RestController
@RequestMapping(value = UserRestaurantRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class UserRestaurantRestController extends AbstractRestaurantController{

    static final String REST_URL = "/api/user/restaurants";

    @Override
    @GetMapping("/{id}")
    public Restaurant get(@PathVariable int id) {
        return super.get(id);
    }

    @Override
    @GetMapping()
    public List<Restaurant> getAll() {
        return super.getAll();
    }

    @Override
    @GetMapping("/{id}/menu")
    public Restaurant getWithTodaysDishById(@PathVariable int id) {
        return super.getWithTodaysDishById(id);
    }

    @Override
    @GetMapping("/menu")
    public List<Restaurant> getAllWithTodaysDish() {
        return super.getAllWithTodaysDish();
    }

}

