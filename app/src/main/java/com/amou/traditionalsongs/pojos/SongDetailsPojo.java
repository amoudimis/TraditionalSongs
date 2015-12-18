package com.amou.traditionalsongs.pojos;

import java.io.Serializable;

/**
 * Created by dimitrios on 18/12/2015.
 */
public class SongDetailsPojo implements Serializable {
    private static final long serialVersionUID = 8922809410415976846L;

    private String lyrics;

    public String getLyrics() {
        return lyrics;
    }

    public void setLyrics(String lyrics) {
        this.lyrics = lyrics;
    }
}
