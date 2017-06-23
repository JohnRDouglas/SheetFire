package com.code_monkee.SheetFire.entities;

import java.util.List;

public class Character {

	String name;
	Integer str;
	Integer agi;
	Integer end;
	Integer chr;
	Integer wis;
	Integer intl;
	
	List<Skill> skills;
	List<Weapon> weapons;
	List<Armor> armor;
	
	
	public Character() {
		
	}
	
	public Character(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getStr() {
		return str;
	}

	public void setStr(Integer str) {
		this.str = str;
	}

	public Integer getAgi() {
		return agi;
	}

	public void setAgi(Integer agi) {
		this.agi = agi;
	}

	public Integer getEnd() {
		return end;
	}

	public void setEnd(Integer end) {
		this.end = end;
	}

	public Integer getChr() {
		return chr;
	}

	public void setChr(Integer chr) {
		this.chr = chr;
	}

	public Integer getWis() {
		return wis;
	}

	public void setWis(Integer wis) {
		this.wis = wis;
	}

	public Integer getIntl() {
		return intl;
	}

	public void setIntl(Integer intl) {
		this.intl = intl;
	}

	public List<Skill> getSkills() {
		return skills;
	}

	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}

	public List<Weapon> getWeapons() {
		return weapons;
	}

	public void setWeapons(List<Weapon> weapons) {
		this.weapons = weapons;
	}

	public List<Armor> getArmor() {
		return armor;
	}

	public void setArmor(List<Armor> armor) {
		this.armor = armor;
	}
}

