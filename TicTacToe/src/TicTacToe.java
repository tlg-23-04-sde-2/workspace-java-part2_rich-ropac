import java.util.*;
import java.util.Map;

public class TicTacToe {

    static String[] player1Positions = new String[9];
    static String[] halsPositions = new String[9];
    static String halsMark = "O";
    static String player1sMark = "X";

    public static void main(String[] args) {

        //set up for Player 1 to start
        Scanner scanner = new Scanner(System.in);           // reads input from console
        GameBoard board = new GameBoard();
        String currentPlayer = "Player 1";
        String currentStatus = "In-Play";
        board.showBoard("currentPlayer", currentStatus);

        //Over all while loop while the game is in play.  Terminates if Player enters a Q and if there is a Win or Tie
        while (currentStatus.equals("In-Play")) {

            //  Get human players input can only be 1 through 9 or "Q" to quit.
            boolean validInput = false;
            int player1sPosition = 0;

            //While Loop for checking for Player 1's input to be valid and the spot is vacant
            while (!validInput) {
                System.out.print("Enter your placement (1-9): ");
                String input = scanner.nextLine().trim().toUpperCase();
                player1sPosition = Integer.parseInt(input) - 1;

                if (input.matches("1|2|3|4|5|6|7|8|9|Q")) {
                    if (input.equals("Q")) {
                        break;
                    } else {
                        //checking to ensure the Player's selection isn't already taken
                        while (player1Positions[player1sPosition] != null || halsPositions[player1sPosition] != null) {
                            System.out.println("Position taken! Enter a correct Position");
                            input = scanner.nextLine().trim().toUpperCase();
                            player1sPosition = Integer.parseInt(input) - 1;
                        }
                    }
                    player1Positions[player1sPosition] = player1sMark;
                    board.updateBoard(player1sMark, player1sPosition);
                    board.showBoard(currentPlayer, "In-Play");
                }
                validInput = true;

                //Check after Player 1's turn to see if there is a winner
                if (board.isThereAWinner(board.grid, player1sMark)) {
                    board.status = "Game Over";
                    board.player = "Player 1";
                    board.showBoard(board.player, board.status);
                    System.exit(0);
                }

                //Check to see if there is a Tie
                List<String> tieTracker = new ArrayList<>(Arrays.asList(board.grid));
                tieTracker.removeAll(Arrays.asList("", null));

                if (tieTracker.size() == 9) {
                    board.status = "Tie";
                    board.player = "It's A Tie";
                    board.showBoard(board.player, board.status);
                }

//                double bestScore = Double.NEGATIVE_INFINITY;
//                for (int i = 0; i < 9; i++) {
//                    if (board.grid[i].equals("")) {
//                        board.grid[i] = halsMark;
//                        int score = miniMax(board.grid, depth = 1, false);
//                    }
//                }

                //Hals turn and playing with a random generator
                Random rand = new Random();
                int halsPosition = rand.nextInt(9);
                //checking to ensure Hals number is going into a blank spot
                while (player1Positions[halsPosition] != null || halsPositions[halsPosition] != null) {
                    halsPosition = rand.nextInt(9);
                }
                halsPositions[halsPosition] = halsMark;
                board.updateBoard(halsMark, halsPosition);
                board.showBoard("Hal", "In-Play");

                //check for a winner after Hals move
                if (board.isThereAWinner(board.grid, halsMark)) {
                    board.updateBoard(halsMark, halsPosition);
                    board.status = "Game Over";
                    board.player = "Hal";
                    board.showBoard(board.player, board.status);
                    System.exit(0);

                }
            }
        }
    }
}
