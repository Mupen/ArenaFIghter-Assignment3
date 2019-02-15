package se.lexicon.daniel.ArenaFighter_Assignment3.data;

import java.util.ArrayList;
import java.util.List;

import se.lexicon.daniel.ArenaFighter_Assignment3.model.Antagonist;
import se.lexicon.daniel.ArenaFighter_Assignment3.model.CombatantSignatures;
import se.lexicon.daniel.ArenaFighter_Assignment3.util.RandomGenerator;

public class AntagonistDao implements AntagonistDaoSignatures {

	/**
	 * 
	 * @param antagonistDaoInstance is singleton of AntagonistDao
	 * @param antagonistStorage is a method that contains a list of antagonistStorage 
	 * 
	 */
	
	// Static final instance of CourseDao need to be accessed by a method getCourseDaoInstance
	private static final AntagonistDaoSignatures antagonistDaoInstance = new AntagonistDao();
	public static AntagonistDaoSignatures getAntagonistDaoInstance() {return antagonistDaoInstance;}
	
	// List of CrouseModels named storage gain values when the class constructor is activated. 
	// Because CourseDao can only have one instance it will only exist one storage for CourseModels
	private List<Antagonist> antagonistStorage;
	private AntagonistDao() {antagonistStorage = new ArrayList<>();}
	
	/**
	 * 
	 * @param randomName given value from method RandomGenerator.getRandomName()
	 * @param currentAntagonist is a object that is is based on Antagonist model 
	 * @param weaponSelection is a int given value from method RandomGenerator.getRandomDecimal(1, 3);
	 * @param armorSelection is a int given value from method RandomGenerator.getRandomDecimal(1, 3);
	 * 
	 */
	
	@Override	
	public Antagonist AntagonistCreation() {
		// Declare and Construct an instance of the Antagonist called currentAntagonist
		String randomName = RandomGenerator.getRandomName(); // placeholder
		Antagonist currentAntagonist = new Antagonist(randomName);
		
	    int weaponSelection = RandomGenerator.getRandomDecimal(1, 3);
        switch (weaponSelection) {
            case 1: currentAntagonist.setWeapon("Gladius", "The Gladius is the perfected form of the earliest attempts of making a standard military sidearm. It had a broad blade that allowed it to apply some weight behind a chop, but was not a particularly good slashing weapon - though unlike its predecessors, it was specifically designed for thrusting, and was good at getting through contemporary armor. The word Gladius simply means sword, which gives you an idea of how long the sword was in use - here's a hint, we're talking several thousand years.", 2); break;
            case 2: currentAntagonist.setWeapon("Mace", "The first weapon used by mankind was probably a stick or a boulder. Someone eventually thought to combine the merits of the two, and came up with the idea for the mace. It is really just a fabricated club, and while they were later perfected to be effective against armor (such as the case with the flanged mace), they were always dramatically inferior weapons (when compared to alternatives) - but extremely simple to use, requiring practically no training at all, which is why they remained popular and are in a sense, still in use! We've just altered the design and call them batons now.", 4); break;
            case 3: currentAntagonist.setWeapon("Long-axe", "The first known iterations of the Long-Axe were known as Dane-Axes, as they were used by viking raiders from Scandinavia, and during that time, that mostly meant Denmark, because the rest of Scandinavia was still very rural. The axe design was later redesigned again and again until it reached the final form of the pollaxe, which was a far-cry from the original concept, featuring a warhammer head on the opposite side. The Pollaxe was the finally form, as it was designed with metal covering most of the shaft, allowing the weapon to effectively parry, be used partially as a spear, an axe and sometimes also a hammer - hence the all-around excellent stats. It was an extremely popular late-medieval weapon among footknights.  ", 6); break;
            default: currentAntagonist.setWeapon("Fists", "Fists of the north star", 1); break;
        }
        
		int armorSelection = RandomGenerator.getRandomDecimal(1, 3);
        switch (armorSelection) {
            case 1: currentAntagonist.setArmor("Gambeson", " is a padded defensive jacket, worn as armour separately, or combined with mail or plate armour it becomes very good armor with mail or plate but without it become the most practical armor for commoners that can't afford metal. It also doubled as a winter coat for wearers and is good agiasnt rain.", 2); break;
            case 2: currentAntagonist.setArmor("Chainmail", "Chainmail, contrary to popular belief, did not go out of fashion just because plate armor was invented and was often worn as a supplement to plate armor because it was generally much more tried and true than plate armor, which was a constantly evolving science. Chainmail is extremely good armor for avoiding cuts and stabs, but unfortunately the tips of piercing weapons tend to stick through the chain-links, and even a cut that doesn’t penetrate essentially still transfers most kinetic energy to the wearer,", 4); break;
            case 3: currentAntagonist.setArmor("Brigandine", "The brigandine is the poor man's plate armor, or the rich man's hauberk if you will - it is essentially a gambeson with metal plates riveted inside the lining. While the torso component of brigandine can be made to hang down and cover the upper legs like a skirt, it cannot reasonably be used to cover the arms or lower legs - but splintmail often used to make up the difference. Brigandine is just as flexible as chainmail on the torso, but would restrict arm- and leg movement completely if it was used normally on limbs.", 6); break;
            default: currentAntagonist.setArmor("Naked", "Glorious abs!", 0); break;
        }
		    
		// Call Antagonist Character Creation Method in Antagonist class
	    currentAntagonist.GetAntagonistCreation(currentAntagonist);
        currentAntagonist.setMeleeDamage(currentAntagonist.getWeapon().getWeaponDamage() + currentAntagonist.getStrenght());
        currentAntagonist.setMeleeDamageReduction((currentAntagonist.getArmor().getArmorDamageReduction() + currentAntagonist.getConstitution())/2);
	    
	    saveAntagonistObject(currentAntagonist);
	    return currentAntagonist;
	}
	
