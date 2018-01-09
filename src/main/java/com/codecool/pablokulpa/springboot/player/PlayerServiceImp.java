package com.codecool.pablokulpa.springboot.player;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PlayerServiceImp implements PlayerService {

    private PlayerRepository playerRepository;

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
}
