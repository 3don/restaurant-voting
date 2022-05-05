package ru.javaops.restaurantvoting.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vote {

    private LocalDate vote_date;
    private int user_id;
    private int restaurant_id;
}
