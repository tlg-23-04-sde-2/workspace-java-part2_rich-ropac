/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */

package com.javatunes.catalog;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;
import java.text.SimpleDateFormat;

// OF COURSE THIS CLASS DOESN'T COMPILE
// Your first job is to fulfill the contract that this class has signed.
public class InMemoryCatalog implements Catalog {

    private final List<MusicItem> catalogData = new ArrayList<>(List.of(
                   /* id    title                        artist                       releaseDate  price  musicCategory */
        new MusicItem(1L,  "Diva",                      "Annie Lennox",              "1992-01-04", 13.99, MusicCategory.POP),
        new MusicItem(2L,  "Dream of the Blue Turtles", "Sting",                     "1985-02-05", 14.99, MusicCategory.POP),
        new MusicItem(3L,  "Trouble is...",             "Kenny Wayne Shepherd Band", "1997-08-08", 14.99, MusicCategory.BLUES),
        new MusicItem(4L,  "Lie to Me",                 "Jonny Lang",                "1997-08-26", 17.97, MusicCategory.BLUES),
        new MusicItem(5L,  "Little Earthquakes",        "Tori Amos",                 "1992-01-18", 14.99, MusicCategory.ALTERNATIVE),
        new MusicItem(6L,  "Seal",                      "Seal",                      "1991-08-18", 17.97, MusicCategory.POP),
        new MusicItem(7L,  "Ian Moore",                 "Ian Moore",                 "1993-12-05",  9.97, MusicCategory.CLASSICAL),
        new MusicItem(8L,  "So Much for the Afterglow", "Everclear",                 "1997-01-19", 13.99, MusicCategory.ROCK),
        new MusicItem(9L,  "Surfacing",                 "Sarah McLachlan",           "1997-12-04", 17.97, MusicCategory.ALTERNATIVE),
        new MusicItem(10L, "Hysteria",                  "Def Leppard",               "1987-06-20", 17.97, MusicCategory.ROCK),
        new MusicItem(11L, "A Life of Saturdays",       "Dexter Freebish",           "2000-12-06", 16.97, MusicCategory.RAP),
        new MusicItem(12L, "Human Clay",                "Creed",                     "1999-10-21", 18.97, MusicCategory.ROCK),
        new MusicItem(13L, "My, I'm Large",             "Bobs",                      "1987-02-20", 11.97, MusicCategory.COUNTRY),
        new MusicItem(14L, "So",                        "Peter Gabriel",             "1986-10-03", 17.97, MusicCategory.POP),
        new MusicItem(15L, "Big Ones",                  "Aerosmith",                 "1994-05-08", 18.97, MusicCategory.ROCK),
        new MusicItem(16L, "90125",                     "Yes",                       "1983-10-16", 11.97, MusicCategory.ROCK),
        new MusicItem(17L, "1984",                      "Van Halen",                 "1984-08-19", 10.97, MusicCategory.ROCK),
        new MusicItem(18L, "Escape",                    "Journey",                   "1981-02-25", 11.97, MusicCategory.CLASSIC_ROCK))
    );

    @Override
    public MusicItem findById(Long id) {
        // return value
        MusicItem result = null;

        for (MusicItem item : catalogData) {
            if (item.getId().equals(id)) {
                result = item;
                break;
            }
        }

        return result;
    }

    @Override
    public Collection<MusicItem> findByKeyword(String keyword) {
         //return result
        Collection<MusicItem> result = new ArrayList<>();
        for (MusicItem currentItem : catalogData) {
            if (currentItem.getTitle().contains(keyword)  || currentItem.getArtist().contains(keyword)) {
                result.add(currentItem);
            }
        }

        return result;
    }

    @Override
    public Collection<MusicItem> findByCategory(MusicCategory category) {

        Collection<MusicItem> result = new ArrayList<>();
        for (MusicItem item: catalogData) {
            if (item.getMusicCategory().equals(category)) {
                result.add(item);
            }
        }
        return result;
    }

    @Override
    public int size() {
        return catalogData.size();
    }

    @Override
    public Collection<MusicItem> getAll() {
        return catalogData.subList(0,catalogData.size());
    }

    /**
     * After you've satisfied your contractual obligations above, do these additional tasks.
     *
     * NOTES:
     * 0. You can tackle them in any order, each one is independent of the others.
     *    They generally get harder as you go further down.
     *
     * 1. None of these methods should print to stdout (the console).  Instead, return a value.
     *    Each one should be tested by a test method in InMemoryCatalogTest,
     *    and there you *can* print your results, to verify that your code works correctly.
     *
     * 2. You may need to research a few things, that's to be expected.  Life Is Open-Book...
     *    The Javadoc is a good first place to look.
     *
     * 3. Keep a lookout for redundant code.  There is a high probability that you will write a chunk
     *    of code more than once.  When you see that, you should strongly consider refactoring that
     *    repeated code into a private method, and then calling that method from where it's needed.
     *    IntelliJ helps a lot here.  Select the repeated code in question, then
     *    right-click -> Refactor -> Extract Method.
     *    It's not just about removing redundancies - it will make the more complicated methods easier to write!
     */

