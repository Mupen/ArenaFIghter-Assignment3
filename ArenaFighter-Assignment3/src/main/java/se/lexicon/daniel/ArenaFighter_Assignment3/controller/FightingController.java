package se.lexicon.daniel.ArenaFighter_Assignment3.controller;

import java.time.LocalDate;

import se.lexicon.daniel.ArenaFighter_Assignment3.data.AntagonistDao;
import se.lexicon.daniel.ArenaFighter_Assignment3.data.AntagonistDaoSignatures;
import se.lexicon.daniel.ArenaFighter_Assignment3.data.ProtagonistDao;
import se.lexicon.daniel.ArenaFighter_Assignment3.data.ProtagonistDaoSignatures;
import se.lexicon.daniel.ArenaFighter_Assignment3.model.Antagonist;
import se.lexicon.daniel.ArenaFighter_Assignment3.model.CombatantSignatures;
import se.lexicon.daniel.ArenaFighter_Assignment3.model.Protagonist;
import se.lexicon.daniel.ArenaFighter_Assignment3.model.CombatHistory;
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
	 * @param currentProtagonist is the opponent fighter
	 * @param currentAntagonist is the opponent fighter
	 * @param lastTurnOrder is the opponent fighter
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

		currentProtagonist = fightingServiceInstance.GetProtagonistObject();
		currentAntagonist = fightingServiceInstance.GetAntagonistObject();

		while(currentProtagonist.isAlive() && currentAntagonist.isAlive()) {
			if (!currentProtagonist.equals(lastTurnOrder)) {
				lastTurnOrder = currentProtagonist;
				currentProtagonist.gainTurns(1);
				if (currentProtagonist.getHealth() > -currentProtagonist.getConstitution()) {
					fightingServiceInstance.MeleeAttack(currentProtagonist, currentAntagonist); 
				}
			}

			else if (!currentAntagonist.equals(lastTurnOrder)) {
				lastTurnOrder = currentAntagonist;
				currentAntagonist.gainTurns(1);
				if (currentAntagonist.getHealth() > -currentAntagonist.getConstitution()) {
					fightingServiceInstance.MeleeAttack(currentAntagonist, currentProtagonist); 
				}
			}
		}
		fightingServiceInstance.levelUppifAlive(currentProtagonist, currentAntagonist);
		isStoping();
	}
}