package com.codecool.pablokulpa.springboot.match;

import com.codecool.pablokulpa.springboot.player.Player;
import com.codecool.pablokulpa.springboot.player.PlayerRepository;
import com.codecool.pablokulpa.springboot.player.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.management.PlatformLoggingMXBean;
import java.util.List;

@Service
public class MatchServiceImp implements MatchService{

    MatchRepository matchRepository;
    PlayerRepository playerRepository;

    @Autowired
    public MatchServiceImp(MatchRepository matchRepository, PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
        this.matchRepository = matchRepository;
    }

    @Override
    public List<Match> findAll() {
        return (List<Match>) matchRepository.findAll();
    }

    @Override
    public Match create(Match match) {
        Player player1 = playerRepository.findOne(match.getPlayer1().getId());
        Player player2 = playerRepository.findOne(match.getPlayer2().getId());
        match.setPlayer1(player1);

        match.setPlayer2(player2);
        return matchRepository.save(match);
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
