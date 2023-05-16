package com.entertainment;

import java.util.Comparator;

public class TelevisionChannelComparator implements Comparator<Television> {

    @Override
    public int compare(Television tv1, Television tv2) {
     //   return tv1.getCurrentChannel().compareTo(tv2.getCurrentChannel());    // String is Comparable
          return Integer.compare(tv1.getCurrentChannel(), tv2.getCurrentChannel());
    }
}