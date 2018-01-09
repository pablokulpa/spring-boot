package com.codecool.pablokulpa.springboot.match;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/MATCH")
public class MatchController {

    private MatchService matchService;

    @Autowired
    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }

    @GetMapping(path = "")
    public Iterable<Match> index(){
        return matchService.findAll();
    }

    @GetMapping(path = "/{id}")
    public Match show(@PathVariable Integer id){
        return matchService.showById(id);
    }

    @PostMapping(path = "")
    public Match create(@RequestBody Match match){
        matchService.create(match);
        return match;
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Integer id){
        matchService.delete(id);
    }

}
