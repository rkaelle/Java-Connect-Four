# Connect Four Game
This is a Connect Four game where a player plays against a computer. The game is implemented using Java.

## Getting Started
These instructions will help you to run the game on your local machine.

### Prerequisites
You will need to have Java installed on your local machine.

### Running the game
1. Clone the repository to your local machine
```
https://github.com/rkalesalad/Java-Connect-Four
```
2. Navigate to the ConnectFourGame directory
```
cd ConnectFourGame
```
3. Compile the game
```
javac ConnectFourGame.java
```
4. Run the game
```
java ConnectFourGame
```

## Game Rules
- The game board is 8 columns and 6 rows
- Players take turns placing their pieces (X for player, O for computer) in a column
- The game ends when one player gets four of their pieces in a row (horizontally, vertically or diagonally)
- If the board is full and no one has won, the game ends in a draw

## Game Implementation
The game is implemented using the following classes:
- ConnectFourGame: The main class that runs the game. It creates the board and handles the gameplay.
- ConnectFourRules: An interface that defines the rules of the game.
- Board: A class that represents the game board and handles the placing of pieces.

The game includes a simple AI for the computer player that plays randomly but is able to block the player's win by placing its piece in the right column.

## Conclusion
This is a simple implementation of the Connect Four game that can be used as a starting point for more advanced versions of the game. The code can be easily modified to include more advanced AI or different game rules