      //COMPLETE
      public Collection<MusicItem> findSelfTitleAlbums() {
          Collection<MusicItem> result = new ArrayList<>();
          for (MusicItem item : catalogData) {
              if (item.getArtist().equals(item.getTitle())) {
                  result.add(item);
              }
          }
          return result;
      }

      //COMPLETE
      public Collection<MusicItem> findRockItemsAtSpecifiedPrice(double cost) {
          Collection<MusicItem> result = new ArrayList<>();
          MusicCategory category = MusicCategory.ROCK;
          for (MusicItem item : catalogData) {
              if (item.getMusicCategory().equals(category) && item.getPrice() <= cost) {
                  result.add(item);
              }
          }
          return result;
      }

    //COMPLETE
    public int categoryCount(MusicCategory category) {
        int count = 0;

        for (MusicItem item : catalogData) {
             if (item.getMusicCategory().equals(category))  {
             count++;
        }
    }
        return count;
    }

     //COMPLETE
     public double averagePrice() {
         int itemCount = catalogData.size();
         double priceTotals = 0.0;

         for (MusicItem item : catalogData) {
             priceTotals = priceTotals + item.getPrice();
         }
         return (priceTotals/itemCount);
     }

    //COMPLETE
    public MusicItem findCheapestItemForCategory(MusicCategory category) {

        Collection<MusicItem> categoryGroup = new ArrayList<>();
        MusicItem result = null;
        for (MusicItem item : catalogData) {
            if (item.getMusicCategory().equals(category)) {
                categoryGroup.add(item);
            }
        }
        for (MusicItem item : categoryGroup) {
            if (result == null) {
                result = item;
            }

            if (result.getPrice() > item.getPrice()) {
                result = item;
            }
        }
        return result;
    }

    //COMPLETE

    public double findCategoryAveragePrice(MusicCategory category) {

        Collection<MusicItem> result = new ArrayList<>();
        int count = 0;
        double total = 0.0;
        double average = 0.0;

        for (MusicItem item : catalogData) {
            if (item.getMusicCategory().equals(category))  {
                total = total + item.getPrice();
                count++;
            }
        }
        average = total/count;
        return (average);
    }

    /**
     * TASK: are all items priced at least $10?
     * This is a yes/no answer.
     */

    public boolean isAllItemsPricedAt10(double checkValue) {
        boolean result = true;

        for (MusicItem item : catalogData) {
            if (item.getPrice() < checkValue) {
                result = false;
            }
        }
        return result;
    }

     // COMPLETED

     /* TASK: do we sell any items with the specified genre (MusicCategory)?
     * Another yes/no answer.
     */


    public boolean isItemsSoldByCategory(MusicCategory category) {
        boolean result = false;

        for (MusicItem item : catalogData) {
            if (item.getMusicCategory().equals(category))  {
                result = true;
                break;
            }
        }

        return result;
    }


    // COMPLETED
    /*
     * TASK: find the titles of all "pop" items, sorted by natural order.
     * Just the titles
     */

    public List<String> findTitlesForCategory(MusicCategory category) {
        List <String> titles = new ArrayList<>();
        for (MusicItem item : catalogData) {
            if (item.getMusicCategory().equals(category)) {
                titles.add(item.getTitle());
            }
        }
        return titles;
    }



    /**
     * TASK: find all items released in the 80s whose price is less than or equal to the specified price.
     */

    public Collection<MusicItem> findSpecificYearAndPrice(int theYear, double price) {

        Collection<MusicItem> result = new ArrayList<>();

        for (MusicItem item : catalogData) {
            String aDate = item.getReleaseDate().toString();
            LocalDate rDate = LocalDate.parse(aDate);
            if (rDate.getYear() >= theYear && rDate.getYear() <= (theYear + 9) && item.getPrice() <= price) {
                result.add(item);
            }
        }

        return result;
    }

    /**
     * TASK: return a map whose keys are all the genres (categories), and each key's associated value
     * is a collection of items in that genre.  If there is a genre that we don't currently
     * sell, that key's associated value should be an empty collection, not null.
     */


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(getClass().getSimpleName() + ": \n");
        for (MusicItem item: catalogData) {
            builder.append(item).append("\n");
        }
        return builder.toString();
    }
}