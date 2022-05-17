package ru.javaops.restaurantvoting.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name = "dishes")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Dish extends AbstractNamedEntity {

    @Column(name = "date_menu", nullable = false)
    @NotNull
    private LocalDate date_menu;

    @Column(name = "price", nullable = false)
    @NotNull
    private int price;

    @Column(name = "description", nullable = false)
    @NotBlank
    @Size(min = 2, max = 120)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id", nullable = false)
    @JsonBackReference
    @NotNull
    @Schema(hidden = true)
    private Restaurant restaurant;

    public Dish(Integer id, String name, String description, int price, LocalDate date_menu) {
        super(id, name);
        this.description = description;
        this.price = price;
        this.date_menu = date_menu;
    }
}
