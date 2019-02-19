/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ccg.ancientaliens.set1.black;

import com.ccg.ancientaliens.card.properties.Targeting;
import com.ccg.ancientaliens.card.types.Activation;
import com.ccg.ancientaliens.card.types.Card;
import com.ccg.ancientaliens.card.types.Item;
import com.ccg.ancientaliens.game.Game;
import static com.ccg.ancientaliens.protocol.Types.Knowledge.BLACK;
import helpers.Hashmap;
import java.util.ArrayList;
import java.util.UUID;

/**
 *
 * @author pseudo
 */
public class BI05 extends Item {
    
    public BI05 (String owner){
        super("BI05", 3, new Hashmap(BLACK, 2), 
                "3, Activate: Draw top item of opponent's deck.", owner);
    }

    @Override
    public boolean canActivate(Game game) {
        return !depleted && game.hasACardInVoid(controller);
    }

    @Override
    public void activate(Game game) {
        game.deplete(id);
        game.spendEnergy(controller, 3);
        game.addToStack(new Activation ("", controller,
            "Draw top item of opponent's deck",
            null, g -> {
                Card c = g.players.get(g.getOpponentName(controller))
                        .deck.extractFromTop(Item.class);
                c.controller = controller;
                c.knowledge = new Hashmap<>();
                g.players.get(controller).hand.add(c);
            }));
    }
}