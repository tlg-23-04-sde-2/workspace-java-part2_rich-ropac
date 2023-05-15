package com.entertainment.client;

import com.entertainment.Television;

import java.util.HashSet;
import java.util.Set;

class TelevisionClient {
    public static void main(String[] args) {
//        // create two tvs
//        Television tv1 = new Television();
//        Television tv2 = new Television("RCA", 10);
//
//        // show their toString() methods in action
//        System.out.println(tv1);
//        System.out.println(tv2);
//
//        // change channel on 'tv2' and print - should be channel 9
//        tv2.changeChannel(9);
//        System.out.println(tv2);
//        System.out.println();

        // examine behavior of == and equals()
        Television tvA = new Television("Sony", 50);
        Television tvB = new Television("Sony", 50);

        System.out.println(("tvA == tvB: " + (tvA == tvB)));           //refer to same object
        System.out.println(("tvA.equals(tvB): " + tvA.equals(tvB)));   // exhibit "equality"
        System.out.println();

        System.out.println(tvA.hashCode());
        System.out.println(tvB.hashCode());

        Set<Television> tvs = new HashSet<>();
        tvs.add(tvA);
        tvs.add(tvB);       // should be rejected as a duplicate, and size is still one.
        System.out.println("The size of the set is: " + tvs.size());

    }
}