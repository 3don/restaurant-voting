package ru.javaops.restaurantvoting.web.dish;

import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;
import ru.javaops.restaurantvoting.model.Dish;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = UserDishRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class UserDishRestController extends AbstractDishController{

    static final String REST_URL = "/api/user/restaurants";

    @Override
    @GetMapping("/{restaurantId}/dishes/{id}")
    public Dish get(@PathVariable int id, @PathVariable int restaurantId) {
        return super.get(id, restaurantId);
    }

    @Override
    @GetMapping("/{restaurantId}/menu")
    public List<Dish> getMenuByRestaurantByDate(@PathVariable int restaurantId,
                                                @RequestParam(required = false) @Nullable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateMenu) {
        return super.getMenuByRestaurantByDate(restaurantId, dateMenu==null ? LocalDate.now():dateMenu);
    }
}
