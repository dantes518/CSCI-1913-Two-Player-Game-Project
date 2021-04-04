/*
 * Project 2
 * Class: CSCI 1913, Spring 2021, Section 10
 * Professor: Jerald Thomas
 * Student: Dante Schroeder (schr1684)
 */

public abstract class TwoPlayerGame
{
    protected int currentPlayer = 1;
    protected int winningPlayer = 0;
    public String instructions;
    //I decided to change everything but the getInstructions method to be abstract.
    //The getInstructions method was simple enough and was the same implementation for each subclass, so I did not change it to be abstract.
    //Every other method was changed to be abstract, because each of them have a distinct proper implementation for each subclass.

    /**
     * Constructor for a two player game object
     */
    public TwoPlayerGame()
    {
    }

    /**
     * Returns the instructions on how to play the game that was selected by the user
     *
     * @return instructions for selected game
     */
    public String getInstructions()
    {
        return instructions;
    }

    /**
     * Returns true if the selected game has been won by a player, and false if not
     *
     * @return true if game is won, false if not
     */
    public abstract boolean isGameWon();

    /**
     * Returns true if the selected game resulted in a tie, and false if not
     *
     * @return true if game is tied, false if not
     */
    public abstract boolean isGameTied();

    /**
     * Returns a string that is manipulated to print as a visual representation of the game so the next player
     * can see the board after the previous player's turn
     *
     * @return the game board after last turn
     */
    public abstract String getCurrentGameState();

    /**
     * Returns a string that tells the correct player to take their turn and what they must input
     *
     * @return a string that tells correct player to take their turn
     */
    public abstract String getCurrentPlayerPrompt();

    /**
     * Takes in the player's input, validates it, and allows the program to interpret it for gameplay
     *
     * @param input
     */
    public abstract void processCurrentPlayerInput(String input);

    /**
     * Returns the integer value (1 or 2) of the winning player of the game
     *
     * @return winning player
     */
    public abstract int getWinningPlayer();
}
