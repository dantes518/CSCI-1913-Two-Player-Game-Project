/*
 * Project 2
 * Class: CSCI 1913, Spring 2021, Section 10
 * Professor: Jerald Thomas
 * Student: Dante Schroeder (schr1684)
 */

public class OtherGame extends TwoPlayerGame{

    //Variables that were needed for the game to run properly.
    //I made one of the strings in weapon equal to "a" to start so the game wouldn't print an
    //unnecessary "This round was a tie" statement.
    static String name = "RockPaperScissors";
    public String[] weapon = {"a", ""};
    public int[] wins = {0, 0};

    /**
     * Constructor for an OtherGame object
     */
    public OtherGame(){
        //Takes the variables from the super class (TwoPlayerGame), and changes the instructions and name of the game.
        super();
        instructions = "When the game starts the computer will ask player 1 to enter their weapon.\n" +
                "A weapon is either rock, paper, or scissors. Once player 1 has entered their weapon,\n" +
                "player 2 will be asked for their weapon. In rock paper scissors, rock beats scissors,\n" +
                "scissors beat paper, and paper beats rock. Whoever wins that round will have one win\n" +
                "added to their win count, and the first player to 3 wins (also known as a best of 5)\n" +
                "will win the game. With this format, the game can never be tied.";
    }

    /**
     * Returns true if the selected game has been won by a player, and false if not
     *
     * @return true if game is won, false if not
     */
    public boolean isGameWon() {
        //I went with a best of 5 format in order to make the game more interesting, so I stored wins in an array.
        //I could have made getWinningPlayer change the winningPlayer value, but it doesn't really matter either way.
        if(wins[0] == 3){
            winningPlayer = 1;
            return true;
        }else if(wins[1] == 3){
            winningPlayer = 2;
            return true;
        }
        return false;
    }

    /**
     * Returns true if the selected game has tied, and false if not
     *
     * @return true if game is tied, false if not
     */
    public boolean isGameTied() {
        //In a best of 5 game, the whole game can never tie; therefore, this is always false.
        return false;
    }

    /**
     * Returns a string that is formatted to show the current state of the game after a turn has been taken
     *
     * @return string for visual representation of game
     */
    public String getCurrentGameState() {
        //Because I needed this method to run twice without using a loop, I used an initial check to see if currentPlayer equals 1.
        //If it does, that means that both players can put in an input before it prints anything else.
        if (currentPlayer == 1) {
            //This if statement checks if player 1 won the round.
            if (weapon[0].equals("rock") && weapon[1].equals("scissors") || weapon[0].equals("scissors") && weapon[1].equals("paper") || weapon[0].equals("paper") && weapon[1].equals("rock")) {
                //This adds a win to player 1's total and wipes the weapon array. Also reports the number of wins for each player after each round.
                wins[0]++;
                weapon[0] = "";
                weapon[1] = "";
                return "Player 1 wins this round. Player 1 wins: " + wins[0] + ", Player 2 wins: " + wins[1];
            } else if (weapon[1].equals("rock") && weapon[0].equals("scissors") || weapon[1].equals("scissors") && weapon[0].equals("paper") || weapon[1].equals("paper") && weapon[0].equals("rock")) {
                //Same as above, but for player 2 rather than player 1.
                wins[1]++;
                weapon[0] = "";
                weapon[1] = "";
                return "Player 2 wins this round. Player 1 wins: " + wins[0] + ", Player 2 wins: " + wins[1];
            //Checks if the weapons are equal; if they are, then the round is a tie.
            } else if (weapon[0].equals(weapon[1])) {
                //If both weapons are empty, this returns an empty string.
                if(weapon[0].equals("")){
                    return "";
                }
                //Sets both weapons to empty after a tie.
                weapon[0] = "";
                weapon[1] = "";
                return "This round is a tie.";
            }
        }
        return "";
    }

    /**
     * Returns a string that tells the correct player to take their turn
     *
     * @return string to tell player to take turn
     */
    public String getCurrentPlayerPrompt() {
        //This simply returns a prompt for player 1 if currentPlayer equals 1 and one for player 2 if currentPlayer equals 2.
        //It also needs to check if the game has been won, otherwise it will print out nothing and just wait for another input from the user.
        if(currentPlayer == 1){
            if(isGameWon()){
                return "Press enter to see the final results!";
            }
            return "Player 1, enter your weapon: ";
        }else{
            return "Player 2, enter your weapon: ";
        }
    }

    /**
     * Takes in an input from a player, validates it, and translates it into a form the program can read
     *
     * @param input
     */
    public void processCurrentPlayerInput(String input) {
        //Checks if the input is valid
        if(input.equals("paper") || input.equals("rock") || input.equals("scissors")) {
            //If currentPlayer equals 1, then it puts the input in the first player's weapon slot.
            if (currentPlayer == 1) {
                weapon[0] = input;
                currentPlayer++;
            //Same as above, but for player 2.
            } else {
                weapon[1] = input;
                currentPlayer--;
            }
        //If the game is not over and the user input is invalid, it will print this and reset currentPlayer to 1, restarting that round.
        }else if(!isGameWon()){
            System.out.println("Please enter rock, paper, or scissors.");
            currentPlayer = 1;
        }
    }

    /**
     * Returns the integer value (either 1 or 2) of the winning player
     *
     * @return 1 if player 1 wins, 2 if player 2 wins
     */
    public int getWinningPlayer() {
        //Simply returns the winningPlayer, which is set in isGameWon.
        return winningPlayer;
    }
}
