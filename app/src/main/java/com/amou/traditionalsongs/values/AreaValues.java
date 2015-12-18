package com.amou.traditionalsongs.values;

import com.amou.traditionalsongs.databases.DatabaseHelper;

/**
 * Created by dimitrios on 18/12/2015.
 */
public class AreaValues {

    public static String getAreas()
    {

        return "INSERT INTO `"+ DatabaseHelper.DATABASE_AREAS +"` (`id`, `region_id`, `name`, `name_w`) VALUES" +
                "(1, 11, 'Άσσηρος', 'Ασσηρος')," +
                "(2, 11, 'Πυλαία', 'Πυλαια'),"+
                "(3, 11, 'Σοχός', 'Σοχος'),"+
                "(4, 11, 'Νεοχωρούδα', 'Νεοχωρουδα'),"+
                "(5, 11, 'Δρυμός', 'Δρυμoς');";
    }
}
