package se.lexicon.daniel.ArenaFighter_Assignment3.model;
import se.lexicon.daniel.ArenaFighter_Assignment3.service.CharacterAction;

/**
 * Created by Daniel Henriksen.
 */

public abstract class Combatant implements CharacterAction {
    
	// Attributes default if not changed
    private int strenght = 4;
    private int agility = 4;
    private int constitution = 4;
    private int charisma = 4;
    private int perception = 4;
    private int will = 4;
    
    private int armor = 2; // 2 normal 4 good 6 verry good
    private int weapon = 2; // 2 normal 4 good 6 verry good
	
    // incremental derivatives of attributes and method with as default
    private boolean isAlive = true;
    private int health = (constitution + will + 10 + getLevel());
   
    private int dodgeAttack = (int) Math.ceil((agility + perception) / 2);
    private int initiative = (int) Math.ceil((agility + perception) / 2); 

    private int meleeAttack = (int) Math.ceil((strenght + agility) / 2);
    private int meleeDamage = (int) Math.ceil((strenght + weapon) / 2);
    
    // Normal String field
    private int level;
    private String name;
    
    public void getAttributes() {
    	System.out.println("------------" + getName() + " Character Attributes ------------" +
						   "\n Strenght: " + getStrenght() + 
						   "\n Agility: " + getAgility() + 
						   "\n Constitution: " + getConstitution() + 
						   "\n Charisma: " + getCharisma() + 
						   "\n Perception: " + getPerception() + 
						   "\n Will: " + getWill());
    }
    
    // Attributes getter and setters, gains
    public int getStrenght() {
		return strenght;
	}

	public void setStrenght(int strenght) {
		this.strenght = strenght;
	}
	
    public int gainStrenght(int strenght) {
        this.strenght += strenght;
        return strenght;
    }

	public int getAgility() {
		return agility;
	}

	public void setAgility(int agility) {
		this.agility = agility;
	}
	
    public int gainAgility(int agility) {
        this.agility += agility;
        return agility;
    }

	public int getConstitution() {
		return constitution;
	}

	public void setConstitution(int constitution) {
		this.constitution = constitution;
	}
	
    public int gainConstitution(int constitution) {
        this.constitution += constitution;
        return constitution;
    }

	public int getCharisma() {
		return charisma;
	}

	public void setCharisma(int charisma) {
		this.charisma = charisma;
	}
	
    public int gainCharisma(int charisma) {
        this.charisma += charisma;
        return charisma;
    }

	public int getPerception() {
		return perception;
	}

	public void setPerception(int perception) {
		this.perception = perception;
	}
	
    public int gainPerception(int perception) {
        this.perception += perception;
        return perception;
    }

	public int getWill() {
		return will;
	}

	public void setWill(int will) {
		this.will = will;
	}
	
    public int gainWill(int will) {
        this.will += will;
        return will;
    }



    
    public Combatant(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
	public int getInitiative() {
		return initiative;
	}

	public void setInitiative(int initiative) {
		this.initiative = initiative;
	}
	
    public int getDodgeAttack() {
        return dodgeAttack;
    }
    
	public void setDodgeAttack(int dodgeAttack) {
		this.dodgeAttack = dodgeAttack;
	}
    
    public int getArmor() {
    	return armor;
    }
    
    public int setArmor(int armor) {
    	return this.armor = armor;
    }
    
	public int getWeapon() {
		return weapon;
	}
	
    public int setWeapon(int weapon) {
    	return this.weapon = weapon;
    }
	
    public int getLevel() {
        return level;
    }

    public int gainLevel(int level) {
        this.level += level;
        System.out.println(" " + name + ": I've been experiencing a lot. My level is currently = " + this.level);
        return level;
    }
    
    public int getHealth() {
        return health;
    }

    public int increaseHealth(int additionalHealth) {
        health += additionalHealth;
        System.out.println(" " + name + ": I've been healed. My health now = " + health);
        return health;
    }

    public int decreaseHealth(int opponentAttackPower) {
    	if (this.armor > 0) {System.out.println("But i have armor that proteceted me for " + armor + "]");}
    	else {System.out.println("But i dont have any armor i am going to take all of that damage...");}
    	health -= (opponentAttackPower - this.armor);
        System.out.println("after the attack i have only " + health + " health left" );
        return health;
    }
    
    public int getMeleeAttack() {
        return meleeAttack;
    }
    
	public int getMeleeDamage() {
		return meleeDamage;
	}

	public void setMeleeDamage(int meleeDamage) {
		this.meleeDamage = meleeDamage;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + charisma;
		result = prime * result + constitution;
		result = prime * result + health;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + strenght;
		result = prime * result + will;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Combatant other = (Combatant) obj;
		if (charisma != other.charisma)
			return false;
		if (constitution != other.constitution)
			return false;
		if (health != other.health)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (strenght != other.strenght)
			return false;
		if (will != other.will)
			return false;
		return true;
	}

	public boolean isAlive() {
		return isAlive;
	}

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}
}