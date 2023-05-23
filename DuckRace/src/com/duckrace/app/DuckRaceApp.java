package com.duckrace.app;

/*
 *  Application "controller"
 *  Sets up the system classes, orchestrates overall flow of the application.
 *  Prompts user for inputs and "forwards" those inputs nto the system (back end).
 */

import com.duckrace.Board;
import com.duckrace.Reward;

import java.util.Locale;
import java.util.Scanner;

public class DuckRaceApp {
    private Scanner scanner = new Scanner(System.in);   // read inputs from console
    private Board board = Board.getInstance();

    public void execute() {
       welcome();
       showBoard();
       int id = promptForID();
       Reward reward = promptForReward();
       updateBoard(id, reward);            // OR you could just say board.update(id, reward)
       showBoard();
    }

    private void updateBoard(int id, Reward reward) {
        board.update(id, reward);
    }


    private Reward promptForReward() {
       Reward reward = null;

       boolean validInput = false;
       while (!validInput) {
           System.out.print("Please enter [D]ebit card or [P]rizes: ");
           String input = scanner.nextLine().trim().toUpperCase();
           if (input.matches("D|P")) {
               validInput = true;
              reward = ("D".equals(input)) ? Reward.DEBIT_CARD : Reward.PRIZES;

           }
       }

       return reward;
    }

    private int promptForID() {
        int id = 0;

        boolean validInput = false;
        while (!validInput) {
            System.out.print("Please enter id of the winner [1-13]: ");  // TODO: don't hardcode 13
            String input = scanner.nextLine().trim();                    // remove lead/trail spaces
            if (input.matches("\\d{1,2}")) {                       // any digit, one or two occurrences
                id = Integer.parseInt(input);                            // safe to convert to int at this point
                if (1 <= id && id <= 13) {                                // valid id, TODO: don't hardcode the 13
                    validInput = true;
                }
            }
        }
        return id;
    }

    private void showBoard() {
        board.show();

    }

    private void welcome() {
        System.out.println(" -------------------------------------- ");
        System.out.println("| Welcome To The Duck Race Application |");
        System.out.println(" -------------------------------------- ");
        System.out.println();

    }
}