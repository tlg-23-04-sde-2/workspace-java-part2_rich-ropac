package com.duckrace;

import java.util.List;

class DuckRacerTest {

    public static void main(String[] args) {
        DuckRacer racer10 = new DuckRacer(10, "Kevin");
        System.out.println(racer10);   // toString() automatically called

        // make it "win" a few times
        racer10.win(Reward.DEBIT_CARD);
        racer10.win(Reward.PRIZES);
        racer10.win(Reward.PRIZES);
        System.out.println(racer10);

        //List<Reward> rewardList = racer10.getRewards();  //read only view of the rewards List

    }
}