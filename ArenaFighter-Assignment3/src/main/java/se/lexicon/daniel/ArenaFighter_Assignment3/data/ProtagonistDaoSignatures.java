package se.lexicon.daniel.ArenaFighter_Assignment3.data;

import se.lexicon.daniel.ArenaFighter_Assignment3.model.CombatantSignatures;
import se.lexicon.daniel.ArenaFighter_Assignment3.model.Protagonist;

public interface ProtagonistDaoSignatures {
	
	Protagonist ProtagonistCreation();
	
	void ProtagonistDied();
	Protagonist GetProtagonist();

	int ProtagonistMeleeDefence(CombatantSignatures defender);
	int ProtagonistMeleeAttack(CombatantSignatures attacker);
	


}
