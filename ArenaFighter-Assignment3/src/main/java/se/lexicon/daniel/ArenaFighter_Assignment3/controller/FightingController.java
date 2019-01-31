package se.lexicon.daniel.ArenaFighter_Assignment3.controller;

import se.lexicon.daniel.ArenaFighter_Assignment3.model.Antagonist;
import se.lexicon.daniel.ArenaFighter_Assignment3.model.Protagonist;
import se.lexicon.daniel.ArenaFighter_Assignment3.service.FightingService;
import se.lexicon.daniel.ArenaFighter_Assignment3.service.FightingServiceSignatures;
import se.lexicon.daniel.ArenaFighter_Assignment3.util.KeyboardInput;
import se.lexicon.daniel.ArenaFighter_Assignment3.util.RandomGenerator;

public class FightingController {
	private FightingServiceSignatures fightingServiceInstance;
	private boolean running;
	private Protagonist currentProtagonist;
	private Antagonist currentAntagonist;
		
	public FightingController() {
		fightingServiceInstance = FightingService.getFightingServiceInstance();

		running = true;
	}

	public boolean isRunning() {
		return running;
	}
	
	public boolean isStoping() {
		return running = false;
	}
	
	public void run() {
		
		fightingServiceInstance.CombatantCreation();
		
		currentProtagonist = fightingServiceInstance.GetProtagonistObject();
		currentAntagonist = fightingServiceInstance.GetAntagonistObject();
		
		fightingServiceInstance.CombatantInitiative();
		
		while(currentProtagonist.isAlive() && currentAntagonist.isAlive()) {
			if (currentProtagonist.getTurns() <= currentAntagonist.getTurns()) {
				if (currentProtagonist.getHealth() > -currentProtagonist.getConstitution()) {fightingServiceInstance.MeleeAttack(currentProtagonist, currentAntagonist); }
				currentProtagonist.gainTurns(1);
			}
			else if (currentProtagonist.getTurns() >= currentAntagonist.getTurns()) {
				if (currentAntagonist.getHealth() > -currentAntagonist.getConstitution()) {fightingServiceInstance.MeleeAttack(currentAntagonist, currentProtagonist); }
				currentAntagonist.gainTurns(1);
			}
		}
		
		isStoping();
		
//		// If null initializen objects 
//		if(currentProtagonist == null) {currentProtagonist = arena.ProtagonistCreation();}
//		if(currentAntagonist == null) {currentAntagonist = arena.AntagonistCreation();}
//		
//		// Start Initiative Conflicts
//		if(initiativeWinner == null) {
//			initiativeWinner = arena.Initiative(currentProtagonist, currentAntagonist);
//		}
//		
//		// start Melee conflicts
//		while(currentProtagonist.isAlive(currentProtagonist) && currentAntagonist.isAlive(currentAntagonist)) {
//		arena.Fight(currentProtagonist, currentAntagonist, initiativeWinner);
//		}
//		
//		isStoping();
	}
	

}