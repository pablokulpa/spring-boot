package com.codecool.pablokulpa.springboot.match;

import com.codecool.pablokulpa.springboot.player.Player;
import org.hibernate.procedure.spi.ParameterRegistrationImplementor;

import javax.persistence.*;

@Entity
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToOne
    private Player player1;
    @OneToOne
    private Player player2;
    private Integer winPlayer;

    public Match(Player player1, Player player2, Integer winPlayer) {
        this.player1 = player1;
        this.player2 = player2;
        this.winPlayer = winPlayer;
    }
}