	/**
	 * 
	 * @param currentAntagonist is a object that is is based on Antagonist model 
	 * @param antagonistStorage is a list of Antagonist objects
	 * 
	 */
	
	@Override
	public Antagonist saveAntagonistObject(Antagonist currentAntagonist) throws IllegalArgumentException {
		if(currentAntagonist == null) {
			throw new IllegalArgumentException();
		}			
		if(findAntagonistById(currentAntagonist.getCombatantId()) != null) {
			throw new IllegalArgumentException("Combatant object with same id exists in storage");
			
		}
		else {
			antagonistStorage.add(currentAntagonist);
			return currentAntagonist;
		}		
	}
	
	/**
	 * 
	 * @param antagonistId is a int with a value from currentAntagonist
	 * @param currentAntagonist is a object that is is based on Antagonist model
	 * @param antagonistStorage is a method that contains a list of objects with the data type of Antagonist model 
	 * 
	 */
	
	@Override
	public Antagonist findAntagonistById(int antagonistId) {
		for(Antagonist currentAntagonist : antagonistStorage) {
			if(currentAntagonist.getCombatantId() == antagonistId) {
				return currentAntagonist;
			}
		}
		return null;
	}
	
	/**
	 * 
	 * @param antagonistStorage is a method that contains a list of antagonistStorage 
	 * 
	 */
	
	@Override
	public List<Antagonist> getAntagonistStorage() {
		return antagonistStorage;
	}
	
	/**
	 * 
	 * @param antagonistStorage is a method that contains a list of antagonistStorage 
	 * 
	 */
	
	@Override
	public void AntagonistDied() {
		antagonistStorage.clear();
	}
	
	/**
	 * 
	 * @param antagonistStorage is a method that contains a list of antagonistStorage
	 * @param currentAntagonist is a object that is is based on Antagonist model
	 * 
	 */
	
	@Override
	public Antagonist GetAntagonist() {
		if (antagonistStorage.isEmpty()) {
			Antagonist currentAntagonist = new Antagonist("Empty");
			return currentAntagonist;
		}
		else {
			Antagonist currentAntagonist = antagonistStorage.get(0);
			return currentAntagonist;
		}
	}
	
	/**
	 * 
	 * @param currentAntagonist is a object that is is based on Antagonist model
	 * 
	 */
	
	@Override
	public int AntagonistInitiative(CombatantSignatures currentAntagonist) {
		return currentAntagonist.getInitiative() + RandomGenerator.getRandomDecimal(1,10);
	}
	
	/**
	 * 
	 * @param currentAntagonist is a object that is is based on Antagonist model
	 * 
	 */
	
	@Override
	public int AntagonistMeleeAttack(CombatantSignatures currentAntagonist) {
		return currentAntagonist.getMeleeAttack() + RandomGenerator.getRandomDecimal(1, 10);
	}
	
	/**
	 * 
	 * @param currentAntagonist is a object that is is based on Antagonist model
	 * 
	 */
	
	@Override
	public int AntagonistMeleeDefence(CombatantSignatures currentAntagonist) {
		return currentAntagonist.getDodgeAttack() + RandomGenerator.getRandomDecimal(1, 10);
	}
}
