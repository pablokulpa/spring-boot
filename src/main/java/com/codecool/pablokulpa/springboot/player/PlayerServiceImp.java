package com.codecool.pablokulpa.springboot.player;

import com.codecool.pablokulpa.springboot.log.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PlayerServiceImp implements PlayerService {

    private PlayerRepository playerRepository;
    private Log log;

    @Autowired
    public PlayerServiceImp(PlayerRepository playerRepository, Log log) {
        this.playerRepository = playerRepository;
        this.log = log;
        log.setLogger(PlayerController.class);
    }

    @Override
    public List<Player> findAll() {
        log.getLog("Get index");
        return (List<Player>) playerRepository.findAll();
    }

    @Override
    public Player create(Player player) {
        log.getLog(String.format("Create player name: %s",player.getFirstName()));
        playerRepository.save(player);
        return player;
    }

    @Override
    public Player show(Integer id) {
        log.getLog(String.format("Get player index:%s",id));
        return playerRepository.findOne(id);
    }

    @Override
    public void delete(Integer id) {
        playerRepository.delete(id);
    }

    @Override
    public void softDelete(Integer id) {
        playerRepository.archive(id);
        log.getLog(String.format("Delete player id:%s",id));
    }

    @Override
    public List<Player> findActive() {
        log.getLog("Get index");
        return (List<Player>) playerRepository.findAllbyArchiveFalse();
    }
}
