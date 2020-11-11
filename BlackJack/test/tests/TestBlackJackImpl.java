package tests;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;
import java.util.Scanner;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import com.cognixia.jump.blackJack.GameImpl;
import com.cognixia.jump.blackJack.DeckOfCards;
import com.cognixia.jump.blackJack.Face;
import com.cognixia.jump.blackJack.Card;
import com.cognixia.jump.blackJack.Player;
import com.cognixia.jump.blackJack.Suit;

class TestBlackJackImpl {

	private static int playerMoney = 1000;
	private static String playerName;
	private boolean gameOver = false;
	private boolean stay = false;
	private boolean playGame = true;
	GameImpl game;
	
	@Before
	void setUp() throws Exception {
		GameImpl game = null;
		Scanner input = new Scanner(System.in);
		
	}

	
	@Test
	public void testGetGame() {
		GameImpl game = null;
		assertEquals(game, null);
		game = new GameImpl("alpha");
		GameImpl game2 = GameImpl.getGame();
		assertNotEquals(game, game2);
	}
	
	
	@Test
	public void testPlayerTurn() {
		
		int playerMoney = 1000;
		int bet = 1001;
		// What is your name?
		String pAnswer = "Jake";
		String name = pAnswer;
		Player me = new Player(name);
		DeckOfCards deck1 = new DeckOfCards();
		deck1.shuffleDeck();
		assertNotEquals(deck1, 52);
		me.addCard(deck1.dealNextCard());
		me.addCard(deck1.dealNextCard());
		int testHandSum = me.getHandSum();
		assertNotEquals(testHandSum, 0);
		assertEquals(testHandSum, me.getHandSum());
		
	}
	
	@Test
	public void testExtractNumber() {
		String number = "11";
		game = new GameImpl("alpha");
		int answer = game.extractNumber(number);
		assertEquals(answer, 11);
	}
}
