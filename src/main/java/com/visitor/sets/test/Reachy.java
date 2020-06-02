/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.visitor.sets.test;

import com.visitor.card.types.Unit;
import com.visitor.game.Game;
import com.visitor.helpers.CounterMap;

import static com.visitor.card.properties.Combat.CombatAbility.Reach;

/**
 * @author pseudo
 */
public class Reachy extends Unit {

	public Reachy (Game game, String owner) {
		super(game, "Reachy",
				0, new CounterMap(),
				"",
				2, 3,
				owner, Reach);
	}
}
