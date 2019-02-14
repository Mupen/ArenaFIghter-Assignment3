package se.lexicon.daniel.ArenaFighter_Assignment3.data;


import java.util.List;

import se.lexicon.daniel.ArenaFighter_Assignment3.model.Antagonist;
import se.lexicon.daniel.ArenaFighter_Assignment3.model.CombatantSignatures;

public interface AntagonistDaoSignatures {

	void AntagonistDied();
	Antagonist GetAntagonist();

	int AntagonistMeleeAttack(CombatantSignatures attacker);
	int AntagonistMeleeDefence(CombatantSignatures defender);
	int AntagonistInitiative(CombatantSignatures currentAntagonist);
	Antagonist AntagonistCreation();
	
	Antagonist saveAntagonistObject(Antagonist currentAntagonist) throws IllegalArgumentException;
	List<Antagonist> getAntagonistStorage();
	Antagonist findAntagonistById(int antagonistId);

}
