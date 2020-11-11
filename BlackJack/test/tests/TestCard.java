package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import com.cognixia.jump.blackJack.Face;
import com.cognixia.jump.blackJack.Suit;
import com.cognixia.jump.blackJack.Card;

class TestCard {
	private Face face; 
	private Suit suit; 
	int total = 0;
	

	@Test
	public void testGetFace() {
		Card card = new Card(Face.EIGHT, Suit.CLUBS);
		assertEquals(card.getFace(), 8);
	}
	
	@Test
	public void testGetSuit() {
		Card card = new Card(Face.EIGHT, Suit.CLUBS);
		assertEquals(" Clubs", card.getSuit());
	}
	
	@Test
	public void testToString() {
		Card card = new Card(Face.EIGHT, Suit.CLUBS);
		String cardString = card.toString();
		String testString = " CLUBS.EIGHT";
		assertEquals(cardString, testString);
	}

}
