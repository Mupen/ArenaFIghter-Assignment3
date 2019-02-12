package se.lexicon.daniel.ArenaFighter_Assignment3.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Daniel Henriksen.
 * @param <FightingLedger>
 */

public abstract class Combatant implements CombatantSignatures {
    
	// Attributes default if not changed
    private int strenght = 4;
    private int agility = 4;
    private int constitution = 4;
    private int charisma = 4;
    private int perception = 4;
    private int will = 4;
    
    // Normal String field
    private int level = 1;
    private int turn = 0;
    private String name;
    
    // Weapons and Armor, History objects
    private Armor armor; 
    private Weapon weapon;
    private FightingLedger fightingLedger;
    private List<FightingLedger> fightingLedgerStorage = new ArrayList<>();
    
    
	public List<FightingLedger> getFightingLedgerStorage() {return fightingLedgerStorage;}
	public void addToFightingLedgerStorage(FightingLedger fightingLedger) {fightingLedgerStorage.add(fightingLedger);}
	public FightingLedger getFightingLedger() {return fightingLedger;}
	public void setFightingLedger(int round, String attacker, int attackValue, String dodger, int dodgeValue, int damage, int damageReductionn, int healthLeft) {
		this.fightingLedger = new FightingLedger(round, attacker, attackValue, dodger, dodgeValue, damage, damageReductionn, healthLeft);
	}

    // Incremental derivatives of attributes and method with as default
    private boolean isAlive = true;
    private int health = (constitution + will + 10 + getLevel());
    private int initiative = (int) Math.ceil((agility + perception)/2); 
    private int attack = (int) Math.ceil((strenght + agility)/2);
    private int dodge = (int) Math.ceil((agility + perception)/2);
    private int meleeDamage;
    private int meleeDamageReduction;
    

    
    public void getAttributes() {
    	System.out.println("------------" + getName() + " Character Attributes ------------" +
						   "\n Strenght: " + getStrenght() + 
						   "\n Agility: " + getAgility() + 
						   "\n Constitution: " + getConstitution() + 
						   "\n Charisma: " + getCharisma() + 
						   "\n Perception: " + getPerception() + 
						   "\n Will: " + getWill());
    }
      
    // getStrenght
    public int getStrenght() {return strenght;}
	public void setStrenght(int strenght) {this.strenght = strenght;}
    public int gainStrenght(int strenght) {this.strenght += strenght; return strenght;}
    // getAgility    
	public int getAgility() {return agility;}
	public void setAgility(int agility) {this.agility = agility;}
    public int gainAgility(int agility) {this.agility += agility; return agility;}
    // getConstitution   
    public int getConstitution() {return constitution;}
	public void setConstitution(int constitution) {this.constitution = constitution;}
    public int gainConstitution(int constitution) {this.constitution += constitution; return constitution;}
    // getCharisma   
	public int getCharisma() {return charisma;}
	public void setCharisma(int charisma) {this.charisma = charisma;}
    public int gainCharisma(int charisma) {this.charisma += charisma; return charisma;}
    // getPerception   
	public int getPerception() {return perception;}
	public void setPerception(int perception) {this.perception = perception;}
    public int gainPerception(int perception) {this.perception += perception; return perception;}
    // getWill   
	public int getWill() {return will;}
	public void setWill(int will) {this.will = will;}
    public int gainWill(int will) {this.will += will; return will;}
    
    // Constructor
    public Combatant(String name) {
        this.name = name;
    }
    
    public String getName() {return name;}
    
	public int getInitiative() {return initiative;}
	public void setInitiative(int initiative) {this.initiative = initiative;}
	
    public int getDodgeAttack() {return dodge;}
	public void setDodgeAttack(int dodge) {this.dodge = dodge;}
	
    public int getMeleeAttack() {return attack;}
	
    public int getLevel() {return level;}
    public int gainLevel(int level) {
        this.level += level;
        System.out.println(" " + name + ": I've been experiencing a lot. My level is currently = " + this.level);
        return level;
    }
    
    public int getHealth() {return health;}
    public int increaseHealth(int additionalHealth) {
        health += additionalHealth;
        System.out.println(" " + name + ": I've been healed. My health now = " + health);
        return health;
    }
    
    public void decreaseHealth(int meleeDamage, int meleeDamageReduction) {
    	health -= (meleeDamage - meleeDamageReduction);
    }
    
    public void restoreHealth() {
    	health = (constitution + will + 10 + getLevel());
    }
    
	public int getTurn() {
		return turn;
	}

	public void setTurn(int turn) {
		this.turn = turn;
	}
	
	public void gainTurn(int turn) {
		this.turn += turn;
	}
	
	public Weapon getWeapon() {return weapon;}

	public void setWeapon(String weaponName, String weaponDescription, int weaponDamage) {
		this.weapon = new Weapon(weaponName, weaponDescription, weaponDamage);
		}

	public Armor getArmor() {return armor;}

	public void setArmor(String armorName, String armorDescription, int armorDamageReduction) {
		this.armor = new Armor(armorName, armorDescription, armorDamageReduction);
		}
	
	public int getMeleeDamage() {return meleeDamage;}
	public void setMeleeDamage(int meleeDamage) {this.meleeDamage = meleeDamage;}
	public int getMeleeDamageReduction() {return meleeDamageReduction;}
	public void setMeleeDamageReduction(int meleeDamageReduction) {this.meleeDamageReduction = meleeDamageReduction;}
	
	public boolean isAlive() {
		if(getHealth() > 0) {
			setAlive(true);
			return isAlive;
		}
		if(getHealth() < 0) {
			System.out.println(getName() + " Have died...");
			setAlive(false);
			return isAlive;
		}
		return isAlive;
	}
	
	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
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





}