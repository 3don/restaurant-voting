package ru.javaops.restaurantvoting.web.vote;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import ru.javaops.restaurantvoting.error.DataConflictException;
import ru.javaops.restaurantvoting.model.Vote;
import ru.javaops.restaurantvoting.repository.RestaurantRepository;
import ru.javaops.restaurantvoting.repository.UserRepository;
import ru.javaops.restaurantvoting.repository.VoteRepository;
import ru.javaops.restaurantvoting.web.AuthUser;

import java.time.LocalDate;
import java.time.LocalTime;

import static ru.javaops.restaurantvoting.util.validation.ValidationUtil.assureIdConsistent;

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

    @GetMapping
    public Vote get(@AuthenticationPrincipal AuthUser authUser) {
        log.info("get user's {} vote ", authUser.id());
        return voteRepository.get(LocalDate.now(), authUser.id()).orElse(null);
    }

    @Transactional
    @PostMapping("/{restaurantId}")
    public Vote makeVote(@PathVariable int restaurantId, @AuthenticationPrincipal AuthUser authUser) {
        log.info("make user's {} vote ", authUser.id());
        Assert.notNull(restaurantRepository.getById(restaurantId), "restaurant must not be null");
        Vote vote = get(authUser);
        Assert.isNull(vote, "vote already exist");
        vote = new Vote(LocalDate.now(), authUser.id(), restaurantId);
        vote.setUser(userRepository.getById(authUser.id()));
        return voteRepository.save(vote);
    }

    @Transactional
    @PutMapping("/{restaurantId}")
    public Vote update(@PathVariable int restaurantId,
                       @RequestBody Vote vote,
                       @AuthenticationPrincipal AuthUser authUser) {
        log.info("update user's {} vote ", authUser.id());
        Assert.notNull(restaurantRepository.getById(restaurantId), "restaurant must not be null");
        Vote updateVote = get(authUser);
        assureIdConsistent(vote, updateVote.id());
        if (LocalTime.now().isBefore(CONTROL_TIME)) {
            updateVote.setRestaurantId(restaurantId);
            return voteRepository.save(updateVote);
        } else {
            throw new DataConflictException("Changing of choice not allowed after 11:00");
        }
    }
}


