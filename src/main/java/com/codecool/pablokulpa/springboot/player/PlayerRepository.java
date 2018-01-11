package com.codecool.pablokulpa.springboot.player;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface PlayerRepository extends CrudRepository<Player, Integer>{

    @Modifying
    @Transactional
    @Query("UPDATE Player SET isArchive = true WHERE id =:id")
    void archive(@Param("id") Integer id);

    @Query("SELECT p from Player p where p.isArchive like false")
    Iterable<Player> findAllbyArchiveFalse();
}
