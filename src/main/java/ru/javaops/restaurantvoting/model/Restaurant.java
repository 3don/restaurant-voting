package ru.javaops.restaurantvoting.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "restaurants")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Restaurant extends AbstractNamedEntity {


    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "registered", nullable = false, columnDefinition = "timestamp default now()", updatable = false)
    private Date registered = new Date();

    public Restaurant(Integer id, String name, String description, Date registered) {
        super(id, name);
        this.description = description;
        this.registered = registered;
    }

    public Restaurant (Restaurant r){
        this(r.id, r.name, r.description, r.registered);
    }
}
