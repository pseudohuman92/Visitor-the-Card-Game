/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.visitor.sets.base;

import com.visitor.card.types.Unit;
import com.visitor.game.Game;
import com.visitor.helpers.CounterMap;

import java.util.UUID;

import static com.visitor.card.properties.Combat.CombatAbility.Flying;
import static com.visitor.protocol.Types.Knowledge.BLUE;

/**
 * @author pseudo
 */
public class Sparrow extends Unit {

	public Sparrow (Game game, UUID owner) {
		super(game, "Sparrow",
				1, new CounterMap(BLUE, 1),
				"",
				1, 1,
				owner, Flying);
	}
}
