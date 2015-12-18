package com.amou.traditionalsongs.values;

import java.io.Serializable;

/**
 * Created by dimitrios on 18/12/2015.
 */
public class WordPojo implements Serializable {
    private static final long serialVersionUID = 1501898471968131749L;

    private int id;
    private int song_id;
    private String word;
    private String description;
    private String wiki;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSong_id() {
        return song_id;
    }

    public void setSong_id(int song_id) {
        this.song_id = song_id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWiki() {
        return wiki;
    }

    public void setWiki(String wiki) {
        this.wiki = wiki;
    }
}
