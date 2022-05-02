package ru.javaops.restaurantvoting.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "dishes")
public class Dish extends AbstractNamedEntity{

    @Column(name = "date_time", nullable = false)
    private LocalDateTime dateTime;

    @Column(name = "price", nullable = false)
    private int price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private Restaurant restaurant;
}
