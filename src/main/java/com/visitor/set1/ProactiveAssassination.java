/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.visitor.set1;

import com.visitor.card.types.Ally;
import com.visitor.card.types.Card;
import com.visitor.card.types.Item;
import com.visitor.card.types.Spell;
import com.visitor.card.types.Tome;
import com.visitor.game.Game;
import com.visitor.helpers.Hashmap;
import com.visitor.protocol.Types;
import static com.visitor.protocol.Types.Knowledge.BLACK;
import static com.visitor.protocol.Types.Knowledge.BLUE;
import static com.visitor.protocol.Types.Knowledge.RED;
import java.util.UUID;

/**
 *
 * @author pseudo
 */
public class ProactiveAssassination extends Spell{

    int x;
    
    public ProactiveAssassination(String owner) {
        super("Proactive Assassination", -1, new Hashmap(BLACK, 2), 
        "Discard the top ally of the opponent’s deck that costs X or less.", owner);
    }
    
    @Override
    public boolean canPlay(Game game){ 
        return super.canPlay(game);
    }
    
    @Override
    public void play(Game game) {
        x = game.selectX(controller, game.getEnergy(controller));
        cost = x;
        game.spendEnergy(controller, cost);
        game.addToStack(this);
    }
    
    @Override
    public void resolveEffect (Game game){
        Card ca = game.getPlayer(game.getOpponentName(controller)).deck.extractTopmost(c->{return c instanceof Ally && c.cost <= x;});
        if (ca != null){
            game.putTo(game.getOpponentName(controller), ca, "scrapyard");
        }
        cost = -1;
        x = 0; 
    }
    
    @Override
    public Types.Card.Builder toCardMessage() {
        return super.toCardMessage()
                .setCost(cost==-1?"X":(""+cost));
    }
}

