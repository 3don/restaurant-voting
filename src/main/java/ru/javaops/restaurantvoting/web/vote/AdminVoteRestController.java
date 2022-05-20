package ru.javaops.restaurantvoting.web.vote;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.javaops.restaurantvoting.model.Vote;
import ru.javaops.restaurantvoting.repository.VoteRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = AdminVoteRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class AdminVoteRestController {

    static final String REST_URL = "api/admin/votes";

    @Autowired
    private VoteRepository repository;

    @GetMapping
    public List<Vote> getAllByDay() {
        return repository.getAllByDay(LocalDate.now());
    }

    @GetMapping("/count")
    public Map<Integer, Long> getCount() {
        return repository.getAllByDay(LocalDate.now()).stream()
                .collect(Collectors.groupingBy(Vote::getRestaurantId, Collectors.counting()));
    }
}
