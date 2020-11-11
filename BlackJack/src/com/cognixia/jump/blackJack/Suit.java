package com.cognixia.jump.blackJack;

public enum Suit {

	HEARTS(" Hearts"), DIAMONDS(" Diamonds"), SPADES(" Spades"), CLUBS(" Clubs");

	private final String suitText;

	private Suit(String suitText) {
		this.suitText = suitText;
	}

	public String PrintSuitText() {
		return suitText;
	}
}