package ru.javaops.restaurantvoting.web.restaurant;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ru.javaops.restaurantvoting.model.Restaurant;
import ru.javaops.restaurantvoting.repository.RestaurantRepository;

import java.net.URI;
import java.util.List;

import static ru.javaops.restaurantvoting.util.ValidationUtil.assureIdConsistent;
import static ru.javaops.restaurantvoting.util.ValidationUtil.checkNew;

@RestController
@RequestMapping(value = AdminRestaurantRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class AdminRestaurantRestController extends AbstractRestaurantController {

    @Autowired
    private RestaurantRepository repository;
    static final String REST_URL = "/api/admin/restaurants";

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

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        log.info("delete {}", id);
        repository.deleteExisted(id);
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

    @Override
    @GetMapping("/{id}/dishes")
    public Restaurant getWithDishById(@PathVariable int id) {
        return super.getWithDishById(id);
    }

    @Override
    @GetMapping("/dishes")
    public List<Restaurant> getAllWithDish() {
        return super.getAllWithDish();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Restaurant> createWithLocation(@RequestBody Restaurant restaurant) {
        log.info("create {}", restaurant);
        checkNew(restaurant);
        Assert.notNull(restaurant, "restaurant must not be null");
        Restaurant created = repository.save(restaurant);
        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(REST_URL + "/{id}")
                .buildAndExpand(created.getId()).toUri();
        return ResponseEntity.created(uriOfNewResource).body(created);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@RequestBody Restaurant restaurant, @PathVariable int id) {
        log.info("update {} with id={}", restaurant, id);
        assureIdConsistent(restaurant, id);
        repository.save(restaurant);
    }
}
