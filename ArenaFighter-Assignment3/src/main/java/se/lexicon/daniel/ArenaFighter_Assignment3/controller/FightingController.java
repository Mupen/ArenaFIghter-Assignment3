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
	private int round = 1;
	private boolean running;

	/**
	 * 
	 * @param fightingServiceInstance is singleton of FightingService
	 * @param protagonistDaoInstance is singleton of ProtagonistDao
	 * @param antagonistDaoInstance is singleton of AntagonistDao
	 * @param currentProtagonist is Protagonist Object
	 * @param currentAntagonist is Antagonist Object
	 * @param lastTurnOrder is Antagonist or Protagonist depending on who's turn it is.
	 * 
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
		if(lastTurnOrder == null ) {lastTurnOrder = fightingServiceInstance.CombatantInitiative();}
		
		currentProtagonist = fightingServiceInstance.GetProtagonistObject();
		currentAntagonist = fightingServiceInstance.GetAntagonistObject();
		
	
		while(currentProtagonist.isAlive() && currentAntagonist.isAlive()) {
			round ++;
			if (!currentProtagonist.equals(lastTurnOrder)) {
				lastTurnOrder = currentProtagonist;
				if (currentProtagonist.getHealth() > 0) {
					fightingServiceInstance.MeleeAttack(currentProtagonist, currentAntagonist, round); 
				}
			}

			else if (!currentAntagonist.equals(lastTurnOrder)) {
				lastTurnOrder = currentAntagonist;
				if (currentAntagonist.getHealth() > 0) {
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
	            	round = 1;
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