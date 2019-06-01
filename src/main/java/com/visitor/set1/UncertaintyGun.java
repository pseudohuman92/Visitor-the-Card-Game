/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.visitor.set1;

import com.visitor.card.types.Ability;
import com.visitor.card.types.Item;
import com.visitor.game.Game;
import static com.visitor.protocol.Types.Knowledge.BLUE;
import com.visitor.helpers.Hashmap;
import com.visitor.helpers.Arraylist;
import java.util.UUID;

/**
 *
 * @author pseudo
 */
public class UncertaintyGun extends Item {
    
    int x;
    
    public UncertaintyGun(String owner) {
        super("Uncertainty Gun", 1, new Hashmap(BLUE, 2), 
        "X, Sacrifice ~: \n" +
        "  Look at opponent's deck. \n" +
        "  Choose a card that costs X or less from it. \n" +
        "  Transform chosen card into junk.", owner);
    }

    @Override
    public boolean canActivate(Game game) {
        return true;
    }

    @Override
    public void activate(Game game) {
        x = game.selectX(controller, game.getPlayer(controller).energy);
        game.destroy(id);
        game.addToStack(new Ability(this, 
            "  Look at opponent's deck. \n" +
            "  Choose a card that costs "+x+" or less from it. \n" +
            "  Transform chosen card into junk.",
        (y) -> {
            Arraylist<UUID> s = game.selectFromList(controller, 
                    game.getZone(game.getOpponentName(controller), "deck"), 
                    c->{return c.cost <= x;}, 1, true);
            if (!s.isEmpty()){
                game.transformToJunk(s.get(0));
            }
        }));
    }
    
}
