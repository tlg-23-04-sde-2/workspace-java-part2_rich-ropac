public class GameBoard<chr> {

    String[] grid = {"", "", "", "", "", "", "", "", ""};
    String player = "";
    String status = "In-Play";


    // CONSTRUCTORS - this one is private, to prevent outside instantiation (only I can create new)
    public GameBoard() {

    }

    public void updateBoard(String theMark, int position) {
        grid[position] = theMark;
    }

    public boolean isThereAWinner(String[] grid, String player) {

        if (
                (grid[0].equals(player) && grid[1].equals(player) && grid[2].equals(player)) ||
                (grid[3].equals(player) && grid[4].equals(player) && grid[5].equals(player)) ||
                (grid[6].equals(player) && grid[7].equals(player) && grid[8].equals(player)) ||
                (grid[0].equals(player) && grid[3].equals(player) && grid[6].equals(player)) ||
                (grid[1].equals(player) && grid[4].equals(player) && grid[7].equals(player)) ||
                (grid[2].equals(player) && grid[5].equals(player) && grid[8].equals(player)) ||
                (grid[0].equals(player) && grid[4].equals(player) && grid[8].equals(player)) ||
                (grid[2].equals(player) && grid[4].equals(player) && grid[6].equals(player))) {
            return true;
        } else {
            return false;
        }
    }

    public void showBoard(String thePlayer, String theStatus) {

        String player = thePlayer;
        String status = theStatus;

        final String ANSI_BLUE = "\u001B[34m";
        final String ANSI_GREEN = "\u001B[32m";
        final String ANSI_PURPLE = "\u001B[35m";
        final String ANSI_RED = "\u001B[31m";
        final String ANSI_YELLOW = "\u001B[33m";
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_CLEAR = "\033[H\033[2J";

        //Print out the headers
        System.out.printf(ANSI_CLEAR);
        System.out.println();
        System.out.printf(ANSI_GREEN + "%64s\n", "***************************" + ANSI_RESET);
        System.out.printf(ANSI_GREEN + "%70s\n", "******* " + ANSI_BLUE + "TIC-TAC-TOE" + ANSI_GREEN + " *******");
        System.out.printf(ANSI_GREEN + "%64s\n", "***************************" + ANSI_RESET);

        switch (status) {
            case "Game Over": {
                System.out.printf(ANSI_GREEN + "%23s", "Game Status: " + ANSI_RESET);
                System.out.printf(ANSI_RED + "%s\n", status + ANSI_RESET);
                System.out.printf(ANSI_GREEN + "%23s", "Winner Is: " + ANSI_RESET);
                System.out.printf(ANSI_BLUE + "%s", player + ANSI_RESET);
                break;
            }
            case "Tie": {
                System.out.printf(ANSI_GREEN + "%23s", "Game Status: " + ANSI_RESET);
                System.out.printf(ANSI_RED + "%s\n", status + ANSI_RESET);
                //System.out.printf(ANSI_GREEN + "%23s", "Winner Is: " + ANSI_RESET);
                System.out.printf(ANSI_BLUE + "%s", player + ANSI_RESET);
                break;
            }
            default: {
                System.out.printf(ANSI_GREEN + "%23s", "Game Status: " + ANSI_RESET);
                System.out.printf(ANSI_BLUE + "%s\n", status + ANSI_RESET);
                System.out.printf(ANSI_GREEN + "%23s", "Player Up: " + ANSI_RESET);
                System.out.printf(ANSI_BLUE + "%s", player + ANSI_RESET);
            }
        }

        //Print out the board
        System.out.println("");
        System.out.printf(ANSI_GREEN + "%55s", "   |     |    \n");
        System.out.printf(ANSI_BLUE + "%41s" + ANSI_GREEN + "  |  " + ANSI_BLUE + "%1s" +
                ANSI_GREEN + "  |  " + ANSI_BLUE + "%1s\n", grid[0], grid[1], grid[2]);
        System.out.printf(ANSI_GREEN + "%57s", "------+-----+------\n");
        System.out.printf(ANSI_BLUE + "%41s" + ANSI_GREEN + "  |  " + ANSI_BLUE + "%1s" +
                ANSI_GREEN + "  |  " + ANSI_BLUE + "%1s\n", grid[3], grid[4], grid[5]);
        System.out.printf(ANSI_GREEN + "%57s", "------+-----+------\n");
        System.out.printf(ANSI_BLUE + "%41s" + ANSI_GREEN + "  |  " + ANSI_BLUE + "%1s" +
                ANSI_GREEN + "  |  " + ANSI_BLUE + "%1s\n", grid[6], grid[7], grid[8]);
        System.out.printf(ANSI_GREEN + "%55s", "   |     |    \n");
    }
}