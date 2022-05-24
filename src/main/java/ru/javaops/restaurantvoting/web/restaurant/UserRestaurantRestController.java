package ru.javaops.restaurantvoting.web.restaurant;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.javaops.restaurantvoting.model.Restaurant;
import ru.javaops.restaurantvoting.repository.RestaurantRepository;

import java.util.List;

@RestController
@RequestMapping(value = UserRestaurantRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
@AllArgsConstructor
public class UserRestaurantRestController {

    private RestaurantRepository repository;

    static final String REST_URL = "/api/profile/restaurants";

    @GetMapping("/{id}")
    public Restaurant get(@PathVariable int id) {
        log.info("get restaurant {}", id);
        return repository.findById(id).orElse(null);
    }

    @GetMapping()
    public List<Restaurant> getAll() {
        log.info("get all restaurants");
        return repository.findAll();
    }

    @GetMapping("/{id}/with-menu")
    public Restaurant getWithTodaysDishById(@PathVariable int id) {
        log.info("get restaurant {} with its today's dishes", id);
        return repository.getWithTodaysDishes(id);
    }

    @GetMapping("/with-menu")
    public List<Restaurant> getAllWithTodaysDish() {
        log.info("get all restaurants with theirs today's dishes");
        return repository.getAllWithTodaysDishes();
    }
}

