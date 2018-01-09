package com.codecool.pablokulpa.springboot.match;

import com.codecool.pablokulpa.springboot.player.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchServiceImp implements MatchService{

    MatchRepository matchRepository;

    @Autowired
    public MatchServiceImp(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    @Override
    public List<Match> findAll() {
        return (List<Match>) matchRepository.findAll();
    }

    @Override
    public Match create(Match match) {
        matchRepository.save(match);
        return match;
    }


    @Override
    public void delete(Integer id) {
        matchRepository.delete(id);
    }

    @Override
    public Match showById(Integer id) {
        return matchRepository.findOne(id);
    }
}
