package com.entertainment;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TelevisionChannelComparatorTest {
    // you need three objects: tv1, tv2, and an instance of the comparator

    private Television tv1;
    private Television tv2;
    private TelevisionChannelComparator comparator;

    @Before
    public void setUp() {
        tv1 = new Television("Sony", 50, DisplayType.OLED);
        tv2 = new Television("Sony", 50, DisplayType.OLED);
        comparator = new TelevisionChannelComparator();

    }

    @Test
    public void compare_shouldReturnZero_whenSameChannel() {
        assertArrayEquals((0, comparator.compare(tv1, tv2));
    }

    @Test
    public void compare_shouldReturnNegativeNumber_when1stChannelLessThan2ndChannel()
        throws InvalidChannelException {
        tv1.changeChannel(1);
        assertTrue(comparator.compare(tv1,tv2) < 0);
    }
}