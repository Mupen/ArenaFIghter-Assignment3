package se.lexicon.daniel.ArenaFighter_Assignment3.service;

import se.lexicon.daniel.ArenaFighter_Assignment3.model.Antagonist;
import se.lexicon.daniel.ArenaFighter_Assignment3.model.CombatantSignatures;
import se.lexicon.daniel.ArenaFighter_Assignment3.model.Protagonist;

public interface FightingServiceSignatures {

	void CombatantCreation();
	CombatantSignatures CombatantInitiative();
	
	Protagonist GetProtagonistObject();
	Antagonist GetAntagonistObject();
	void MeleeAttack(CombatantSignatures attacker, CombatantSignatures defender, int round);
	void CombatantDied(CombatantSignatures currentProtagonist, CombatantSignatures currentAntagonist);
	CombatantSignatures WinnerIs(CombatantSignatures currentProtagonist, CombatantSignatures currentAntagonist);
	void levelUp(CombatantSignatures winner);

	


}

