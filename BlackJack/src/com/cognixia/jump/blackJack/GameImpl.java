package com.cognixia.jump.blackJack;

import java.util.NoSuchElementException;
import java.util.Scanner;


public class GameImpl {

	private static GameImpl game = null;
	private Scanner input = new Scanner(System.in);
	private static String playerName;
	private boolean gameOver = false;
	private boolean stay = false;
	private static int playerMoney = 1000;
	
	// This constructor is only used to test 'extractNumber()'
	public GameImpl(String playerName) {
		playerName = "alpha";
	}
	
	// This is the actual constructor we will use
	private GameImpl() {
		boolean playGame = true;
		int bet;
		
		System.out.println("What is your name?");
		String pAnswer = input.nextLine();
		String name = pAnswer;
		
		while (playGame) {
			System.out.println("Would you like to start a new game?  'Yes/No' :");
			pAnswer = input.nextLine();
			int userBet;
			if (pAnswer.equalsIgnoreCase("Yes") && playerMoney > 0) {
				
				// Betting Handled here
				System.out.println("How much would you like to bet?");
				pAnswer = input.nextLine();
				if(!(pAnswer.matches(".*\\d.*"))) {
					throw new UnsupportedOperationException();
				}
				bet = extractNumber(pAnswer);
				
				// Initialize player and dealer
				Player me = new Player(name);
				Player dealer = new Player("dealer");
				
				
				if(bet > playerMoney) {
					System.out.println("You can't bet what you don't have");
					throw new UnsupportedOperationException();
				} else {
					
					DeckOfCards deck1 = new DeckOfCards();
					deck1.shuffleDeck();
					me.addCard(deck1.dealNextCard());
					me.addCard(deck1.dealNextCard());
					me.getPlayerHand(true);
					System.out.println(" ");
					dealer.addCard(deck1.dealNextCard());
					dealer.addCard(deck1.dealNextCard());
					dealer.getPlayerHand(false);
					
					playerTurn(deck1, me, bet);
					
					dealersTurn(deck1, me, dealer, bet, gameOver);
					
				}
			}
			else if(playerMoney <= 0) {
				System.out.println("You're broke and can't play anymore");
				System.out.println("Better luck next time");
				System.exit(0);
			}
			else {
				System.out.println("Okay Bye!");
				playGame = false;
			}
		}
	}
	
	public static GameImpl getGame() {
		if(game == null) {
			game = new GameImpl();
		}
		return game;
	}
	
	public void playerTurn(DeckOfCards deck, Player me, int bet) throws NoSuchElementException {
		String pAnswer;
		gameOver = false;
		do {
			System.out.println("Would " + me.getName() + " like to bust or stay? 'Bust/Stay'");
			pAnswer = input.nextLine();
			// BUST
			if (pAnswer.equalsIgnoreCase("Bust")) {
				me.addCard(deck.dealNextCard());
				System.out.println(me.getHandSum());
				if (me.getHandSum() > 21) {
					System.out.println(
							"You busted and got a total of " + me.getHandSum() + ". Dealer wins this time! ");
					playerMoney -= bet;
					System.out.println("You have lost $" + bet + ", putting your total money at " + playerMoney);
					gameOver = true;
					
				} else if (me.getHandSum() == 21) {
					System.out.println("Blackjack! You won!");
					playerMoney += bet;
					System.out.println("You have won $" + bet + ", putting your total money at " + playerMoney);
					gameOver = true;
					
				}
			}
			// STAY
			if (pAnswer.equalsIgnoreCase("stay")) {
				System.out.println("You have chosen to stay. Your hand: " + me.getHandSum());
			}

		} while (pAnswer.equalsIgnoreCase("Bust") && gameOver == false);
		stay = false;
	}
	
	public void dealersTurn(DeckOfCards deck, Player me, Player dealer, int bet, boolean gameOver) {
		if(!(gameOver)) {
			do {
				System.out.println("");
				System.out.println("- Dealers turn -");
				// DRAW CARD
				if (dealer.getHandSum() <= 17 && !(gameOver)) {
					dealer.addCard(deck.dealNextCard());
					System.out.println("Dealer has chosen to take a card");
					if (dealer.getHandSum() == 21) {
						System.out.println("Blackjack! Dealer won.");
						gameOver = true;
						playerMoney -= bet;
						System.out.println("You have lost $" + bet + ", putting your total money at " + playerMoney);
					} else if (dealer.getHandSum() > 21) {
						
						System.out.println("Dealer busted and got a total of " + dealer.getHandSum() + ". "
								+ me.getName() + " wins this time!");
						gameOver = true;
						playerMoney += bet;
						System.out.println("You have won $" + bet + ", putting your total money at " + playerMoney);
	
					} 
					else {
						gameOver = false;
						stay = false;
					}
				} else  {
						
						System.out.println("Dealer has chosen to stay!");
						int totalDealerSum = dealer.getHandSum();
						int totalPlayerSum = me.getHandSum();
	
						if (totalDealerSum > totalPlayerSum) {
							System.out.println("Both players has decided to stay. The winner is " + dealer.getName()
									+ " with a total of " + totalDealerSum + ".");
							gameOver = true;
							playerMoney -= bet;
							System.out.println("You have lost $" + bet + ", putting your total money at " + playerMoney);
							
						} else {
							System.out.println("Both players has decided to stay. The winner is " + me.getName()
									+ " with a total of " + totalPlayerSum + ".");
							gameOver = true;
							playerMoney += bet;
							System.out.println("You have won $" + bet + ", putting your total money at " + playerMoney);
	
						}
						stay = true;	
					}
	
			} while (!(stay) && !(gameOver));
		}
	}
	
	public int extractNumber(String str) {
		int number = 0;
		if(str == null || str.isEmpty()) {
			 return number;
		 }
		 number = Integer.parseInt(str);
		 return number; 
	}
	
	
	
	
}
