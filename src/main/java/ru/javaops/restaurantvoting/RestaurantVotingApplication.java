package ru.javaops.restaurantvoting;

import lombok.AllArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import ru.javaops.restaurantvoting.model.Role;
import ru.javaops.restaurantvoting.model.User;
import ru.javaops.restaurantvoting.repository.UserRepository;
import ru.javaops.restaurantvoting.service.UserService;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Set;

@SpringBootApplication
@AllArgsConstructor
public class RestaurantVotingApplication implements ApplicationRunner {
    private final UserRepository userRepository;
    private final UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(RestaurantVotingApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) {
        /*userRepository.save(new User(null,"user@gmail.com", "User_First", "User_Last", "password", Calendar.getInstance().getTime(), Set.of(Role.USER)));
        userRepository.save(new User(null,"admin@javaops.ru", "Admin_First", "Admin_Last", "admin", Calendar.getInstance().getTime(), Set.of(Role.USER, Role.ADMIN)));
        System.out.println(userRepository.findAll());*/

    }
}
