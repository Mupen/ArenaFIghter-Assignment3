package se.lexicon.daniel.ArenaFighter_Assignment3.data;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import se.lexicon.daniel.ArenaFighter_Assignment3.model.Antagonist;
import se.lexicon.daniel.ArenaFighter_Assignment3.util.RandomGenerator;
import se.lexicon.daniel.ArenaFighter_Assignment3.data.AntagonistDao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AntagonistDaoTest {
	private AntagonistDaoSignatures AntagonistDaoTest = AntagonistDao.getAntagonistDaoInstance();
	
	// Course test 1
	private int antagonistTestId1;
	private Antagonist antagonistTest;

	//Runs BEFORE each test Create a antagonist with random name and with a mace and chainmail he also 
	// get random 1-10 in attributes and instantiating his melee damage and damage reduction thanks to his armor and weapon
	// i also add him to the antagonistStorage so i can test the list.
	@Before
	public void init() {
		String randomName = RandomGenerator.getRandomName();
		antagonistTest = new Antagonist(randomName);
		antagonistTest.setWeapon("Mace", "The first weapon used by mankind was probably a stick or a boulder. Someone eventually thought to combine the merits of the two, and came up with the idea for the mace. It is really just a fabricated club, and while they were later perfected to be effective against armor (such as the case with the flanged mace), they were always dramatically inferior weapons (when compared to alternatives) - but extremely simple to use, requiring practically no training at all, which is why they remained popular and are in a sense, still in use! We've just altered the design and call them batons now.", 4);
		antagonistTest.setArmor("Chainmail", "Chainmail, contrary to popular belief, did not go out of fashion just because plate armor was invented and was often worn as a supplement to plate armor because it was generally much more tried and true than plate armor, which was a constantly evolving science. Chainmail is extremely good armor for avoiding cuts and stabs, but unfortunately the tips of piercing weapons tend to stick through the chain-links, and even a cut that doesn’t penetrate essentially still transfers most kinetic energy to the wearer,", 4); 
		antagonistTest.GetAntagonistCreation(antagonistTest);
		antagonistTest.setMeleeDamage(antagonistTest.getWeapon().getWeaponDamage() + antagonistTest.getStrenght());
		antagonistTest.setMeleeDamageReduction((antagonistTest.getArmor().getArmorDamageReduction() + antagonistTest.getConstitution())/2);
		antagonistTestId1 = antagonistTest.getCombatantId();
	}

	//Runs AFTER each test to remove the antagonist from the antagonistStorage list.
	@After
	public void tearDown() {AntagonistDaoTest.AntagonistDied();}
	

	@Test
	public void testSaveAntagonistObjectAndGet() {
		assertEquals(antagonistTest, AntagonistDaoTest.saveAntagonistObject(antagonistTest));
		assertEquals(antagonistTest, AntagonistDaoTest.GetAntagonist());
	}
	
	@Test
	public void testfindAntagonistById() {
		AntagonistDaoTest.saveAntagonistObject(antagonistTest);
		assertEquals(antagonistTest, AntagonistDaoTest.findAntagonistById(antagonistTestId1));
	}

	@Test
	public void testAntagonistInitiative() {
		int x = 0;
		while(x <= 100) {
			x++;
			if(x <= 100) 
			{
				assertTrue(antagonistTest.getInitiative() <= AntagonistDaoTest.AntagonistInitiative(antagonistTest) && AntagonistDaoTest.AntagonistInitiative(antagonistTest) <= antagonistTest.getInitiative() + 10);
				System.out.println(x);
			}
		}
	}

	@Test
	public void testAntagonistMeleeAttack() {
		int x = 0;
		while(x <= 100) {
			x++;
			if(x <= 100) 
			{
				assertTrue(antagonistTest.getMeleeAttack() <= AntagonistDaoTest.AntagonistMeleeAttack(antagonistTest) && AntagonistDaoTest.AntagonistMeleeAttack(antagonistTest) <= antagonistTest.getMeleeAttack() + 10);
				System.out.println(x);
			}
		}
	}

	@Test
	public void testAntagonistMeleeDefence() {
		int x = 0;
		while(x <= 100) {
			x++;
			if(x <= 100) 
			{
				assertTrue(antagonistTest.getDodgeAttack() <= AntagonistDaoTest.AntagonistMeleeDefence(antagonistTest) && AntagonistDaoTest.AntagonistMeleeDefence(antagonistTest) <= antagonistTest.getDodgeAttack() + 10);
				System.out.println(x);
			}
		}
	}
}
