/*
 * Project 2
 * Class: CSCI 1913, Spring 2021, Section 10
 * Professor: Jerald Thomas
 * Student: Dante Schroeder (schr1684)
 */

import java.util.Scanner;

public class Project2
{
    public static void main(String[] args){
        // Needed variables
        TwoPlayerGame game = null;
        int choice;
        Scanner scanner = new Scanner(System.in);

        // Prompt user to choose which game to play
        System.out.println("Choose a two player game to play by entering the corresponding number.");
        System.out.println("  1) " + TicTacToe.name);
        System.out.println("  2) " + GuessingGame.name);
        System.out.println("  3) " + OtherGame.name);
        System.out.println();
        System.out.println("Your choice: ");

        // Get choice and make sure that it is a valid integer
        try
        {
            choice = scanner.nextInt();
            scanner.nextLine();
        }
        catch(Exception e)
        {
            // Print error and exit
            System.out.println("Error: Expected an integer");
            return;
        }

        // Populate the game object depending on the user's choice
        switch(choice)
        {
            case 1:
                game = new TicTacToe();
                break;
            case 2:
                game = new GuessingGame();
                break;
            case 3:
                game = new OtherGame();
                break;
            default:
                // Print error and exit
                System.out.println("Error: Expected a number between 1 and 3");
                return;
        }

        // Print the game instructions
        System.out.println("Instructions:");
        System.out.println(game.getInstructions());
        System.out.println();


        // Play the game
        while (!game.isGameWon() && !game.isGameTied())
        {
            // Print current game state
            System.out.println(game.getCurrentGameState());

            // Print current player prompt
            System.out.println(game.getCurrentPlayerPrompt());

            // Process user input
            String input  = scanner.nextLine();
            game.processCurrentPlayerInput(input);
        }

        // Print final game state
        System.out.println(game.getCurrentGameState());

        // Print the won/tied message
        if (game.isGameWon())
        {
            System.out.println("Congratulations Player " + game.getWinningPlayer() + ", you won!");
        }
        else if(game.isGameTied())
        {
            System.out.println("The game ended in a tie!");
        }
    }
}
