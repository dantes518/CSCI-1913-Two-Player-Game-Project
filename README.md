# Project 2

## Overview
For this project you will create an application that will allow the user to play any one of three two-player games. You will implement another version of tic-tac-toe, a number guessing game, and a third game of your choice. The purpose of this project is two-fold. First is to practice and demonstrate your knowledge regarding object oriented programming priciples, specifically inheritance and polymorphism. Second is to give you practice devloping code for an existing framework, which is something that you will find yourself having to do surprisingly often.

## Instructions
For this project I have defined a specific way that your program will be used. This is reflected in the main file, ```Project2.java```, which is complete and you are **not** allowed to edit it. You must construct the rest of your code in such a way that it works with the code in ```Project2.java```.

Each of your games will be implemented in a class that extends the ```TwoPlayerGame``` class. This class defines several fields and methods that you will use or override in the sub-classes. You will create three sub-classes that extend ```TwoPlayerGame```: ```TicTacToe```, ```GuessingGame```, and ```OtherGame```. You will also have to modify the ```TwoPlayerGame``` class so that it is an abstract class.

If a player ever enters invalid input (such as the number 11 in TicTacToe, or the letter a for the guessing game), simply print an error message and reprint the prompt for that user.

### Implementation
The following is the order of steps that I recommend. More details for some of the steps will follow.

1) Study the ```Project2.java``` file. Before you do any coding you should understand how the classes that you create will be used.
1) Add javadoc comments to all of the methods in ```TwoPlayerGame```. This will help you to understand what each of the methods do before you use them in your game classes. As these methods have no real implementation, you will need to study the ```Project2.java``` code to get an understanding of what they are supposed to do.
1) Create the ```TicTacToe```, ```GuessingGame```, and ```OtherGame``` classes. You will not need to implement the game logic yet, but until you create the classes you will run into compiler errors.
1) Convert ```TwoPlayerGame``` to an abstract class. This will require deciding which of the methods should be abstract. If you are starting on this project early, as in before we go over abstract classes in lecture (good for you!), then you can temporarily skip this step.
1) Complete and test the TicTacToe class. You have already implemented the TicTacToe game a couple of times, so you should have a good idea of how to implement the logic. Now you just need to get it to work within the confines defined by this project.
1) Complete and test the GuessingGame class.
1) Complete and test the OtherGame class.

### TwoPlayerGame
The ```TwoPlayerGame``` class provides the fields and methods required for your sub-classes to work. As this class will never be instantiated (only its sub-classes will), it really should be an abstract class. You must convert it to an abstract class, and at least one of the methods must be abstract. In reality, more than one method should be abstract, it will be up to you to determine which methods should or should not be abstract. Recall that if a method does not need to be implemented in the abstract class, it is a good candidate for being an abstract method.

### TicTacToe
You have implemented logic for the tic-tac-toe game twice already, so you should have a firm grasp of how the game works. The difference here is that you will need to modify the logic so that it works within the parameters defined by this project.

The first couple of moves in my solutions looks like this:
```
Choose a two player game to play by entering the corresponding number.
  1) TicTacToe
  2) Guessing Game
  3) Other Game

Your choice: 
1
Instructions:
The starting player places an 'x' in one of the locations on the grid.
The second player then places a 'o' on one of the grid locations, but
not one that was previously chosen. This continues until either all the
grid locations have been filled, or until a player wins. A player wins
by placing their "pieces" in three grid locations that either share
the same row, column, or diagonal.

1|2|3
-+-+-
4|5|6
-+-+-
7|8|9

Player 1 (x) choose your location: 
1
x|2|3
-+-+-
4|5|6
-+-+-
7|8|9

Player 2 (o) choose your location: 
2
x|o|3
-+-+-
4|5|6
-+-+-
7|8|9
```

### GuessingGame
This game will be an extension of the random number game that we created in class (lecture 19). The game will secretly select a random integer between 1 and 100 (inclusive). In the random number game, the user would guess a number and the program would respond with whether the secret number was higher or lower than the guessed number. In the two player version that you will implement, each player will make a guess, and then the program will respond with which player was closest to the secret number (if they are equally far away it will respond saying that both player 1 and player 2 are equally far away). This will go on until one (or both in the case of a tie) of the players guess the secret number.

This guessing game will actually pose some issues with the format prescribed by this project. This is intentional, it is good practice to figure out how to get something to work in a framework that it was not designed for. It would be a good idea to think about how you _could_ change ```Project2.java``` to make it work better with both tic-tac-toe and the guessing game.

The first couple of moves in my solutions looks like this:
```
Choose a two player game to play by entering the corresponding number.
  1) TicTacToe
  2) Guessing Game
  3) Other Game

Your choice: 
2
Instructions:
When the game starts the computer will generate a random number between 1
and 100 (including both 1 and 100). The game will prompt each player for a
a guess. Once both players have submitted a valid guess, the game will tell
you which player is closer to the secret number. Once a player has guessed
the secret number, they win and the game is over. If both players correctly
guess the secret number, the game will end in a tie.


Player 1, make your guess: 
1

Player 2, make your guess: 
100

Player 1 is closer.

Player 1, make your guess: 
15

Player 2, make your guess: 
17

Player 1 and 2 are equally far way.
```

### OtherGame
This game will be one of your choosing. You can implement an existing two player game (a few examples would be hangman, connect 4, and mancala) or make one of your own up. Make sure that the instructions that you provide are clear so that the graders know what the win and tie conditions should be. The name of the class should **not** be changed.

