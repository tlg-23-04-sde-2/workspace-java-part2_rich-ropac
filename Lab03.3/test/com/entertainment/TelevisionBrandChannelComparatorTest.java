package com.entertainment;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TelevisionBrandChannelComparatorTest {

    private Television tv1;
    private Television tv2;
    private TelevisionChannelBrandComparator comparator;

    @Before
    public void setUp() throws Exception{
        tv1 = new Television("Sony", 50, DisplayType.OLED);
        tv2 = new Television("Sony", 50, DisplayType.OLED);
        comparator = new TelevisionBrandChannelComparator();
    }

    @Test
    public void TelevisionBrandChannelComparator_shouldReturnTrue_whenBrandsEqual() {
        assertEquals(0, comparator.compare(tv1, tv2));
    }

    @Test
    public void TelevisionBrandChannelComparator_shouldReturnFalse_whenBrandsEqual() {
        tv2.setBrand("LG");
        assertFalse(comparator.compare(tv1, tv2));
    }

}