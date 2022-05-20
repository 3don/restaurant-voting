package ru.javaops.restaurantvoting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import ru.javaops.restaurantvoting.model.Vote;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Transactional(readOnly = true)
public interface VoteRepository extends JpaRepository<Vote, Integer> {

    @Query("SELECT v FROM Vote v WHERE v.voteDate = :voteDate and v.user.id = :userId")
    Optional<Vote> get(LocalDate voteDate, int userId);

    @Query("SELECT v FROM Vote v WHERE v.voteDate = :voteDate")
    List<Vote> getAllByDay(LocalDate voteDate);
}
