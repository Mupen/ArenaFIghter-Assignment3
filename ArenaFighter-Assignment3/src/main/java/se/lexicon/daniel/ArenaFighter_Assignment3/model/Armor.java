package se.lexicon.daniel.ArenaFighter_Assignment3.model;

import java.util.UUID;

public class Armor {
	private String weaponId;
	private String weaponName;
	private String weaponDescription;
	private String weaponDamage;

	public Armor(String weaponName) {
		this.weaponName = weaponName;
		this.weaponId = UUID.randomUUID().toString();
	}

	public String getArmorName() {
		return weaponName;
	}

	public void setArmorName(String weaponName) {
		this.weaponName = weaponName;
	}

	public String getArmorId() {
		return weaponId;
	}

	public String getArmorDescription() {
		return weaponDescription;
	}

	public void setArmorDescription(String weaponDescription) {
		this.weaponDescription = weaponDescription;
	}

	public String getArmorDamageReduction() {
		return weaponDamage;
	}

	public void setArmorDamageReduction(String weaponDamage) {
		this.weaponDamage = weaponDamage;
	}
}
