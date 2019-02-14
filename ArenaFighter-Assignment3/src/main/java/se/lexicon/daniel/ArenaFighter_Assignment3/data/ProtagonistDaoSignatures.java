package se.lexicon.daniel.ArenaFighter_Assignment3.data;

import java.util.List;

import se.lexicon.daniel.ArenaFighter_Assignment3.model.CombatantSignatures;
import se.lexicon.daniel.ArenaFighter_Assignment3.model.Protagonist;

public interface ProtagonistDaoSignatures {
	
	void ProtagonistDied();
	Protagonist GetProtagonist();

	int ProtagonistMeleeAttack(CombatantSignatures attacker);
	int ProtagonistMeleeDefence(CombatantSignatures defender);
	int ProtagonistInitiative(CombatantSignatures currentProtagonist);
	Protagonist ProtagonistCreation();
	List<Protagonist> ProtagonistDao();


}
