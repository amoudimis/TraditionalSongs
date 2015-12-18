package com.amou.traditionalsongs.values;

import com.amou.traditionalsongs.databases.DatabaseHelper;

/**
 * Created by dimitrios on 18/12/2015.
 */
public class WordValues {

    public static String getWords()
    {
        return "INSERT INTO `" + DatabaseHelper.DATABASE_WORDS + "` (`id`, `song_id`, `word`, `description`, `wiki`) VALUES\n" +
                "(1, 4, 'ζαμπάκι', 'ζαμπάκι < τουρκική zambak < αραβική زنبق (zanbak) \"Κρίνος\"', 'https://el.wiktionary.org/wiki/%CE%B6%CE%B1%CE%BC%CF%80%CE%AC%CE%BA%CE%B9');";
    }
}
