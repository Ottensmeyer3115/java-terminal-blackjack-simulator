package com.cognixia.jump.blackJack;

import java.util.ArrayList;

public class Player {

	private String name;
	private int playerNumOfCards;
	ArrayList<Card> playerHand;

	public Player(String name) {
		this.name = name;
		playerHand = new ArrayList<Card>();

	}

	public String getName() {
		return name;
	}

	public void addCard(Card aCard) {
		playerHand.add(aCard);
		this.playerNumOfCards++;
	}

	public int getHandSum() {
		int totalSum = 0;
		for (Card countSum : playerHand) {
			totalSum += countSum.getFace();
		}
		return totalSum;
	}

	public void getPlayerHand(boolean hideCard) throws IndexOutOfBoundsException {
		System.out.println(this.name + "s current hand.");
		for (int c = 0; c < playerNumOfCards; c++) {
			if (c == 0 && !hideCard) {
				System.out.println("[Hidden card]");
			} else {
				System.out.println(playerHand.get(c).toString());
			}
		}
	}
	
	public void resetPlayerHand() {
		playerHand = null;
	}
}
