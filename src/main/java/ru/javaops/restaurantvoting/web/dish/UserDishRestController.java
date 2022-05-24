package ru.javaops.restaurantvoting.web.dish;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;
import ru.javaops.restaurantvoting.model.Dish;
import ru.javaops.restaurantvoting.repository.DishRepository;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = UserDishRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
@AllArgsConstructor
public class UserDishRestController {

    private DishRepository repository;

    static final String REST_URL = "/api/profile/restaurants";

    @GetMapping("/{restaurantId}/dishes/{id}")
    public Dish get(@PathVariable int id, @PathVariable int restaurantId) {
        log.info("get dish {} of Restaurant {}", id, restaurantId);
        return repository.get(id, restaurantId).orElse(null);
    }

    @GetMapping("/{restaurantId}/menu")
    public List<Dish> getMenuByRestaurantByDate(@PathVariable int restaurantId,
                                                @RequestParam(required = false) @Nullable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateMenu) {
        log.info("get all dishes of restaurant {}", restaurantId);
        return repository.getMenuByRestaurantByDate(restaurantId, dateMenu == null ? LocalDate.now() : dateMenu);
    }
}
