package com.amou.traditionalsongs.values;

import com.amou.traditionalsongs.databases.DatabaseHelper;

/**
 * Created by dimitrios on 18/12/2015.
 */
public class RegionValues {


    public static String getRegions()
    {
            return "INSERT INTO `" + DatabaseHelper.DATABASE_REGIONS + "` (`" + DatabaseHelper.REGIONS_ID + "`, `" + DatabaseHelper.REGIONS_NAME + "`, `" + DatabaseHelper.REGIONS_NAME_W + "`) VALUES\n" +
                    "(1, 'Θράκη', 'Θρακη'),\n" +
                    "(2, 'Κωνσταντινούπολη','Κωνσταντινουπολη'),\n" +
                    "(3, 'Ανατολική Ρωμυλία', 'Ανατολικη Ρωμυλια'),\n" +
                    "(4, 'Ανατολικό Αιγαίο', 'Ανατολικο Αιγαιο'),\n" +
                    "(5, 'Αρβανίτικα', 'Αρβανιτικα'),\n" +
                    "(6, 'Ήπειρος', 'Ηπειρος'),\n" +
                    "(7, 'Θεσσαλία', 'Θεσσαλια'),\n" +
                    "(8, 'Καππαδοκία', 'Καππαδοκια'),\n" +
                    "(9, 'Κρήτη', 'Κρητη'),\n" +
                    "(10, 'Κυκλάδες', 'Κυκλαδες'),\n" +
                    "(11, 'Μακεδονία', 'Μακεδονια'),\n" +
                    "(12, 'Πόντος', 'Ποντος'),\n" +
                    "(13, 'Ρούμελη', 'Ρουμελη'),\n" +
                    "(14, 'Σαρακατσάνικα', 'Σαρακατσανικα'),\n" +
                    "(15, 'Μικρά Ασία - Ιωνία', 'Μικρα Ασια - Ιωνια');";
    }
}
