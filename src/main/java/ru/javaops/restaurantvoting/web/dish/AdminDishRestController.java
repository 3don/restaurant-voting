package ru.javaops.restaurantvoting.web.dish;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;
import ru.javaops.restaurantvoting.model.Dish;
import ru.javaops.restaurantvoting.repository.DishRepository;
import ru.javaops.restaurantvoting.service.DishService;

import java.time.LocalDate;
import java.util.List;

import static ru.javaops.restaurantvoting.util.ValidationUtil.assureIdConsistent;
import static ru.javaops.restaurantvoting.util.ValidationUtil.checkNew;


@RestController
@RequestMapping(value = AdminDishRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
@AllArgsConstructor
public class AdminDishRestController {

    private final DishRepository repository;
    private final DishService service;

    static final String REST_URL = "/api/admin/restaurants";

    @GetMapping("/dishes")
    public List<Dish> getAll() {
        log.info("get all dishes");
        return repository.findAll();
    }

    @DeleteMapping("/{restaurantId}/dishes/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id, @PathVariable int restaurantId) {
        log.info("delete {}", id);
        Dish dish = repository.checkBelong(id, restaurantId);
        repository.delete(dish);
    }

    @PutMapping(value = "/{restaurantId}/dishes/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable int restaurantId, @RequestBody Dish dish, @PathVariable int id) {
        log.info("update {} for restaurant {}", dish, restaurantId);
        assureIdConsistent(dish, id);
        repository.checkBelong(id, restaurantId);
        service.save(dish, restaurantId);
    }

    @PostMapping(value = "/{restaurantId}/dishes", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Dish create(@PathVariable int restaurantId, @RequestBody Dish dish) {
        log.info("create {} for user {}", dish, restaurantId);
        checkNew(dish);
        return service.save(dish, restaurantId);
    }
}
