package se.lexicon.daniel.ArenaFighter_Assignment3.data;

import se.lexicon.daniel.ArenaFighter_Assignment3.model.Antagonist;
import se.lexicon.daniel.ArenaFighter_Assignment3.model.Combatant;
import se.lexicon.daniel.ArenaFighter_Assignment3.model.CombatantSignatures;

public interface AntagonistDaoSignatures {

	Antagonist AntagonistCreation(String randomName, int weaponSelection, int armorSelection);
	void AntagonistDied();
	Antagonist GetAntagonist();

	int AntagonistMeleeAttack(CombatantSignatures attacker);
	int AntagonistMeleeDefence(CombatantSignatures defender);
	int AntagonistInitiative(CombatantSignatures currentAntagonist);


}
