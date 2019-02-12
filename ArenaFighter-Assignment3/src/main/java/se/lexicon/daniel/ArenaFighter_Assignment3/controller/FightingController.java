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

public class FightingController {
	private FightingServiceSignatures fightingServiceInstance;
	private ProtagonistDaoSignatures protagonistDaoInstance;
	private AntagonistDaoSignatures antagonistDaoInstance;
	private Protagonist currentProtagonist;
	private Antagonist currentAntagonist;
	private CombatantSignatures lastTurnOrder;
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
		this.currentProtagonist = protagonistDaoInstance.ProtagonistCreation();
		this.currentAntagonist = antagonistDaoInstance.AntagonistCreation();
		this.lastTurnOrder = fightingServiceInstance.CombatantInitiative();
		running = true;
	}

	public boolean isRunning() {
		return running;
	}

	public boolean isStoping() {
		return running = false;
	}

	public void run() {
		int round = 0;
		
		currentProtagonist = fightingServiceInstance.GetProtagonistObject();
		currentAntagonist = fightingServiceInstance.GetAntagonistObject();
		
		round ++;
		while(currentProtagonist.isAlive() && currentAntagonist.isAlive()) {
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
		
		if(currentProtagonist.isAlive() && !currentAntagonist.isAlive()) {
			String armorSelection = KeyboardInput.getString("What action do you want to take?" + "\n [Continue]: " + "\n [Ledger]: " + "\n [Quit]: ");
			switch (armorSelection.toLowerCase()) {
	            case "continue":
	            	fightingServiceInstance.levelUp(fightingServiceInstance.WinnerIs(currentProtagonist, currentAntagonist));
	            	break;
	            case "ledger": break;
	            case "quit": break;
	            default: break;
	        }
		}
		
		fightingServiceInstance.CombatantDied(currentProtagonist, currentAntagonist);
		
		System.out.println(currentAntagonist.getFightingLedger());
		System.out.println(currentProtagonist.getFightingLedger());
		
		isStoping();
	}
}