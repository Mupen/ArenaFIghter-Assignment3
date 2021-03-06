package se.lexicon.daniel.ArenaFighter_Assignment3.data;

import java.util.ArrayList;
import java.util.List;

import se.lexicon.daniel.ArenaFighter_Assignment3.model.CombatantSignatures;
import se.lexicon.daniel.ArenaFighter_Assignment3.model.Protagonist;
import se.lexicon.daniel.ArenaFighter_Assignment3.util.KeyboardInput;
import se.lexicon.daniel.ArenaFighter_Assignment3.util.RandomGenerator;

public class ProtagonistDao implements ProtagonistDaoSignatures {

	/**
	 * 
	 * @param protagonistDaoInstance is singleton of ProtagonistDao
	 * @param protagonistStorage is a method that contains a list of protagonistStorage 
	 * 
	 */
	
	// Static final instance of CourseDao need to be accessed by a method getCourseDaoInstance
	private static final ProtagonistDaoSignatures protagonistDaoInstance = new ProtagonistDao();
	public static ProtagonistDaoSignatures getProtagonistDaoInstance() {return protagonistDaoInstance;}

	// List of CrouseModels named storage gain values when the class constructor is activated. 
	// Because CourseDao can only have one instance it will only exist one storage for CourseModels
	private List<Protagonist> protagonistStorage;
	private ProtagonistDao() {protagonistStorage = new ArrayList<>();}
	
	/**
	 * 
	 * @param nameSelection given value from method KeyboardInput.getString("");
	 * @param currentProtagonist is a object that is is based on Protagonist model 
	 * @param weaponSelection given value from method KeyboardInput.getString("");
	 * @param armorSelection given value from method KeyboardInput.getString("");
	 * 
	 */
	
	@Override
	public Protagonist ProtagonistCreation() {
		String nameSelection = KeyboardInput.getString("Write the name for your Combatant: ");
		Protagonist currentProtagonist = new Protagonist(nameSelection);
		
		String weaponSelection = KeyboardInput.getString("What weapon do you want?" + "\n [Gladius]: " + "\n [Mace]: " + "\n [Axe]: ");
        switch (weaponSelection.toLowerCase()) {
            case "gladius": currentProtagonist.setWeapon("Gladius", "The Gladius is the perfected form of the earliest attempts of making a standard military sidearm. It had a broad blade that allowed it to apply some weight behind a chop, but was not a particularly good slashing weapon - though unlike its predecessors, it was specifically designed for thrusting, and was good at getting through contemporary armor. The word Gladius simply means sword, which gives you an idea of how long the sword was in use - here's a hint, we're talking several thousand years.", 2); break;
            case "mace": currentProtagonist.setWeapon("Mace", "The first weapon used by mankind was probably a stick or a boulder. Someone eventually thought to combine the merits of the two, and came up with the idea for the mace. It is really just a fabricated club, and while they were later perfected to be effective against armor (such as the case with the flanged mace), they were always dramatically inferior weapons (when compared to alternatives) - but extremely simple to use, requiring practically no training at all, which is why they remained popular and are in a sense, still in use! We've just altered the design and call them batons now.", 4); break;
            case "axe": currentProtagonist.setWeapon("Long-axe", "The first known iterations of the Long-Axe were known as Dane-Axes, as they were used by viking raiders from Scandinavia, and during that time, that mostly meant Denmark, because the rest of Scandinavia was still very rural. The axe design was later redesigned again and again until it reached the final form of the pollaxe, which was a far-cry from the original concept, featuring a warhammer head on the opposite side. The Pollaxe was the finally form, as it was designed with metal covering most of the shaft, allowing the weapon to effectively parry, be used partially as a spear, an axe and sometimes also a hammer - hence the all-around excellent stats. It was an extremely popular late-medieval weapon among footknights.  ", 6); break;
            default: currentProtagonist.setWeapon("Fists", "Fists of the north star", 1); break;
        }
        
		String armorSelection = KeyboardInput.getString("What armor do you want?" + "\n [Gambeson]: " + "\n [Chainmail: " + "\n [Brigandine]: ");
        switch (armorSelection.toLowerCase()) {
            case "gambeson": currentProtagonist.setArmor("Gambeson", " is a padded defensive jacket, worn as armour separately, or combined with mail or plate armour it becomes very good armor with mail or plate but without it become the most practical armor for commoners that can't afford metal. It also doubled as a winter coat for wearers and is good agiasnt rain.", 2); break;
            case "chainmail": currentProtagonist.setArmor("Chainmail", "Chainmail, contrary to popular belief, did not go out of fashion just because plate armor was invented and was often worn as a supplement to plate armor because it was generally much more tried and true than plate armor, which was a constantly evolving science. Chainmail is extremely good armor for avoiding cuts and stabs, but unfortunately the tips of piercing weapons tend to stick through the chain-links, and even a cut that doesn’t penetrate essentially still transfers most kinetic energy to the wearer,", 4); break;
            case "brigandine": currentProtagonist.setArmor("Brigandine", "The brigandine is the poor man's plate armor, or the rich man's hauberk if you will - it is essentially a gambeson with metal plates riveted inside the lining. While the torso component of brigandine can be made to hang down and cover the upper legs like a skirt, it cannot reasonably be used to cover the arms or lower legs - but splintmail often used to make up the difference. Brigandine is just as flexible as chainmail on the torso, but would restrict arm- and leg movement completely if it was used normally on limbs.", 6); break;
            default: currentProtagonist.setArmor("Naked", "Glorious abs!", 0); break;
        }
		
		// Call Protagonist Character Creation Method in Protagonist class
		currentProtagonist.GetProtagonistCreation(currentProtagonist, 0, 5);
        currentProtagonist.setMeleeDamage(currentProtagonist.getWeapon().getWeaponDamage() + currentProtagonist.getStrenght());
        currentProtagonist.setMeleeDamageReduction((currentProtagonist.getArmor().getArmorDamageReduction() + currentProtagonist.getConstitution())/2);
		saveProtagonistObject(currentProtagonist);
		return currentProtagonist;
	}
	
