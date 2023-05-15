/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */

package com.javatunes.catalog.test;

import com.javatunes.catalog.InMemoryCatalog;
import com.javatunes.catalog.MusicCategory;
import com.javatunes.catalog.MusicItem;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

class InMemoryCatalogTest {

    /*
     * One by one, complete each test method below, and then "activate" it by
     * uncommenting the call to that method in main().
     *
     * Once you see that the test method verifies the corresponding business method
     * works correctly, you can comment out that call in main() and proceed to the next one.
     */
    public static void main(String[] args) {
        // testFindById();                      //Completed
        // testFindByKeyword();                 //Completed
        // testFindByCategory();                //Completed
        // testSize();                          //Completed
        // testGetAll();                        //Completed

        // testFindSelfTitleAlbums();                  //Completed
        // testFindRockItemsAtSpecifiedPrice();        //Completed
        // testCategoryCount();                        //Completed
        // testAverageCatalogPrice();                  //Completed
        // testFindCheapestItemForCategory();          //Completed
        // testFindCategoryAveragePrice();             //Completed
        // testIsAllItemsPricedAt10();                 //Completed
        // testIsItemsSoldByCategory();                //Completed
        // testFindTitlesForCategory();                //Completed
        testFindSpecificYearAndPrice();
    }

    private static void testFindById() {
        InMemoryCatalog catalog = new InMemoryCatalog();
        MusicItem itemFound = catalog.findById(6L);
        System.out.println(itemFound);

        MusicItem itemNotFound = catalog.findById(1L);
        if (itemNotFound == null) {
            System.out.println("The id you entered: 19L, was not found");
        } else {
            System.out.println(itemNotFound);
        }
    }

    private static void testFindByKeyword() {
        InMemoryCatalog catalog = new InMemoryCatalog();
        Collection<MusicItem> itemsFound = catalog.findByKeyword("Yes");
        dump(itemsFound);

        Collection<MusicItem> itemsNotFound = catalog.findByKeyword("Yes");
        if (itemsNotFound.isEmpty()) {
            System.out.println("Your search by keyword didn't not find any matches.  Please try again.");
        } else {
            dump(itemsNotFound);
        }
    }

    private static void testFindByCategory() {
        InMemoryCatalog catalog = new InMemoryCatalog();
        Collection<MusicItem> items = catalog.findByCategory(MusicCategory.POP);
        if (items.isEmpty()) {
            System.out.println("Your search by category didn't return anything.  Please try again");
        } else {
            dump(items);
        }
    }

    private static void testSize() {
        InMemoryCatalog catalog = new InMemoryCatalog();
        Collection<MusicItem> wholeCollection = catalog.getAll();
        System.out.println("The catalog collection has " + wholeCollection.size() + " items.");
    }

    private static void testGetAll() {
        InMemoryCatalog catalog = new InMemoryCatalog();
        Collection<MusicItem> wholeCollection = catalog.getAll();
        dump(wholeCollection);
    }

    private static void testFindSelfTitleAlbums() {
        InMemoryCatalog catalog = new InMemoryCatalog();
        Collection<MusicItem> itemsFound = catalog.findSelfTitleAlbums();
        if (itemsFound.isEmpty()) {
            System.out.println("There are no self title albums in the catalog. Please try again.");
        } else {
            dump(itemsFound);
        }
    }

    private static void testFindRockItemsAtSpecifiedPrice() {
        InMemoryCatalog catalog = new InMemoryCatalog();
        Collection<MusicItem> itemsFound = catalog.findRockItemsAtSpecifiedPrice(15.0);
        if (itemsFound.isEmpty()) {
            System.out.println("There are no self title albums in the catalog. Please try again.");
        } else {
            dump(itemsFound);
        }
    }

    private static void testCategoryCount() {
        InMemoryCatalog catalog = new InMemoryCatalog();
        MusicCategory category = MusicCategory.POP;
        int items = catalog.categoryCount(category);
        if (items == 0) {
            System.out.println("There are no self title albums in the catalog. Please try again.");
        } else {
            System.out.println("There are " + items + " for the category " + category);
        }
    }

    private static void testAverageCatalogPrice() {
        InMemoryCatalog catalog = new InMemoryCatalog();
        double averagePrice = catalog.averagePrice();
        if (averagePrice == 0) {
            System.out.println("There are no items with prices listed in the catalog");
        } else {
            System.out.printf("The average price for the items in the catalog is: $%.2f", averagePrice);
        }

    }

    private static void testFindCheapestItemForCategory() {
        InMemoryCatalog catalog = new InMemoryCatalog();
        MusicCategory category = MusicCategory.ROCK;
        MusicItem item = catalog.findCheapestItemForCategory(category);
        System.out.println("The cheapest item is: ");
        System.out.println(item);
    }

    private static void testFindCategoryAveragePrice() {
        InMemoryCatalog catalog = new InMemoryCatalog();
        MusicCategory category = MusicCategory.RAP;
        double averagePrice = catalog.findCategoryAveragePrice(category);
        if (averagePrice == 0.0) {
            System.out.println("There are no items with prices listed in that category");
        } else {
            System.out.printf("The average price for the items in the category %s is: $%.2f", category, averagePrice);
        }
    }

    private static void testIsAllItemsPricedAt10() {

        double checkValue = 10.0;
        InMemoryCatalog catalog = new InMemoryCatalog();
        boolean result = catalog.isAllItemsPricedAt10(checkValue);
        if (result) {
            System.out.printf("True: All items are priced at least or above $%.2f", checkValue);
        } else {
            System.out.printf("False: There are some items priced below $%.2f", checkValue);
        }
    }

    private static void testIsItemsSoldByCategory() {
        InMemoryCatalog catalog = new InMemoryCatalog();
        MusicCategory category = MusicCategory.JAZZ;
        boolean result = catalog.isItemsSoldByCategory(category);
        if (result) {
            System.out.printf("True: There are items in the catalog for %s", category);
        } else {
            System.out.printf("False: There are no items in the catalog for %s", category);
        }

    }

    private static void testFindTitlesForCategory() {

        InMemoryCatalog catalog = new InMemoryCatalog();
        MusicCategory category = MusicCategory.ROCK;
        List<String> titlesFound = catalog.findTitlesForCategory(category);
        Collections.sort(titlesFound);
        System.out.printf("The sorted titles for the category %s are:\n", category);
        for (String myStr : titlesFound) {
            System.out.println(" " + myStr);
        }
    }

    private static void testFindSpecificYearAndPrice() {
        int theYear = 1980;
        double thePrice = 5.00;
        InMemoryCatalog catalog = new InMemoryCatalog();
        Collection<MusicItem> itemsFound = catalog.findSpecificYearAndPrice(theYear, thePrice);
        if (itemsFound.isEmpty()) {
            System.out.println("There are no items in the catalog meeting your search criteria. Please try again.");
        } else {
            dump(itemsFound);
        }
    }

    // helper method to dump a Collection<MusicItem> "vertically"
    private static void dump(Collection<MusicItem> items) {
        for (MusicItem item : items) {
            System.out.println(item);
        }
    }
}