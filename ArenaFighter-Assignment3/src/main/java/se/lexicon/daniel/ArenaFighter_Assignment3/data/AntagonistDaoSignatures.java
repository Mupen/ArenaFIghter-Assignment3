package se.lexicon.daniel.ArenaFighter_Assignment3.data;

import se.lexicon.daniel.ArenaFighter_Assignment3.model.Antagonist;
import se.lexicon.daniel.ArenaFighter_Assignment3.model.CombatantSignatures;

public interface AntagonistDaoSignatures {

	Antagonist AntagonistCreation();

	void AntagonistDied();
	Antagonist GetAntagonist();

	int AntagonistMeleeAttack(CombatantSignatures attacker);
	int AntagonistMeleeDefence(CombatantSignatures attacker);


}
