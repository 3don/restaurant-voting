package ru.javaops.restaurantvoting.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import ru.javaops.restaurantvoting.util.validation.NoHtml;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "restaurants")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Restaurant extends AbstractNamedEntity {


    @Column(name = "description", nullable = false)
    @NoHtml
    private String description;

    @Column(name = "registered", nullable = false, columnDefinition = "timestamp default now()", updatable = false)
    private Date registered = new Date();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "restaurant")//, cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JsonManagedReference
    @OnDelete(action = OnDeleteAction.CASCADE) //https://stackoverflow.com/a/44988100/548473
    @Schema(hidden = true)
    private List<Dish> dishes;

    public Restaurant(Integer id, String name, String description, Date registered) {
        super(id, name);
        this.description = description;
        this.registered = registered;
    }

    public Restaurant(Restaurant r) {
        this(r.id, r.name, r.description, r.registered);
    }
}
