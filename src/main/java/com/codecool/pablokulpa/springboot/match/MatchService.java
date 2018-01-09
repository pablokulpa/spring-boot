package com.codecool.pablokulpa.springboot.match;

import com.codecool.pablokulpa.springboot.player.Player;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface MatchService {

    List<Match> findAll();
    Match create(Match match);
    void delete(Integer id);
    Match showById(Integer id);
}
