package ru.javaops.restaurantvoting;

import ru.javaops.restaurantvoting.model.Vote;

import java.time.LocalDate;

import static ru.javaops.restaurantvoting.RestaurantTestData.*;
import static ru.javaops.restaurantvoting.UserTestData.*;

public class VoteTestData {

    public static final MatcherFactory.Matcher<Vote> VOTE_MATCHER = MatcherFactory.usingIgnoringFieldsComparator(Vote.class);

    public static final int NOT_FOUND = 10;

    public static final Vote vote_past_1 = new Vote(LocalDate.now().minusDays(1), USER_ID, RESTAURANT2_ID);
    public static final Vote vote_past_2 = new Vote(LocalDate.now().minusDays(1), USER2_ID, RESTAURANT3_ID);
    public static final Vote vote_past_3 = new Vote(LocalDate.now().minusDays(1), USER3_ID, RESTAURANT2_ID);
    public static final Vote vote_past_4 = new Vote(LocalDate.now().minusDays(1), ADMIN_ID, RESTAURANT4_ID);
    public static final Vote vote_past_5 = new Vote(LocalDate.now().minusDays(1), ADMIN2_ID, RESTAURANT2_ID);
    public static final Vote vote_1 = new Vote(LocalDate.now(), USER_ID, RESTAURANT3_ID);
    public static final Vote vote_2 = new Vote(LocalDate.now(), USER2_ID, RESTAURANT4_ID);
    public static final Vote vote_3 = new Vote(LocalDate.now(), USER3_ID, RESTAURANT2_ID);

    public static Vote getNew() {
        return new Vote(LocalDate.now(), USER3_ID, RESTAURANT2_ID);
    }

    public static Vote getUpdated() {
        Vote updated = new Vote(vote_3.getVoteDate(), vote_3.getUserId(), RESTAURANT1_ID);
        return updated;
    }
}
