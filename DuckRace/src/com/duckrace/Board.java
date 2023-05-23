package com.duckrace;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

/*
 * This is a lookup table of ids to student names.
 * When a duck wins for the first time, we need to find out who that is.
 * This lookup table could be hardcoded with the data, or we could read the data 
 * in from a file, so that no code changes would need to be made for each cohort.
 *
 * Map<Integer,String> studentIdMap;
 * 
 * Integer    String
 * =======    ======
 *    1       John
 *    2       Jane
 *    3       Danny
 *    4       Armando
 *    5       Sheila
 *    6       Tess
 * 
 *
 * We also need a data structure to hold the results of all winners.
 * This data structure should facilitate easy lookup, retrieval, and storage.
 *
 * Map<Integer,DuckRacer> racerMap;
 *
 * Integer    DuckRacer
 * =======    =========
 *            id    name     wins   rewards
 *            --    ----     ----   -------
 *    5        5    Sheila     2    PRIZES, PRIZES
 *    6        6    Tess       1    PRIZES
 *   13       13    Zed        3    PRIZES, DEBIT_CARD, DEBIT_CARD
 *   17       17    Dom        1    DEBIT_CARD
 */

public class Board implements Serializable {
    // class-level common area (static)
    private static final String dataFilePath = "data/board.date";
    private static final String studentIdFilePath = "conf/student-ids.csv";

    /*
     *  If data/board.dat exists, read a Board object from that file.
     *  otherwise create new and return it.
     *  This uses Java's built-in Object Serialization facility.
     */

    public static Board getInstance() {
        Board board = null;

        if (Files.exists(Path.of(dataFilePath))) {
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(dataFilePath))) {
                board = (Board) in.readObject();

            }
            catch(Exception e) {
                e.printStackTrace();;
            }
        } else {
            board = new Board();
        }
        return board;
    }


    //instance variable, present in each Board object
    private final Map<Integer,String> studentIdMap = loadStudentIdMap();
    private final Map<Integer,DuckRacer> racerMap  = new TreeMap<>();

    // CONSTRUCTORS - this one is private, to prevent outside instantiation (only I can create new)
    private Board() {

    }

    /*
     *  Updates the board (racerMap) by making a DuckRacer 'win'.
     *  This could mean fetching an existing DuckRacer from racerMap,
     *  or we might need to create a new DuckRacer and put in the map.
     *  Either way, we need to make it 'win'.
     */
    public void update(int id, Reward reward) {
        DuckRacer racer = null;

        if (racerMap.containsKey(id)) {  // id exists in racerMap, so get DuckRacer next to it
            racer = racerMap.get(id);

        } else {
            racer = new DuckRacer(id, studentIdMap.get(id));
            racerMap.put(id, racer);
        }
        racer.win(reward);
        save();
    }

    // FOR TEST PURPOSES

    void dumpStudentIdMap() {
        System.out.println(studentIdMap);
    }
    // show the DuckRacers (only), ie, the right side of the map
    // TODO: render this data "pretty, " for display to the end user.
    public void show() {
        if (racerMap.isEmpty()) {
            System.out.println("Not current results stored");
        } else {
            System.out.println();
            System.out.println("         Duck Race Results");
            System.out.println("         =================");
            System.out.println();
            System.out.printf("%2s   %-10s    %4s   %s \n", "ID", "Name", "Wins", "Rewards");
            System.out.printf("%2s   %-10s   %4s   %s \n", "--", "-----------", "----", "-----------------------");
        }
            Collection<DuckRacer> racers = racerMap.values();

        for (DuckRacer racer : racers) {
            String rewardsString = racer.getRewards().toString();
            String rewards = rewardsString.substring(1, rewardsString.length() - 1);

            String row = String.format("%2s   %-10s   %4s    %s", racer.getId(), racer.getName(),
                              racer.getWins(), rewards);


            System.out.println(row);
        }
    }

    /*
     *  Save this Board object to binary file "data/board.dat"
     */
    private void save() {
        try (ObjectOutputStream out = new ObjectOutputStream((new FileOutputStream("data/board.dat")))) {
            out.writeObject(this);    // write "me" (a Board object) to the binary file
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Map<Integer, String> loadStudentIdMap() {
        Map<Integer, String> idMap = new HashMap<>();

        // read all lines from conf/student-ids.csv
        try {
            List<String> lines = Files.readAllLines(Path.of("conf/student-ids.csv"));

            // for each line in the file, split it into "tokens"
            // convert the tokens as necessary and put each pair in 'idMap'
            for (String line : lines)  {
                String[] tokens = line.split(",");  //
                idMap.put(Integer.valueOf(tokens[0]), tokens[1]);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return idMap;
    }
}