package se.lexicon.daniel.ArenaFighter_Assignment3.data;

import static org.junit.Assert.*;

import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import se.lexicon.daniel.ArenaFighter_Assignment3.model.Protagonist;
import se.lexicon.daniel.ArenaFighter_Assignment3.util.RandomGenerator;

public class ProtagonistDaoTest {
	private ProtagonistDaoSignatures protagonistDaoInstanceTest = ProtagonistDao.getProtagonistDaoInstance();
	List<Protagonist> protagonistStorage = protagonistDaoInstanceTest.ProtagonistDao();
	private Protagonist protagonistTest;

	//Runs BEFORE each test Create a protagonist with random name and with a mace and chainmail he also 
	// get random 1-10 in attributes and instantiating his melee damage and damage reduction thanks to his armor and weapon
	// i also add him to the protagonistStorage so i can test the list.
	@Before
	public void init() {
		String randomName = RandomGenerator.getRandomName(); // placeholder
		protagonistTest = new Protagonist(randomName);
		protagonistTest.setWeapon("Mace", "The first weapon used by mankind was probably a stick or a boulder. Someone eventually thought to combine the merits of the two, and came up with the idea for the mace. It is really just a fabricated club, and while they were later perfected to be effective against armor (such as the case with the flanged mace), they were always dramatically inferior weapons (when compared to alternatives) - but extremely simple to use, requiring practically no training at all, which is why they remained popular and are in a sense, still in use! We've just altered the design and call them batons now.", 4);
		protagonistTest.setArmor("Chainmail", "Chainmail, contrary to popular belief, did not go out of fashion just because plate armor was invented and was often worn as a supplement to plate armor because it was generally much more tried and true than plate armor, which was a constantly evolving science. Chainmail is extremely good armor for avoiding cuts and stabs, but unfortunately the tips of piercing weapons tend to stick through the chain-links, and even a cut that doesn’t penetrate essentially still transfers most kinetic energy to the wearer,", 4); 
		// Call Protagonist Character Creation Method in Protagonist class
		protagonistTest.GetProtagonistCreation(protagonistTest, 0, 5);
		protagonistTest.setMeleeDamage(protagonistTest.getWeapon().getWeaponDamage() + protagonistTest.getStrenght());
		protagonistTest.setMeleeDamageReduction((protagonistTest.getArmor().getArmorDamageReduction() + protagonistTest.getConstitution())/2);
		protagonistStorage.add(protagonistTest);
	}

	//Runs AFTER each test to kill the protagonist and remove him from the protagonistStorage list.
	@After
	public void tearDown() {
		protagonistDaoInstanceTest.ProtagonistDied();
	}

	@Test
	public void testGetProtagonist() {
		fail("Not yet implemented");
	}

	@Test
	public void testProtagonistInitiative() {
		fail("Not yet implemented");
	}

	@Test
	public void testProtagonistMeleeAttack() {
		fail("Not yet implemented");
	}

	@Test
	public void testProtagonistMeleeDefence() {
		fail("Not yet implemented");
	}

}
