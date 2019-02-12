package se.lexicon.daniel.ArenaFighter_Assignment3.model;

import java.util.UUID;

public class Weapon {
	private String weaponId;
	private String weaponName;
	private String weaponDescription;
	private int weaponDamage;
	
	public Weapon(String weaponName, String weaponDescription, int weaponDamage) {
		this.weaponId = UUID.randomUUID().toString();
		this.weaponName = weaponName;
		this.weaponDescription = weaponDescription;
		this.weaponDamage = weaponDamage;
	}
	
	public String getWeaponName() {
		return weaponName;
	}

	public void setWeaponName(String weaponName) {
		this.weaponName = weaponName;
	}

	public String getWeaponId() {
		return weaponId;
	}

	public String getWeaponDescription() {
		return weaponDescription;
	}

	public void setWeaponDescription(String weaponDescription) {
		this.weaponDescription = weaponDescription;
	}

	public int getWeaponDamage() {
		return weaponDamage;
	}

	public void setWeaponDamage(int weaponDamage) {
		this.weaponDamage = weaponDamage;
	}

	@Override
	public String toString() {
		return "Weapon [weaponId=" + weaponId + ", weaponName=" + weaponName + ", weaponDescription="
				+ weaponDescription + ", weaponDamage=" + weaponDamage + "]";
	}
}
