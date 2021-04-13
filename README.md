# java-terminal-blackjack-simulator
Java program that simulates a single player card game of BlackJack, between the user and computer.

# Design
Each class was designed with High Cohesion and Low Coupling in mind. I made the purpose of each of my classes very specific and created them to have low dependencies.

BlackJackImpl
  - This class orchestrates and runs the game of Black Jack. Also contains a method that gives the user the option to either play again or quit.  Or the game will automatically end if the player runs out of money.  The player starts off with the amount of $1000.

Card
- Represents an individual card, that has an integer value.
- Cards can have the value of 1, 2, 3, 4, 5, 6, 7, 8, 9, 10
- Aces have a value of either 1 or 11
- Jack, King, and Queens are represented by a value of 10 (This means you are three times as more likely to draw a '10' than any other card)

DeckOfCards
- Represents a standard deck of 52 cards. This class can shuffle, deal, and display the initial draw for each player.


