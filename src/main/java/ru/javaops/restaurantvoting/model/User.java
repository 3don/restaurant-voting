package ru.javaops.restaurantvoting.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import ru.javaops.restaurantvoting.util.validation.NoHtml;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@ToString(callSuper = true, exclude = {"password"})
public class User extends AbstractBaseEntity {

    @Column(name = "email", nullable = false, unique = true)
    @Email
    @NotBlank
    @Size(max = 128)
    @NoHtml
    private String email;

    @Column(name = "first_name")
    @Size(max = 128)
    @NoHtml
    private String firstName;

    @Column(name = "last_name")
    @Size(max = 128)
    @NoHtml
    private String lastName;

    @Column(name = "password", nullable = false)
    @Size(max = 256)
    @NotBlank
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @Column(name = "registered", nullable = false, columnDefinition = "timestamp default now()", updatable = false)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @NotNull
    private Date registered = new Date();

    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"),
            uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id", "role"}, name = "uk_user_roles")})
    @Column(name = "role")
    @JoinColumn(name = "user_id")
    @ElementCollection(fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Set<Role> roles;

    public User(Integer id, String email, String firstName, String lastname, String password, Date registered, Collection<Role> roles) {
        super(id);
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastname;
        this.password = password;
        this.registered = registered;
        setRoles((Set<Role>) roles);
    }

    public User(User u) {
        this(u.id, u.email, u.firstName, u.lastName, u.password, u.registered, u.roles);
    }
}