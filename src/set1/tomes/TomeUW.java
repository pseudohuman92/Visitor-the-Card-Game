/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package set1.tomes;

import cards.Tome;
import client.Client;
import enums.Knowledge;
import java.util.HashMap;

/**
 *
 * @author pseudo
 */
public class TomeUW extends Tome {
    
    public TomeUW(String owner) {
        super("Tome UW", "Gain {U} {W}", "tome.png", owner);
    }

    @Override
    public void playAsSource(Client client) {
        HashMap<Knowledge, Integer> knl = new HashMap<>();
        knl.put(Knowledge.BLUE, 1);
        knl.put(Knowledge.WHITE, 1);
        client.playSource(this, knl);
    }
    
}