package se.lexicon.daniel.ArenaFighter_Assignment3.model;

import java.util.List;

/**
 * Created by Daniel Henriksen.
 */

public interface CombatantSignatures {
	
    String getName();

    // Health related signatures
    boolean isAlive();
    int getHealth();
    int increaseHealth(int additionalHealth);
	void decreaseHealth(int meleeDamage, int meleeDamageReduction);
	void restoreHealth();
	
    // Gain level
    int gainLevel(int level);
    int getMeleeAttack();
    int getDodgeAttack();
    int getInitiative();
	
	// Get attributes
    int getStrenght();
    int getAgility();
    int getConstitution();
    int getCharisma();
    int getPerception();
    int getWill();
    
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
    
    // void gainTurn();
    Weapon getWeapon();
    Armor getArmor();

    int getMeleeDamage();
    int getMeleeDamageReduction();
	void setMeleeDamage(int meleeDamage);
	void setMeleeDamageReduction(int meleeDamageReduction);
}
