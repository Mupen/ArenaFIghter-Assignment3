package se.lexicon.daniel.ArenaFighter_Assignment3.model;

/**
 * Created by Daniel Henriksen.
 */

public interface CombatantSignatures {
	
    String getName();
	
    // Health related signatures
    int getHealth();
    int increaseHealth(int additionalHealth);
    int decreaseHealth(int opponentAttackPower);
    
    // Gain level
    int gainLevel(int level);
    int getMeleeAttack();
    int getMeleeDamage();
    int getDodgeAttack();
    int getInitiative();
	
    // set armor and weapon grade
    int setArmor(int grade);
	int setWeapon(int grade);
	
	// Gain attributes
    int gainStrenght(int i);
    int gainAgility(int i);
    int gainConstitution(int i);
    int gainCharisma(int i);
    int gainPerception(int i);
    int gainWill(int i);
    
    // set attributes
    void setStrenght(int i);
    void setAgility(int i);
    void setConstitution(int i);
    void setCharisma(int i);
    void setPerception(int i);
    void setWill(int i);

}
