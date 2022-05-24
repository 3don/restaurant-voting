package ru.javaops.restaurantvoting.web.restaurant;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import ru.javaops.restaurantvoting.model.Restaurant;
import ru.javaops.restaurantvoting.repository.RestaurantRepository;

import java.util.List;

import static ru.javaops.restaurantvoting.util.ValidationUtil.assureIdConsistent;
import static ru.javaops.restaurantvoting.util.ValidationUtil.checkNew;

@RestController
@RequestMapping(value = AdminRestaurantRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
@AllArgsConstructor
public class AdminRestaurantRestController {

    private RestaurantRepository repository;

    static final String REST_URL = "/api/admin/restaurants";

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        log.info("delete {}", id);
        repository.deleteExisted(id);
    }

    @GetMapping("/{id}/with-dishes")
    public Restaurant getWithDishById(@PathVariable int id) {
        log.info("get restaurant {} with its all dishes", id);
        return repository.getWithDishes(id);
    }

    @GetMapping("/with-dishes")
    public List<Restaurant> getAllWithDish() {
        log.info("get all restaurants with theirs all dishes");
        return repository.getAllWithDishes();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Restaurant createWithLocation(@RequestBody Restaurant restaurant) {
        log.info("create {}", restaurant);
        checkNew(restaurant);
        Assert.notNull(restaurant, "restaurant must not be null");
        return repository.save(restaurant);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@RequestBody Restaurant restaurant, @PathVariable int id) {
        log.info("update {} with id={}", restaurant, id);
        assureIdConsistent(restaurant, id);
        repository.save(restaurant);
    }
}
