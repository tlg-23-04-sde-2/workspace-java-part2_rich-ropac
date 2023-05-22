package com.javatunes.catalog;

import org.junit.Before;
import org.junit.Test;
import java.util.Collection;
import static org.junit.Assert.*;

public class InMemoryCatalogTest {
    // object under test = "fixture"
    private InMemoryCatalog catalog;

    @Before
    public void setUp() {
        catalog = new InMemoryCatalog();
    }

    @Test
    public void findById_shouldReturnNull_whenIDNotFound() {
        MusicItem item = catalog.findById(19L);
        assertNull(item);
    }
    @Test
    public void findById_shouldReturnItemWithThatID_whenIDFound() {
        MusicItem item = catalog.findById(6L);
        assertEquals(6, item.getId().longValue());
    }

    @Test
    public void findByCategory_shouldReturnPopulatedCollection_whenCategoryFound() {
        Collection<MusicItem> popItems = catalog.findByCategory(MusicCategory.POP);
        //should be size 4
        //all MusicItems
    }

    @Test
    public void findSelfTitledAlbums_shouldReturnSelfTitledAlbums_artistMatches() {
        Collection<MusicItem> selfTitled = catalog.findSelfTitleAlbums();
        assertEquals(2, selfTitled.size());

    }
}