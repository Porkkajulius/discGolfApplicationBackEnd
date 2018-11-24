package com.DiscGolf.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

public class Disc {

	@JsonProperty
	int id;

	@JsonProperty
	String speed, glide, fade, turn, brand, name;

	public Disc() {
		super();

	}

	public int getId() {
		return id;
	}

	@JsonSetter
	public void setId(int id) {
		this.id = id;
	}

	public String getSpeed() {
		return speed;
	}

	@JsonSetter
	public void setSpeed(String speed) {
		this.speed = speed;
	}

	public String getGlide() {
		return glide;
	}

	@JsonSetter
	public void setGlide(String glide) {
		this.glide = glide;
	}

	public String getFade() {
		return fade;
	}

	@JsonSetter
	public void setFade(String fade) {
		this.fade = fade;
	}

	public String getTurn() {
		return turn;
	}

	@JsonSetter
	public void setTurn(String turn) {
		this.turn = turn;
	}

	public String getBrand() {
		return brand;
	}

	@JsonSetter
	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getName() {
		return name;
	}

	@JsonSetter
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Disc [id=" + id + ", speed=" + speed + ", glide=" + glide + ", turn=" + turn + ", fade=" + fade
				+ ", brand=" + brand + ", name=" + name + "]";
	}

}
