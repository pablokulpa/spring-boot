package com.codecool.pablokulpa.springboot.player;

import java.util.List;

public interface PlayerService {
    List<Player> findAll();
    Player create(Player player);
    Player show(Integer id);
    void delete(Integer id);
    void softDelete(Integer id);
    List<Player> findActive();

}
