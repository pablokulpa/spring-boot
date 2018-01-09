package com.codecool.pablokulpa.springboot.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/player")
public class PlayerController {

    private PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping(path = "")
    public Iterable<Player> index(){
        return playerService.findAll();
    }

    @GetMapping(path = "/{id}")
    public Player show(@PathVariable Integer id){
        return playerService.show(id);
    }

    @PostMapping(path = "")
    public Player create(@RequestBody Player player){
        playerService.create(player);
        return player;
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Integer id){
        playerService.delete(id);
    }
}
