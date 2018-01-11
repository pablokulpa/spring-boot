package com.codecool.pablokulpa.springboot.player;

import com.codecool.pablokulpa.springboot.SpringbootApplication;
import com.codecool.pablokulpa.springboot.log.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/player")
public class PlayerController {


    private PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping(path = "")
    public Iterable<Player> index(){
        return playerService.findActive();
    }

    @GetMapping(path = "/{id}")
    public Player show(@PathVariable Integer id){
        return playerService.show(id);
    }

    @PostMapping(path = "")
    public Player create(@RequestBody Player player){
        return playerService.create(player);
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Integer id){
        playerService.softDelete(id);
    }
}
