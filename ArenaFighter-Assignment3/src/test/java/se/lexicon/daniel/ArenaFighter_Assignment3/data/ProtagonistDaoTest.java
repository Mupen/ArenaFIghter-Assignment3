package se.lexicon.daniel.ArenaFighter_Assignment3.data;

import static org.junit.Assert.*;

import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import se.lexicon.daniel.ArenaFighter_Assignment3.model.Protagonist;
import se.lexicon.daniel.ArenaFighter_Assignment3.util.RandomGenerator;

public class ProtagonistDaoTest {
	private ProtagonistDaoSignatures ProtagonistDaoTest = ProtagonistDao.getProtagonistDaoInstance();
	
	// Course test 1
	private int protagonistTestId1;
	private Protagonist protagonistTest;

	//Runs BEFORE each test Create a protagonist with random name and with a mace and chainmail he also 
	// get random 1-10 in attributes and instantiating his melee damage and damage reduction thanks to his armor and weapon
	// i also add him to the protagonistStorage so i can test the list.
	@Before
	public void init() {
		String randomName = RandomGenerator.getRandomName();
		protagonistTest = new Protagonist(randomName);
		protagonistTest.gainStrenght(2);
		protagonistTest.gainAgility(2);
		protagonistTest.gainConstitution(2);
		protagonistTest.gainCharisma(2);
		protagonistTest.gainPerception(2);
		protagonistTest.gainWill(2);
		protagonistTest.setWeapon("Mace", "The first weapon used by mankind was probably a stick or a boulder. Someone eventually thought to combine the merits of the two, and came up with the idea for the mace. It is really just a fabricated club, and while they were later perfected to be effective against armor (such as the case with the flanged mace), they were always dramatically inferior weapons (when compared to alternatives) - but extremely simple to use, requiring practically no training at all, which is why they remained popular and are in a sense, still in use! We've just altered the design and call them batons now.", 4);
		protagonistTest.setArmor("Chainmail", "Chainmail, contrary to popular belief, did not go out of fashion just because plate armor was invented and was often worn as a supplement to plate armor because it was generally much more tried and true than plate armor, which was a constantly evolving science. Chainmail is extremely good armor for avoiding cuts and stabs, but unfortunately the tips of piercing weapons tend to stick through the chain-links, and even a cut that doesn’t penetrate essentially still transfers most kinetic energy to the wearer,", 4); 
		protagonistTest.setMeleeDamage(protagonistTest.getWeapon().getWeaponDamage() + protagonistTest.getStrenght());
		protagonistTest.setMeleeDamageReduction((protagonistTest.getArmor().getArmorDamageReduction() + protagonistTest.getConstitution())/2);
		protagonistTestId1 = protagonistTest.getCombatantId();
	}

	//Runs AFTER each test to remove the protagonist from the protagonistStorage list.
	@After
	public void tearDown() {ProtagonistDaoTest.ProtagonistDied();}
	

	@Test
	public void testSaveProtagonistObjectAndGet() {
		assertEquals(protagonistTest, ProtagonistDaoTest.saveProtagonistObject(protagonistTest));
		assertEquals(protagonistTest, ProtagonistDaoTest.GetProtagonist());
	}
	
	@Test
	public void testfindProtagonistById() {
		for(Protagonist protagonistTest : ProtagonistDaoTest.getProtagonistStorage()) {
			if(protagonistTest.getCombatantId() == 1) {
				assertEquals(protagonistTest, ProtagonistDaoTest.GetProtagonist());
				assertEquals(protagonistTest, ProtagonistDaoTest.findProtagonistById(protagonistTestId1));
			}
		}
	}

	@Test
	public void testProtagonistInitiative() {
		int x = 0;
		while(x <= 100) {
			x++;
			if(x <= 100) 
			{
				assertTrue(protagonistTest.getInitiative() <= ProtagonistDaoTest.ProtagonistInitiative(protagonistTest) && ProtagonistDaoTest.ProtagonistInitiative(protagonistTest) <= protagonistTest.getInitiative() + 10);
				System.out.println(x);
			}
		}
	}

	@Test
	public void testProtagonistMeleeAttack() {
		int x = 0;
		while(x <= 100) {
			x++;
			if(x <= 100) 
			{
				assertTrue(protagonistTest.getMeleeAttack() <= ProtagonistDaoTest.ProtagonistMeleeAttack(protagonistTest) && ProtagonistDaoTest.ProtagonistMeleeAttack(protagonistTest) <= protagonistTest.getMeleeAttack() + 10);
				System.out.println(x);
			}
		}
	}

	@Test
	public void testProtagonistMeleeDefence() {
		int x = 0;
		while(x <= 100) {
			x++;
			if(x <= 100) 
			{
				assertTrue(protagonistTest.getDodgeAttack() <= ProtagonistDaoTest.ProtagonistMeleeDefence(protagonistTest) && ProtagonistDaoTest.ProtagonistMeleeDefence(protagonistTest) <= protagonistTest.getDodgeAttack() + 10);
				System.out.println(x);
			}
		}
	}
}
