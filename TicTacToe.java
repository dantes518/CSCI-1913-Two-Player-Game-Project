/*
 * Project 2
 * Class: CSCI 1913, Spring 2021, Section 10
 * Professor: Jerald Thomas
 * Student: Dante Schroeder (schr1684)
 */

public class TicTacToe extends TwoPlayerGame{

    //Variables to make the game run.
    static String name = "TicTacToe";
    public String[] board;
    public int turns;
    /**
     * Constructor for a TicTacToe object
     */
    public TicTacToe(){
        //Takes variables from the super class (TwoPlayerGame).
        //I used the same structure and ideas from the 2 previous implementations of tic tac toe, so I built another board array.
        super();
        instructions = "The starting player places an 'x' in one of the locations on the grid.\n" +
                "The second player then places a 'o' on one of the grid locations, but\n" +
                "not one that was previously chosen. This continues until either all the\n" +
                "grid locations have been filled, or until a player wins. A player wins\n" +
                "by placing their \"pieces\" in three grid locations that either share\n" +
                "the same row, column, or diagonal.";
        name = "TicTacToe";
        board = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9" };
        turns = 0;
    }

    /**
     * Returns true if the selected game has been won by a player, and false if not
     *
     * @return true if game is won, false if not
     */
    public boolean isGameWon(){
        //This for loop is a much more simplified method of checking the rows and columns for 3 in a row.
        for(int i = 0; i < 3; i++){
            if(board[(3 * i)].equals(board[(3 * i) + 1]) && board[(3 * i) + 1].equals(board[(3 * i) + 2])){
                return true;
            }else if(board[i].equals(board[i + 3]) && board[i].equals(board[i + 6])){
                return true;
            }
        }
        //Manual checks for the diagonals.
        if(board[0].equals(board[4]) && board[4].equals(board[8])){
            return true;
        }else if(board[2].equals(board[4]) && board[4].equals(board[6])){
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
        //If all 9 spots on the board are taken and the game is not won, it must be a tie.
        if(turns == 9){
            return true;
        }
        return false;
    }

    /**
     * Returns a string that is formatted to show the current state of the game after a turn has been taken
     *
     * @return string for visual representation of game
     */
    public String getCurrentGameState() {
        //Prints out the board after each turn in one statement.
        return board[0] + "|" + board[1] + "|" + board[2] + "\n" +
                "-+-+-\n" +
                board[3] + "|" + board[4] + "|" + board[5] + "\n" +
                "-+-+-\n" +
                board[6] + "|" + board[7] + "|" + board[8];
    }

    /**
     * Returns a string that tells the correct player to take their turn
     *
     * @return string to tell player to take turn
     */
    public String getCurrentPlayerPrompt() {
        //Checks which player's turn it is, and returns a prompt for that player.
        if(currentPlayer == 1){
            return "Player 1 (x) choose your location: ";
        }else{
            return "Player 2 (o) choose your location: ";
        }
    }

    /**
     * Takes in an input from a player, validates it, and translates it into a form the program can read
     *
     * @param input
     */
    public void processCurrentPlayerInput(String input) {
        //Checks if the input is valid (between 1 and 9, inclusive).
        if(Integer.parseInt(input) > 0 && Integer.parseInt(input) < 10){
            //Checks if the spot that was inputted is taken or not.
            if(!board[Integer.parseInt(input) - 1].equals("x") && !board[Integer.parseInt(input) - 1].equals("o")) {
                //If it's player 1's input, it will place an x in that spot.
                if (currentPlayer == 1) {
                    board[Integer.parseInt(input) - 1] = "x";
                    //If this move wins the game, it will not add to currentPlayer. This is used to properly set the winningPlayer variable.
                    if(!isGameWon()){
                        currentPlayer++;
                    }
                //Same as above, but for player 2 instead of player 1.
                } else if (currentPlayer == 2) {
                    board[Integer.parseInt(input) - 1] = "o";
                    if(!isGameWon()){
                        currentPlayer--;
                    }
                }
                //Adds one to turns if the game is not over, in order to determine whether or not the game is a tie.
                if(!isGameWon()) {
                    turns++;
                }
            }
        }
    }

    /**
     * Returns the integer value (either 1 or 2) of the winning player
     *
     * @return 1 if player 1 wins, 2 if player 2 wins
     */
    public int getWinningPlayer() {
        //Sets the winningPlayer variable equal to currentPlayer, and returns it.
        winningPlayer = currentPlayer;
        return winningPlayer;
    }
}
