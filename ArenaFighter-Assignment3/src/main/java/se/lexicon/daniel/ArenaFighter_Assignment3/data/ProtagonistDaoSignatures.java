package se.lexicon.daniel.ArenaFighter_Assignment3.data;

import se.lexicon.daniel.ArenaFighter_Assignment3.model.Antagonist;
import se.lexicon.daniel.ArenaFighter_Assignment3.model.Combatant;
import se.lexicon.daniel.ArenaFighter_Assignment3.model.Protagonist;

public interface ProtagonistDaoSignatures {

	void ProtagonistMeleeAttack(Combatant defender, Combatant attacker);
}