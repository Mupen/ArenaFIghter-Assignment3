package se.lexicon.daniel.ArenaFighter_Assignment3.data;

import se.lexicon.daniel.ArenaFighter_Assignment3.model.CombatantSignatures;
import se.lexicon.daniel.ArenaFighter_Assignment3.model.Protagonist;

public interface ProtagonistDaoSignatures {
	
	Protagonist ProtagonistCreation(String nameSelection, String weaponSelection, String armorSelection);
	void ProtagonistDied();
	Protagonist GetProtagonist();

	int ProtagonistMeleeAttack(CombatantSignatures attacker);
	int ProtagonistMeleeDefence(CombatantSignatures defender);
	int ProtagonistInitiative(CombatantSignatures currentProtagonist);


}
