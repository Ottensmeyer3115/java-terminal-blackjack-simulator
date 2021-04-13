# java-terminal-blackjack-simulator
Java program that simulates a single player card game of BlackJack, between the user and computer.

# Design
Each class was designed with High Cohesion and Low Coupling in mind. I made the purpose of each of my classes very specific and created them to have low dependencies.  This
application is thouroughly protected with exception handling and some Junit test cases.

BlackJackDriver
- This class contains the main method which retrieves and runs the GameImpl.  
- This is also where most of the exceptions are handled.

GameImpl
  - This class orchestrates and runs the game of Black Jack. Also contains a method that gives the user the option to either play again or quit.  Or the game will automatically end if the player runs out of money.  The player starts off with the amount of $1000.  A game is orchestrated with simple print line statements and data
is collected from the user to orchestrate the flow of the game.  It runs as follows:
  1) Player is prompted to enter their name.  The user would type their name
  2) That player is then asked if they would like to start a new game.  The user would
     type Yes or No.
  3) The player is asked how much they would like to bet out of a starting value of 
    $1000.  They input a positive number value between 1 - 1000.  If a negative number     or a number greater than their current value is placed.  An exception is thrown.
  4) The game then starts. The player will be shown their current hand and will also        see one card of the dealers current hand.  They are then prompted if they would        like to bust or stay.  The user then types "Bust" or "Stay".  This step is repeated until the dealer and/or player bust or until a both players decide to stay.
  5) When the player and dealer are finished drawing cards.  A winner is presented. The player is then presented with the amount of money they won or lost.
  6) The player is then prompted if they would like to start of new game.  If they type "Yes" then steps 3 - 5 are repeated.  If they type "No" then the program ends.

Player
- This class that represents a specific player's current hand. This class knows how to add cards, retrieve the sum of the cards in a player's hand, print out the the cards in a players hand, and reset a player's hand.

Card
- Each Card is constructed with a Face and a Suit
- Represents an individual card that has a name with an associated integer value.

Face (Enum)
- Faces represent the value associated with each card.
- Faces have the following values
  * Ace = 1 
  * Two = 2 
  * Three = 3 
  * Four = 4
  * Five = 5
  * Six = 6
  * Seven = 7
  * Eight = 8
  * Nine = 9
  * Ten, Jack, Queen, King = 10

Suit (Enum)
- Suits represent the suit associated with each card.
- Each suit has a String value associated with it.  They are
  Hearts, Diamonds, Spades, and Clubs

DeckOfCards
- Represents a standard deck of 52 cards. This class can shuffle, deal, and get the deck of cards.


