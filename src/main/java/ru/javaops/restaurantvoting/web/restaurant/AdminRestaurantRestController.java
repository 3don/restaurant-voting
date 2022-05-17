package ru.javaops.restaurantvoting.web.restaurant;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.javaops.restaurantvoting.model.Restaurant;

import java.util.List;

@RestController
@RequestMapping(value = AdminRestaurantRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class AdminRestaurantRestController extends AbstractRestaurantController{

    static final String REST_URL = "/api/admin/restaurants";

    @Override
    @GetMapping("/{id}")
    public Restaurant get(@PathVariable int id) {
        return super.get(id);
    }

    @Override
    @GetMapping()
    public List<Restaurant> getAll(){
        return super.getAll();
    }

    @Override
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        super.delete(id);
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


}
