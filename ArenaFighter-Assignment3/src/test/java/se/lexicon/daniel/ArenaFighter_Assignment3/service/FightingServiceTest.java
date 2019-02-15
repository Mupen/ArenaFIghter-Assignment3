package se.lexicon.daniel.ArenaFighter_Assignment3.service;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;
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
	private Antagonist antagonistObject;
	

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
		assertEquals(antagonistObject, AntagonistDaoTest.saveAntagonistObject(antagonistObject));
		
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
		assertEquals(protagonistObject, ProtagonistDaoTest.saveProtagonistObject(protagonistObject));
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
     * @param AntagonistDao.getAntagonistDaoInstance() call for @antagonistDaoInstance a singleton of @AntagonistDao  
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
	public void testCombatantDied() { 
		assertEquals(antagonistObject, AntagonistDaoTest.GetAntagonist());
		assertEquals(protagonistObject, ProtagonistDaoTest.GetProtagonist());
		
		ProtagonistDaoTest.ProtagonistDied();
		AntagonistDaoTest.AntagonistDied();
		
		assertNotSame(antagonistObject, AntagonistDaoTest.GetAntagonist());
		assertNotSame(protagonistObject, ProtagonistDaoTest.GetProtagonist());
	} 
	
	@Test
	public void testGetCombatants() { 
		protagonistObject = null;
		antagonistObject = null;
		FightingServiceTest.CombatantDied(protagonistObject, antagonistObject);
		Antagonist antagonistObject = new Antagonist("Empty");
		Protagonist protagonistObject = new Protagonist("Empty");
		assertEquals(protagonistObject, ProtagonistDaoTest.GetProtagonist());
		assertEquals(antagonistObject, AntagonistDaoTest.GetAntagonist());
	} 
	
	@Test
	public void TestGetProtagonistObject() { 
		assertEquals(protagonistObject, FightingServiceTest.GetProtagonistObject());
	} 
	
	@Test
	public void TestGetAntagonistObject() { 
		assertEquals(antagonistObject, FightingServiceTest.GetAntagonistObject());
	} 

	@Test
	public void testCombatantInitiative() {
		int x = 0;
		while(x <= 10) {
			x++;
			CombatantSignatures InitiativeWinner = FightingServiceTest.CombatantInitiative();
			if(protagonistObject.equals(InitiativeWinner)) {
				assertEquals(protagonistObject, InitiativeWinner);
				assertNotSame(antagonistObject, InitiativeWinner);
			}
			else if(antagonistObject.equals(InitiativeWinner)) {
				assertEquals(antagonistObject, InitiativeWinner);
				assertNotSame(protagonistObject, InitiativeWinner);
			}
			else {
				assertNotSame(antagonistObject, InitiativeWinner);
				assertNotSame(protagonistObject, InitiativeWinner);
			}
		}
	}

	@Test
	public void testMeleeAttack() {
		assertTrue(ProtagonistDaoTest.GetProtagonist().getFightingLedgerStorage().isEmpty());
		FightingServiceTest.MeleeAttack(ProtagonistDaoTest.GetProtagonist(), AntagonistDaoTest.GetAntagonist(), 1);
		assertEquals(ProtagonistDaoTest.GetProtagonist().getFightingLedgerStorage(), ProtagonistDaoTest.GetProtagonist().getFightingLedgerStorage());

		assertTrue(AntagonistDaoTest.GetAntagonist().getFightingLedgerStorage().isEmpty());
		FightingServiceTest.MeleeAttack(AntagonistDaoTest.GetAntagonist(), ProtagonistDaoTest.GetProtagonist(), 2);
		assertEquals(AntagonistDaoTest.GetAntagonist().getFightingLedgerStorage(), AntagonistDaoTest.GetAntagonist().getFightingLedgerStorage());
	}

	@Test
	public void testWinnerIs() {
		antagonistObject.decreaseHealth(10, 0);
		CombatantSignatures winnerIs = FightingServiceTest.WinnerIs(protagonistObject, antagonistObject);
		if(winnerIs.equals(protagonistObject)) {
			assertEquals(ProtagonistDaoTest.GetProtagonist(), winnerIs);
			assertNotSame(AntagonistDaoTest.GetAntagonist(), winnerIs);
		}
		antagonistObject.increaseHealth(10);
		protagonistObject.decreaseHealth(10, 0);
		winnerIs = FightingServiceTest.WinnerIs(protagonistObject, antagonistObject);
		if(winnerIs.equals(antagonistObject)) {
			assertEquals(AntagonistDaoTest.GetAntagonist(), winnerIs);
			assertNotSame(ProtagonistDaoTest.GetProtagonist(), winnerIs);
		}
	}

	@Test
	public void testLevelUp() {
		CombatantSignatures winnerIs = FightingServiceTest.WinnerIs(antagonistObject, antagonistObject);
		FightingServiceTest.levelUp(winnerIs);
	}
}
