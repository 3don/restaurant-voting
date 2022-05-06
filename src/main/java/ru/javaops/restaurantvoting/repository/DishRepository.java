package ru.javaops.restaurantvoting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.javaops.restaurantvoting.model.Dish;

public interface DishRepository extends JpaRepository<Dish, Integer> {
}