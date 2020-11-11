package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import com.cognixia.jump.blackJack.Suit;
import com.cognixia.jump.blackJack.Face;
import com.cognixia.jump.blackJack.Card;
import com.cognixia.jump.blackJack.Player;

class TestPlayer {
	String name = "name";
	int playerNumOfCards;
	ArrayList<Card> playerHand;
	Player player = new Player("Steve");
	
	@Test
	public void testConstructor() {
		Player player2 = new Player("Dan");
		assertNotNull(player);
		assertNotEquals(player, player2);
	}
	
	@Test
	public void testGetName() {
		assertEquals(player.getName(), "Steve");
	}
	
	@Test
	public void testPlayersHand() {
		Card card = new Card(Face.EIGHT, Suit.CLUBS);
		player.addCard(card);
		assertNotEquals(player.getHandSum(), 0);
		assertEquals(player.getHandSum(), 8);
		Card card2 = new Card(Face.KING, Suit.CLUBS);
		player.addCard(card2);
		assertNotEquals(player.getHandSum(), 0);
		assertNotEquals(player.getHandSum(), 8);
		assertEquals(player.getHandSum(), 18);
		player.resetPlayerHand();
		try {
			assertNotEquals(player.getHandSum(), 0);
		} catch(NullPointerException e) {
			String exc = e.toString();
			assertEquals(exc, "java.lang.NullPointerException");
		}
	}

}