## Requirements
* The ```TicTacToe```, ```GuessingGame```, and ```OtherGame``` classes must be implemented in such a way as to produce a playable game without editing ```Project2.java```.
* When a user selects a game option, the program should:
   - Print the game instructions (the game instructions must manually wrap, meaning you must manually add newline characters so that each line is no more than 80 characters).
   - Alternate game play between player 1 and player 2, each time providing a prompt for the current player and then processing their input.
   - Correctly detect a win condition or a tie condition, print the appropriate message, and exit.
* ```TwoPlayerGame``` must be converted to an abstract class.

## Documentation Requirements
* All comments at the start of the Java files must be edited to have your name and your x500.
* Each method in the ```TwoPlayerGame```, ```TicTacToe```, ```GuessingGame```, and ```OtherGame``` classes must have javadoc comments that describe the purpose of the function and make use of the ```@param``` and ```@return``` tags when applicable.
* All code must have comments that describe the logical steps. This does not need to be line by line, but rather logical chunk by logical chunk.

## Rubric
Here I am laying out how points will be divided amongst the various components of the project. Each component has a max number of points, as well as the ways that points can be deducted. Note that you can not receive negative points for any of the components.
 
#### Documentation (10 points)
* 2 points: All comments at the start of the Java files have been edited to have your name and your x500.
  - -1 point if some, but not all comments have been edited
  - -2 points if no comments have been edited 
* 4 points: All methods have a javadoc that describes the method's purpose, its parameters (using the ```@param``` tag), and what it returns (using the ```@return``` tag).
  - -2 point if most, but not all of the functions have a sufficient javadoc
  - -3 points if some of the functions have sufficient javadocs
  - -4 points if none of the functions have sufficient javadocs
* 4 points: All code must have comments that describe the logical steps.
  - -2 point if most of the code is well commented
  - -3 points if some of the code is well commented
  - -4 points if none of the code is commented

#### Functionality (45 points)
* 15 points: ```TicTacToe``` works as described in the "Instructions" section.
  - -2 points if the ```getInstructions``` method does not return the game's instructions
    * -1 point if the instructions do not wrap before 80 characters
  - -1 point if the ```isGameWon``` method does not successfully return the correct boolean value and only a minor fix is required
    * -2 points if a major fix is required
  - -1 point if the ```isGameTied``` method does not successfully return the correct boolean value and only a minor fix is required
    * -2 points if a major fix is required
  - -1 point if the ```getCurrentGameState``` method does not successfully return a String representation of the game state and only a minor fix is required
    * -2 points if a major fix is required
  - -1 point if the ```getCurrentPlayerPrompt``` method does not successfully return a String that prompts the current player's next move and only a minor fix is required
    * -2 points if a major fix is required
  - -1 point if the ```getProcessCurrentPlayerInput``` method does not successfully update the game state with the input provided as a parameter and only a minor fix is required
    * -2 points if a major fix is required
  - -1 point if the class does not contain the static String name field
  - -1 point if the class does not update the inherited currentPlayer field every game turn
  - -1 point if the class does not update the inherited winningPlayer field if a player has won
* 15 points: ```GuessingGame``` works as described in the "Instructions" section.
  - -2 points if the ```getInstructions``` method does not return the game's instructions
    * -1 point if the instructions do not wrap before 80 characters
  - -1 point if the ```isGameWon``` method does not successfully return the correct boolean value and only a minor fix is required
    * -2 points if a major fix is required
  - -1 point if the ```isGameTied``` method does not successfully return the correct boolean value and only a minor fix is required
    * -2 points if a major fix is required
  - -1 point if the ```getCurrentGameState``` method does not successfully return a String representation of the game state and only a minor fix is required
    * -2 points if a major fix is required
  - -1 point if the ```getCurrentPlayerPrompt``` method does not successfully return a String that prompts the current player's next move and only a minor fix is required
    * -2 points if a major fix is required
  - -1 point if the ```getProcessCurrentPlayerInput``` method does not successfully update the game state with the input provided as a parameter and only a minor fix is required
    * -2 points if a major fix is required
  - -1 point if the class does not contain the static String name field
  - -1 point if the class does not update the inherited currentPlayer field every game turn
  - -1 point if the class does not update the inherited winningPlayer field if a player has won
* 15 points: ```OtherGame``` works as described in the "Instructions" section.
  - -2 points if the ```getInstructions``` method does not return the game's instructions
    * -1 point if the instructions do not wrap before 80 characters
  - -1 point if the ```isGameWon``` method does not successfully return the correct boolean value and only a minor fix is required
    * -2 points if a major fix is required
  - -1 point if the ```isGameTied``` method does not successfully return the correct boolean value and only a minor fix is required
    * -2 points if a major fix is required
  - -1 point if the ```getCurrentGameState``` method does not successfully return a String representation of the game state and only a minor fix is required
    * -2 points if a major fix is required
  - -1 point if the ```getCurrentPlayerPrompt``` method does not successfully return a String that prompts the current player's next move and only a minor fix is required
    * -2 points if a major fix is required
  - -1 point if the ```getProcessCurrentPlayerInput``` method does not successfully update the game state with the input provided as a parameter and only a minor fix is required
    * -2 points if a major fix is required
  - -1 point if the class does not contain the static String name field
  - -1 point if the class does not update the inherited currentPlayer field every game turn
  - -1 point if the class does not update the inherited winningPlayer field if a player has won
  

