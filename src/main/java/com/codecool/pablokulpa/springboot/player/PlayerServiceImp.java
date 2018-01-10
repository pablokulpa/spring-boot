package com.codecool.pablokulpa.springboot.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PlayerServiceImp implements PlayerService {

    private PlayerRepository playerRepository;

    @Autowired
    public PlayerServiceImp(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public List<Player> findAll() {
        return (List<Player>) playerRepository.findAll();
    }

    @Override
    public Player create(Player player) {
        playerRepository.save(player);
        return player;
    }

    @Override
    public Player show(Integer id) {
        return playerRepository.findOne(id);
    }

    @Override
    public void delete(Integer id) {
        playerRepository.delete(id);
    }

    @Override
    public void softDelete(Integer id) {
        playerRepository.archive(id);
    }

    @Override
    public List<Player> findActive() {
        return (List<Player>) playerRepository.findAllbyArchiveFalse();
    }
}