	/**
	 * 
	 * @param currentProtagonist is a object that is is based on Protagonist model 
	 * @param protagonistStorage is a method that contains a list of objects with the data type of Protagonist model  
	 * 
	 */
	
	@Override
	public Protagonist saveProtagonistObject(Protagonist currentProtagonist) throws IllegalArgumentException {
		if(currentProtagonist == null) {
			throw new IllegalArgumentException();
		}			
		if(findProtagonistById(currentProtagonist.getCombatantId()) != null) {
			throw new IllegalArgumentException("Combatant object with same id exists in storage");
			
		}
		else {
			protagonistStorage.add(currentProtagonist);
			return currentProtagonist;
		}		
	}
	
	/**
	 * 
	 * @param protagonistById is a int with a value from currentAntagonist
	 * @param protagonistObject is a object that is is based on Protagonist model
	 * @param protagonistStorage is a method that contains a list of objects with the data type of Protagonist model 
	 * 
	 */
	
	@Override
	public Protagonist findProtagonistById(int protagonistById) {
		for(Protagonist protagonistObject : protagonistStorage) {
			if(protagonistObject.getCombatantId() == protagonistById) {
				return protagonistObject;
			}
		}
		return null;
	}
	
	/**
	 * 
	 * @param protagonistStorage is a method that contains a list of objects with the data type of Protagonist model 
	 * 
	 */
	
	@Override
	public List<Protagonist> getProtagonistStorage() {
		return protagonistStorage;
	}
	
	/**
	 * 
	 * @param protagonistStorage is a method that contains a list of objects with the data type of Protagonist model 
	 * 
	 */
	
	@Override
	public void ProtagonistDied() {
		protagonistStorage.clear();
	}
	
	/**
	 * 
	 * @param protagonistObject is a object that is is based on Protagonist model
	 * @param protagonistStorage is a method that contains a list of objects with the data type of Protagonist model 
	 * 
	 */
	
	@Override
	public Protagonist GetProtagonist() {
		if (protagonistStorage.isEmpty()) {
			Protagonist protagonistObject = new Protagonist("Empty");
			return protagonistObject;
		}
		else {
			Protagonist protagonistObject = protagonistStorage.get(0);
			return protagonistObject;
		}
	}
	
	/**
	 * 
	 * @param protagonistObject is a object that is is based on Protagonist model
	 * 
	 */
	
	@Override
	public int ProtagonistInitiative(CombatantSignatures protagonistObject) {
		return protagonistObject.getInitiative() + RandomGenerator.getRandomDecimal(1,10);
	}
	
	/**
	 * 
	 * @param protagonistObject is a object that is is based on Protagonist model
	 * 
	 */
	
	@Override
	public int ProtagonistMeleeAttack(CombatantSignatures protagonistObject) {
		return protagonistObject.getMeleeAttack() + RandomGenerator.getRandomDecimal(1, 10);
	}
	
	/**
	 * 
	 * @param protagonistObject is a object that is is based on Protagonist model
	 * 
	 */
	
	@Override
	public int ProtagonistMeleeDefence(CombatantSignatures protagonistObject) {
		return protagonistObject.getDodgeAttack() + RandomGenerator.getRandomDecimal(1, 10);
	}
}