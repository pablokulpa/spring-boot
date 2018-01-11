package com.codecool.pablokulpa.springboot.match;

import com.codecool.pablokulpa.springboot.player.Player;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface MatchRepository extends CrudRepository<Match, Integer>{

    @Modifying
    @Transactional
    @Query("UPDATE Match SET archive = true WHERE id =:id")
    void archive(@Param("id") Integer id);

    @Query("SELECT p from Match p where p.archive like false")
    Iterable<Match> findAllByActive();


    Iterable<Match> findAllByArchiveIsFalse();

}
