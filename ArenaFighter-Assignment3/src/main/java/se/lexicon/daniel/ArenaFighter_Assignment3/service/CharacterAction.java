package se.lexicon.daniel.ArenaFighter_Assignment3.service;

import se.lexicon.daniel.ArenaFighter_Assignment3.model.Antagonist;
import se.lexicon.daniel.ArenaFighter_Assignment3.model.Protagonist;

public interface CharacterAction {
	
	
	
	void MeleeAttack(CharacterAction opponent);

	CharacterAction RollInitiative(Protagonist currentProtagonist, Antagonist currentAntagonist);
	
	int getMeleeAttack();
	int getDodgeAttack();
	int getInitiative();
	int getHealth();
	
    String getName();
    
	
    int increaseHealth(int additionalHealth);
    int decreaseHealth(int opponentAttackPower);
    
    int gainLevel(int level);
    
	int setArmor(int grade);
	int setWeapon(int grade);
	
    int gainStrenght(int i);
    int gainAgility(int i);
    int gainConstitution(int i);
    int gainCharisma(int i);
    int gainPerception(int i);
    int gainWill(int i);
    
    void setStrenght(int i);
    void setAgility(int i);
    void setConstitution(int i);
    void setCharisma(int i);
    void setPerception(int i);
    void setWill(int i);

	

}
