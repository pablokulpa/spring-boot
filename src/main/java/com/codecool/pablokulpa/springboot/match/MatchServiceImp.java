package com.codecool.pablokulpa.springboot.match;

import com.codecool.pablokulpa.springboot.log.Log;
import com.codecool.pablokulpa.springboot.player.Player;
import com.codecool.pablokulpa.springboot.player.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MatchServiceImp implements MatchService{

    MatchRepository matchRepository;
    PlayerRepository playerRepository;
    Log log;

    @Autowired
    public MatchServiceImp(MatchRepository matchRepository, PlayerRepository playerRepository, Log log) {
        this.matchRepository = matchRepository;
        this.playerRepository = playerRepository;
        this.log = log;
        log.setLogger(MatchController.class);
    }

    @Override
    public List<Match> findAll() {
        return (List<Match>) matchRepository.findAll();
    }

    @Override
    public Match create(Match match) {
        if(match.getPlayer1().getId()!=null){
            Player player1 = playerRepository.findOne(match.getPlayer1().getId());
            match.setPlayer1(player1);
        }
        if(match.getPlayer2().getId()!=null){
            Player player2 = playerRepository.findOne(match.getPlayer2().getId());
            match.setPlayer2(player2);
        }

        log.getLog("Create new Match");
        return matchRepository.save(match);
    }


    @Override
    public void delete(Integer id) {
        matchRepository.delete(id);
    }

    @Override
    public void softDelete(Integer id) {
        if(matchRepository.findOne(id)==null) {
            throw new EmptyResultDataAccessException(1);
        } else {
            log.getLog(String.format("Get player index:%s",id));
            matchRepository.archive(id);
        }

    }

    @Override
    public Match showById(Integer id) {
        if(matchRepository.findOne(id)==null){
            throw new EmptyResultDataAccessException(1);
        }else {
            log.getLog(String.format("Get player index:%s",id));
            return matchRepository.findOne(id);
        }
    }

    @Override
    public List<Match> findAllActive() {
        log.getLog("Export all avaiable Match");
        return (List<Match>) matchRepository.findAllByActive();
    }
}
