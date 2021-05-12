package com.deusnex.campsite;

public class ArrivalCheck {

	private String name;
	
	private String type;
	
	private int pitch;
	
	private int noOfNights;
	
	private int fee;
	
	private char paid;
	
	public ArrivalCheck() {
		
	}

	public ArrivalCheck(String name, String type, int pitch, int noOfNights, int fee, char paid) {
		this.name = name;
		this.type = type;
		this.pitch = pitch;
		this.noOfNights = noOfNights;
		this.fee = fee;
		this.paid = paid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getPitch() {
		return pitch;
	}

	public void setPitch(int pitch) {
		this.pitch = pitch;
	}

	public int getNoOfNights() {
		return noOfNights;
	}

	public void setNoOfNights(int noOfNights) {
		this.noOfNights = noOfNights;
	}

	public int getFee() {
		return fee;
	}

	public void setFee(int fee) {
		this.fee = fee;
	}

	public char getPaid() {
		return paid;
	}

	public void setPaid(char paid) {
		this.paid = paid;
	}

	@Override
	public String toString() {
		return "ArrivalCheck [name=" + name + ", type=" + type + ", pitch=" + pitch + ", noOfNights=" + noOfNights
				+ ", fee=" + fee + ", paid=" + paid + "]";
	}
	
	
}
