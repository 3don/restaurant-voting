package ru.javaops.restaurantvoting.web.vote;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import ru.javaops.restaurantvoting.error.DataConflictException;
import ru.javaops.restaurantvoting.model.Vote;
import ru.javaops.restaurantvoting.repository.RestaurantRepository;
import ru.javaops.restaurantvoting.repository.UserRepository;
import ru.javaops.restaurantvoting.repository.VoteRepository;

import java.time.LocalDate;
import java.time.LocalTime;

import static ru.javaops.restaurantvoting.util.UserUtil.getAdminId;

@RestController
@RequestMapping(value = UserVoteRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class UserVoteRestController {

    static final String REST_URL = "api/profile/vote";
    private final LocalTime CONTROL_TIME = LocalTime.of(11, 0);

    private final VoteRepository voteRepository;
    private final UserRepository userRepository;
    private final RestaurantRepository restaurantRepository;

    public UserVoteRestController(VoteRepository voteRepository, UserRepository userRepository, RestaurantRepository restaurantRepository) {
        this.voteRepository = voteRepository;
        this.userRepository = userRepository;
        this.restaurantRepository = restaurantRepository;
    }


    //TODO: add authorization
    @GetMapping
    public Vote get() {
        log.info("get user's {} vote ", getAdminId());
        return voteRepository.get(LocalDate.now(), getAdminId()).orElse(null);
    }

    @Transactional
    @PostMapping("{restaurantId}")
    public Vote makeVote(@PathVariable int restaurantId) {
        log.info("make user's {} vote ", getAdminId());
        Assert.notNull(restaurantRepository.getById(restaurantId), "restaurant must not be null");
        Vote vote = get();
        if (vote == null) {
            vote = new Vote(LocalDate.now(), getAdminId(), restaurantId);
            vote.setUser(userRepository.getById(getAdminId()));
            return voteRepository.save(vote);
        } else {
            if (LocalTime.now().isBefore(CONTROL_TIME)) {
                vote.setRestaurantId(restaurantId);
                return vote;
            } else {
                throw new DataConflictException("Changing of choice not allowed after 11:00");
            }
        }
    }


}
