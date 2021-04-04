/*
 * Project 2
 * Class: CSCI 1913, Spring 2021, Section 10
 * Professor: Jerald Thomas
 * Student: Dante Schroeder (schr1684)
 */

import java.lang.Math;

public class GuessingGame extends TwoPlayerGame{

    //I needed a lot of variables for this game, but only some are used more than once or twice.
    static String name = "GuessingGame";
    public double randomNumDouble;
    public int randomNum;
    public int[] guesses;
    public int turns;
    public boolean tie;
    /**
     * Constructor for a GuessingGame object
     */
    public GuessingGame(){
        //Grabs values from super class (TwoPlayerGame), sets instructions properly.
        super();
        instructions = "When the game starts the computer will generate a random number between 1\n" +
                "and 100 (including both 1 and 100). The game will prompt each player for a\n" +
                "a guess. Once both players have submitted a valid guess, the game will tell\n" +
                "you which player is closer to the secret number. Once a player has guessed\n" +
                "the secret number, they win and the game is over. If both players correctly\n" +
                "guess the secret number, the game will end in a tie.";
        //randomNumDouble is only used because Math.random produces a double, so I needed to convert it to an integer.
        randomNumDouble = Math.random() * 100;
        randomNum = (int)randomNumDouble;
        //I used an array to store the guesses, kind of like the weapons in rock paper scissors.
        //I also needed a turns and tie variable for very specific cases.
        guesses = new int[]{0, 0};
        turns = 0;
        tie = false;
    }

    /**
     * Returns true if the selected game has been won by a player, and false if not
     *
     * @return true if game is won, false if not
     */
    public boolean isGameWon(){
        //Checks if player 1 is the winning player, else if player 2 is the winning player, or if no one has one.
        if(currentPlayer == 1){
            if(guesses[0] == randomNum){
                winningPlayer = 1;
                //If both players guess the right number on the same turn, tie becomes true.
                if(guesses[1] == randomNum){
                    tie = true;
                }
                //Allows player 1 to win on their own.
                if(!tie){
                    return true;
                }
                return false;
            //Player 2 wins and player 1 does not. There cannot be a tie in this case, so that if statement is not needed.
            }else if(guesses[1] == randomNum){
                winningPlayer = 2;
                return true;
            }
        }
        return false;
    }

    /**
     * Returns true if the selected game has tied, and false if not
     *
     * @return true if game is tied, false if not
     */
    public boolean isGameTied(){
        //Takes the tie variable from isGameWon and uses it to determine if the game is tied.
        if(tie){
            return true;
        }
        return false;
    }

    /**
     * Returns a string that is formatted to show the current state of the game after a turn has been taken
     *
     * @return string for visual representation of game
     */
    public String getCurrentGameState(){
        //Checks if the game is over or not.
        if(!isGameWon()) {
            //Checks if it's player 1's turn, this is used to ensure both players get a turn at the same time.
            if(currentPlayer == 1){
                //All of these if statements use the absolute value function from the Math class to determine the distance from the random number.
                //This method will return whichever player is closer to the random number, or will say if they are equally far from the number.
                if(Math.abs(guesses[0] - randomNum) < Math.abs(guesses[1] - randomNum)){
                    return "Player 1 is closer.";
                }else if(Math.abs(guesses[0] - randomNum) > Math.abs(guesses[1] - randomNum)){
                    return "Player 2 is closer.";
                //This needs to have the isGameWon and turns != 0 checks to ensure nothing extra is printed at the beginning/end of the game.
                }else if(isGameWon() && turns != 0 && Math.abs(guesses[0] - randomNum) == Math.abs(guesses[1] - randomNum)){
                    return "Player 1 and 2 are equally far apart.";
                }
            }
        }
        return "";
    }

    /**
     * Returns a string that tells the correct player to take their turn
     *
     * @return string to tell player to take turn
     */
    public String getCurrentPlayerPrompt(){
        //Checks which player's turn it is and prints out the correct prompt.
        if(currentPlayer == 1){
            return "Player 1, make your guess: ";
        }else{
            return "Player 2, make your guess: ";
        }
    }

    /**
     * Takes in an input from a player, validates it, and translates it into a form the program can read
     *
     * @param input
     */
    public void processCurrentPlayerInput(String input) {
        //Checks if the input is valid (between 1 and 100).
        if(Integer.parseInt(input) > 0 && Integer.parseInt(input) < 101){
            //If it's player 1's turn, add their guess to the array. currentPlayer++ makes it player 2's turn.
            if(currentPlayer == 1){
                guesses[0] = Integer.parseInt(input);
                currentPlayer++;
            //Same as above but for player 2. currentPlayer-- makes it player 1's turn again.
            }else if(currentPlayer == 2){
                guesses[1] = Integer.parseInt(input);
                currentPlayer--;
            }
            //I needed a turns variable to avoid printing out extra statements when they were not necessary.
            turns++;
        }
    }

    /**
     * Returns the integer value (either 1 or 2) of the winning player
     *
     * @return 1 if player 1 wins, 2 if player 2 wins
     */
    //This method just returns the winningPlayer variable, which is set in isGameWon.
    public int getWinningPlayer(){
        return winningPlayer;
    }
}
