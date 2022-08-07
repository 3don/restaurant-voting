package ru.javaops.restaurantvoting.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "votes", uniqueConstraints = @UniqueConstraint(columnNames = {"vote_date", "user_id"}))
public class Vote extends AbstractBaseEntity {

    @Column(name = "vote_date")
    private LocalDate voteDate;

    @Column(name = "user_id", updatable = false, insertable = false)
    @NotNull
    private int userId;

    @JoinColumn(name = "user_id")
    @ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY)
    @Schema(hidden = true)
    private User user;

    @Column(name = "restaurant_id")
    @NotNull
    private int restaurantId;

    public Vote(LocalDate vote_date, int userId, int restaurantId) {
        this.voteDate = vote_date;
        this.userId = userId;
        this.restaurantId = restaurantId;
    }
}
