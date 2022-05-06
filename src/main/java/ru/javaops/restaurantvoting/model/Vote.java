package ru.javaops.restaurantvoting.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "votes", uniqueConstraints = @UniqueConstraint(columnNames = {"vote_date", "user_id"}))
public class Vote extends AbstractBaseEntity{

    @Column(name = "vote_date")
    private LocalDate vote_date;

    @JoinColumn(name = "user_id")
    @ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY)
    private User user;

    @Column(name = "user_id", updatable=false, insertable=false)
    private int user_id;

    @Column(name = "restaurant_id")
    @NotNull
    private int restaurant_id;

    public Vote(LocalDate vote_date, int user_id, int restaurant_id) {
        this.vote_date=vote_date;
        this.user_id=user_id;
        this.restaurant_id=restaurant_id;
    }
}
