/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ccg.ancientaliens.set1.additional;

import com.ccg.ancientaliens.card.properties.Transforming;
import com.ccg.ancientaliens.card.types.Activation;
import com.ccg.ancientaliens.card.types.Item;
import com.ccg.ancientaliens.game.Game;
import static com.ccg.ancientaliens.protocol.Types.Counter.CHARGE;
import static com.ccg.ancientaliens.protocol.Types.Knowledge.BLUE;
import com.ccg.ancientaliens.set1.blue.UI08;
import helpers.Hashmap;


/**
 *
 * @author pseudo
 */
public class AI03 extends Item implements Transforming {
    
    public AI03 (UI08 c){
        super("AI03", 0, new Hashmap(BLUE, 1), 
                "Discharge 1: \n" +
                "  Opponent purges 4. \n" +
                "  If ~ has no counters on it, transform ~ to UI08", c.controller);
        copyPropertiesFrom(c);
    }

    @Override
    public boolean canActivate(Game game) {
        return counters.get(CHARGE) > 0;
    }
    
    @Override
    public void activate(Game game) {
        counters.put(CHARGE, counters.get(CHARGE) - 1);
        game.addToStack(new Activation(controller, 
                "Opponent purges 4. \n" +
                "If ~ has no counters on it, transform ~ to UI08",
            (g, c) -> {
                g.purge(g.getOpponentName(controller), 4);
                if (counters.get(CHARGE) == 0){
                    transform(g);
                }
            }));
    }

    @Override
    public void transform(Game game) {
        game.replaceWith(this, new UI08(this));
    }
}