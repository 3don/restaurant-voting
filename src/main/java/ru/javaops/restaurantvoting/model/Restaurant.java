package ru.javaops.restaurantvoting.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "restaurants")
public class Restaurant extends AbstractNamedEntity {

    @Column(name = "registered", nullable = false, columnDefinition = "timestamp default now()", updatable = false)
    private Date registered = new Date();

    @Column(name = "description", nullable = false)
    private String description;
}
