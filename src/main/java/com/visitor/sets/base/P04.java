/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.visitor.sets.base;

import com.visitor.card.types.Unit;
import com.visitor.game.Game;
import com.visitor.helpers.CounterMap;

import static com.visitor.card.properties.Combat.CombatAbility.Flying;
import static com.visitor.protocol.Types.Knowledge.PURPLE;

/**
 * @author pseudo
 */
public class P04 extends Unit {

	public P04 (Game game, String owner) {
		super(game, "Black Bear",
				4, new CounterMap(PURPLE, 1),
				"",
				3, 1,
				owner, Flying);
	}
}
