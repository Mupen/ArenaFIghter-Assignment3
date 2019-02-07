package se.lexicon.daniel.ArenaFighter_Assignment3.model;

import java.util.UUID;

public class Weapon {
	private String weaponId;
	private String weaponName;
	private String weaponDescription;
	private String weaponDamage;
	
	public Weapon(String weaponName) {
		this.weaponName = weaponName;
		this.weaponId = UUID.randomUUID().toString();
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

	public String getWeaponDamage() {
		return weaponDamage;
	}

	public void setWeaponDamage(String weaponDamage) {
		this.weaponDamage = weaponDamage;
	}

	@Override
	public String toString() {
		return new StringBuilder(getWeaponName()).toString();
	}
}
