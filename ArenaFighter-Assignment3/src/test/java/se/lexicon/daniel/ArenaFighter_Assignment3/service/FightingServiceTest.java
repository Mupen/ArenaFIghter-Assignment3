package se.lexicon.daniel.ArenaFighter_Assignment3.service;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;

import java.util.List;

import se.lexicon.daniel.ArenaFighter_Assignment3.data.AntagonistDao;
import se.lexicon.daniel.ArenaFighter_Assignment3.data.AntagonistDaoSignatures;
import se.lexicon.daniel.ArenaFighter_Assignment3.data.ProtagonistDao;
import se.lexicon.daniel.ArenaFighter_Assignment3.data.ProtagonistDaoSignatures;
import se.lexicon.daniel.ArenaFighter_Assignment3.model.Antagonist;
import se.lexicon.daniel.ArenaFighter_Assignment3.model.CombatantSignatures;
import se.lexicon.daniel.ArenaFighter_Assignment3.model.Protagonist;

public class FightingServiceTest {
	
    /**
     * 
     * Singletons of ProtagonistDao, AntagonistDao, FightingService
     * @FightingServiceTest given the @fightingServiceInstance reference 
     * @ProtagonistDaoTest given the @ProtagonistDaoInstance reference 
     * @AntagonistDaoTest given the @AntagonistDaoInstance reference
     *  
     * instance of models @protagonistObject, @antagonistObject
     * @protagonistObject with data type @Protagonist is the reference for a new instance of @Protagonist 
     * @antagonistObject with data type @Antagonist is the reference for a new instance of @Antagonist
     * 	     
     * */
	
	private FightingServiceSignatures FightingServiceTest;
	private ProtagonistDaoSignatures ProtagonistDaoTest;
	private AntagonistDaoSignatures AntagonistDaoTest;
	
	// Models
	private Protagonist protagonistObject;
	private int protagonistObjectId;
	
	private Antagonist antagonistObject;
	private int antagonistObjectId;
	

	//Runs BEFORE each test
	@Before
	public void init() {
		
		FightingServiceTest = FightingService.getFightingServiceInstance();
		ProtagonistDaoTest = ProtagonistDao.getProtagonistDaoInstance();
		AntagonistDaoTest = AntagonistDao.getAntagonistDaoInstance();
		
		// Antagonist
		antagonistObject = new Antagonist("Antagonist");
		antagonistObject.setWeapon("Mace", "The first weapon used by mankind was probably a stick or a boulder. Someone eventually thought to combine the merits of the two, and came up with the idea for the mace. It is really just a fabricated club, and while they were later perfected to be effective against armor (such as the case with the flanged mace), they were always dramatically inferior weapons (when compared to alternatives) - but extremely simple to use, requiring practically no training at all, which is why they remained popular and are in a sense, still in use! We've just altered the design and call them batons now.", 4);
		antagonistObject.setArmor("Chainmail", "Chainmail, contrary to popular belief, did not go out of fashion just because plate armor was invented and was often worn as a supplement to plate armor because it was generally much more tried and true than plate armor, which was a constantly evolving science. Chainmail is extremely good armor for avoiding cuts and stabs, but unfortunately the tips of piercing weapons tend to stick through the chain-links, and even a cut that doesn’t penetrate essentially still transfers most kinetic energy to the wearer,", 4); 
		antagonistObject.GetAntagonistCreation(antagonistObject);
		antagonistObject.setMeleeDamage(antagonistObject.getWeapon().getWeaponDamage() + antagonistObject.getStrenght());
		antagonistObject.setMeleeDamageReduction((antagonistObject.getArmor().getArmorDamageReduction() + antagonistObject.getConstitution())/2);
		antagonistObjectId = antagonistObject.getCombatantId();
		
		// Protagonist
		protagonistObject = new Protagonist("Protagonist");
		protagonistObject = new Protagonist("Protagonist");
		protagonistObject.gainStrenght(2);
		protagonistObject.gainAgility(2);
		protagonistObject.gainConstitution(2);
		protagonistObject.gainCharisma(2);
		protagonistObject.gainPerception(2);
		protagonistObject.gainWill(2);
		protagonistObject.setWeapon("Mace", "The first weapon used by mankind was probably a stick or a boulder. Someone eventually thought to combine the merits of the two, and came up with the idea for the mace. It is really just a fabricated club, and while they were later perfected to be effective against armor (such as the case with the flanged mace), they were always dramatically inferior weapons (when compared to alternatives) - but extremely simple to use, requiring practically no training at all, which is why they remained popular and are in a sense, still in use! We've just altered the design and call them batons now.", 4);
		protagonistObject.setArmor("Chainmail", "Chainmail, contrary to popular belief, did not go out of fashion just because plate armor was invented and was often worn as a supplement to plate armor because it was generally much more tried and true than plate armor, which was a constantly evolving science. Chainmail is extremely good armor for avoiding cuts and stabs, but unfortunately the tips of piercing weapons tend to stick through the chain-links, and even a cut that doesn’t penetrate essentially still transfers most kinetic energy to the wearer,", 4); 
		protagonistObject.setMeleeDamage(protagonistObject.getWeapon().getWeaponDamage() + protagonistObject.getStrenght());
		protagonistObject.setMeleeDamageReduction((protagonistObject.getArmor().getArmorDamageReduction() + protagonistObject.getConstitution())/2);
		protagonistObjectId = protagonistObject.getCombatantId();
	}

	
    /**
     * 
     * @param AntagonistDied call method to clear List<Antagonist> @antagonistStorage
     * @param ProtagonistDied call method to clear List<Protagonist> @protagonistStorage
     * 	     
     * */
	
	//Runs AFTER each test
	@After
	public void tearDown() {
		AntagonistDaoTest.AntagonistDied();
		ProtagonistDaoTest.ProtagonistDied();
	}
	
    /**
     * 
     * @param ProtagonistDao.getProtagonistDaoInstance() call for @protagonistDaoInstance a singleton of @ProtagonistDao  
     * @param ntagonistDao.getAntagonistDaoInstance() call for @antagonistDaoInstance a singleton of @AntagonistDao  
     * 	     
     * */
	
	@Test
	public void testGetFightingServiceInstance() {
		assertEquals(ProtagonistDaoTest, ProtagonistDao.getProtagonistDaoInstance());
		assertNotSame(ProtagonistDaoTest, AntagonistDao.getAntagonistDaoInstance());
		assertNotSame(AntagonistDaoTest, ProtagonistDao.getProtagonistDaoInstance());
		assertEquals(AntagonistDaoTest, AntagonistDao.getAntagonistDaoInstance());
	}

	@Test
	public void testCombatantDied(CombatantSignatures currentProtagonist,CombatantSignatures currentAntagonist) {
			if(currentProtagonist == null) {protagonistDaoSignaturesObject.ProtagonistDied();}
			if(currentAntagonist == null) {antagonistDaoSignaturesObject.AntagonistDied();}
		}
	}

	@Test
	public void testGetProtagonistObject() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAntagonistObject() {
		fail("Not yet implemented");
	}

	@Test
	public void testCombatantInitiative() {
		fail("Not yet implemented");
	}

	@Test
	public void testMeleeAttack() {
		fail("Not yet implemented");
	}

	@Test
	public void testWinnerIs() {
		fail("Not yet implemented");
	}

	@Test
	public void testLevelUp() {
		fail("Not yet implemented");
	}

}
