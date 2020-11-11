package com.cognixia.jump.blackJack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class DeckOfCards {

	private List<Card> cardDeck = new ArrayList<Card>();
	private Card[] deck;
	private int numberOfCards = 52; 
	int currentCard; 
	
	public DeckOfCards() {
		
		Face [] faces = {Face.ACE, Face.TWO, Face.THREE, Face.FOUR, Face.FIVE, Face.SIX,
                Face.SEVEN, Face.EIGHT, Face.NINE, Face.TEN, Face.JACK, Face.QUEEN,
                Face.KING};
		Suit[] suits = {Suit.HEARTS, Suit.SPADES, Suit.DIAMONDS, Suit.CLUBS};

		
		deck = new Card[numberOfCards];
		currentCard = 0;
		
		//Populate deck with Cards
	    for(int cardNum = 0; cardNum < deck.length; cardNum++) {
	        deck [cardNum] = new Card(faces [cardNum % 13], suits [cardNum / 13]);
	    }
	    
	    cardDeck = Arrays.asList(deck);
	    
	}
	
	public void shuffleDeck() {
		Collections.shuffle(cardDeck);
	}
	
	public void getCardDeck(){
	    int start = 1;
	    for(Card k : cardDeck) {
	        System.out.println("" + start + "/52 " + k);
	        start++;
	    }
	}
	
	public Card dealNextCard() {
		
		Card topCard = this.deck[0];
		for(int i = 1; i < numberOfCards; i++) {
			this.deck[i-1] = this.deck[i];
		}
		this.deck[numberOfCards-1] = null;
		this.numberOfCards--;
		return topCard;
	}
	

	
}
