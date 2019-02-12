package se.lexicon.daniel.ArenaFighter_Assignment3.model;

import java.util.UUID;

public class Armor {
	private String armorId;
	private String armorName;
	private String armorDescription;
	private int armorDamageReduction;

	public Armor(String armorName, String armorDescription, int armorDamageReduction) {
		this.armorId = UUID.randomUUID().toString();
		this.armorName = armorName;
		this.armorDescription = armorDescription;
		this.armorDamageReduction = armorDamageReduction;
	}

	public String getArmorName() {
		return armorName;
	}

	public void setArmorName(String armorName) {
		this.armorName = armorName;
	}

	public String getArmorId() {
		return armorId;
	}

	public String getArmorDescription() {
		return armorDescription;
	}

	public void setArmorDescription(String armorDescription) {
		this.armorDescription = armorDescription;
	}

	public int getArmorDamageReduction() {
		return armorDamageReduction;
	}

	public void setArmorDamageReduction(int armorDamageReduction) {
		this.armorDamageReduction = armorDamageReduction;
	}

	@Override
	public String toString() {
		return "Armor [armorId=" + armorId + ", armorName=" + armorName + ", armorDescription=" + armorDescription
				+ ", armorDamageReduction=" + armorDamageReduction + "]";
	}
}
