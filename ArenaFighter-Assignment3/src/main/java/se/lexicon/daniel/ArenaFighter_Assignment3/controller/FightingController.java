package se.lexicon.daniel.ArenaFighter_Assignment3.controller;

import se.lexicon.daniel.ArenaFighter_Assignment3.data.AntagonistDao;
import se.lexicon.daniel.ArenaFighter_Assignment3.data.AntagonistDaoSignatures;
import se.lexicon.daniel.ArenaFighter_Assignment3.data.ProtagonistDao;
import se.lexicon.daniel.ArenaFighter_Assignment3.data.ProtagonistDaoSignatures;
import se.lexicon.daniel.ArenaFighter_Assignment3.model.Antagonist;
import se.lexicon.daniel.ArenaFighter_Assignment3.model.CombatantSignatures;
import se.lexicon.daniel.ArenaFighter_Assignment3.model.Protagonist;
import se.lexicon.daniel.ArenaFighter_Assignment3.service.FightingService;
import se.lexicon.daniel.ArenaFighter_Assignment3.service.FightingServiceSignatures;
import se.lexicon.daniel.ArenaFighter_Assignment3.util.KeyboardInput;
import se.lexicon.daniel.ArenaFighter_Assignment3.util.RandomGenerator;

public class FightingController {
	private FightingServiceSignatures fightingServiceInstance;
	private ProtagonistDaoSignatures protagonistDaoInstance;
	private AntagonistDaoSignatures antagonistDaoInstance;
	private Protagonist currentProtagonist;
	private Antagonist currentAntagonist;
	private CombatantSignatures lastTurnOrder;
	private int round = 1;
	private boolean running;

	/**
	 * @param fightingServiceInstance is first fighter
	 * @param protagonistDaoInstance is the opponent fighter
	 * @param antagonistDaoInstance is the opponent fighter
	 * @param currentProtagonist is the Players fighter
	 * @param currentAntagonist is the Ai's fighter
	 * @param lastTurnOrder is Players fighter or Ai's fighter
	 */

	public FightingController() {
		fightingServiceInstance = FightingService.getFightingServiceInstance();
		protagonistDaoInstance = ProtagonistDao.getProtagonistDaoInstance();
		antagonistDaoInstance = AntagonistDao.getAntagonistDaoInstance();
		running = true;
	}

	public boolean isRunning() {
		return running;
	}

	public boolean isStoping() {
		return running = false;
	}

	public void run() {
		
		if(currentProtagonist == null) {newProtagonist(;)}
		
		if(currentAntagonist == null) {newAntagonist();}
		
		if(currentProtagonist == null) {newCombatant();}
		if(currentAntagonist == null) {newCombatant();}
		
		
		
		lastTurnOrder = fightingServiceInstance.CombatantInitiative();
		
		currentProtagonist = fightingServiceInstance.GetProtagonistObject();
		currentAntagonist = fightingServiceInstance.GetAntagonistObject();
		
	
		while(currentProtagonist.isAlive() && currentAntagonist.isAlive()) {
			round ++;
			if (!currentProtagonist.equals(lastTurnOrder)) {
				lastTurnOrder = currentProtagonist;
				currentProtagonist.gainTurn(1);
				if (currentProtagonist.getHealth() > -currentProtagonist.getConstitution()) {
					fightingServiceInstance.MeleeAttack(currentProtagonist, currentAntagonist, round); 
				}
			}

			else if (!currentAntagonist.equals(lastTurnOrder)) {
				lastTurnOrder = currentAntagonist;
				currentAntagonist.gainTurn(1);
				if (currentAntagonist.getHealth() > -currentAntagonist.getConstitution()) {
					fightingServiceInstance.MeleeAttack(currentAntagonist, currentProtagonist, round); 
				}
			}
		}
		
		System.out.println("");
		System.out.println("|----------" + fightingServiceInstance.WinnerIs(currentProtagonist, currentAntagonist).getName().replaceAll("[a-zA-Z\\s]", "-") + "-" + "-|");
		System.out.println("| Winner is " + fightingServiceInstance.WinnerIs(currentProtagonist, currentAntagonist).getName() + " |");
		System.out.println("|----------" + fightingServiceInstance.WinnerIs(currentProtagonist, currentAntagonist).getName().replaceAll("[a-zA-Z\\s]", "-") + "-" + "-|");
		System.out.println("");
		
		actionSelection();

    	fightingServiceInstance.CombatantDied(currentProtagonist, currentAntagonist);
	}
	
	public void actionSelection() {
		int stopActionSelection = 0;
		while(stopActionSelection  == 0) {
			String actionSelection = KeyboardInput.getString("What action do you want to take?" + "\n [Continue]: " + "\n [Ledger]: " + "\n [Quit]: ");
			switch (actionSelection.toLowerCase()) {
	            case "continue":
	            	fightingServiceInstance.levelUp(fightingServiceInstance.WinnerIs(currentProtagonist, currentAntagonist));
	            	if(currentProtagonist.isAlive() && !currentAntagonist.isAlive()) {currentAntagonist = null;}
	            	else if(!currentProtagonist.isAlive() && currentAntagonist.isAlive()) {currentProtagonist = null;}
	            	stopActionSelection = 1;
	            	round = 0;
	            	break;
	            case "ledger":
	            	
	            	currentProtagonist.getFightingLedgerStorage().forEach(n -> System.out.print(n.stringBuilder()));
	        		break;
	            case "quit":
	            	stopActionSelection = 1;
	            	isStoping(); 
	            	break;
	            default: actionSelection(); break;
	        }
		}
	}
	
	
	public void newAntagonist() {
		String randomName = RandomGenerator.getRandomName(); // placeholder
		
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
		currentAntagonist = antagonistDaoInstance.AntagonistCreation(randomName, armorSelection, armorSelection);
	}
	
	public void newProtagonist() {
		String nameSelection = KeyboardInput.getString("Write the name for your Combatant: ");
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
        currentProtagonist = protagonistDaoInstance.ProtagonistCreation(nameSelection, armorSelection, armorSelection);
	}
}