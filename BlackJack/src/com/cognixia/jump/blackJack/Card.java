package com.cognixia.jump.blackJack;

public class Card {

	private Face face; 
	private Suit suit; 
	int total = 0;

	
	public Card(Face face, Suit suit) { // Constructor which initializes card's face and suit
		this.face = face;
		this.suit = suit;
	}

	public int getFace() {
		return face.getFaceValue();
	}

	public String getSuit() {
		return suit.PrintSuitText();
	}

	public String toString() { // return String representation of Card
		return String.format(" %s.%s", suit, face);
	}


}