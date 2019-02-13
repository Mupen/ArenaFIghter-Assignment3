package se.lexicon.daniel.ArenaFighter_Assignment3.controller;

import java.util.ArrayList;
import java.util.List;

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
	private int round;
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
		if(currentProtagonist == null) {currentProtagonist = protagonistDaoInstance.ProtagonistCreation();}
		if(currentAntagonist == null) {currentAntagonist = antagonistDaoInstance.AntagonistCreation();}
		
		lastTurnOrder = fightingServiceInstance.CombatantInitiative();
		
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
}