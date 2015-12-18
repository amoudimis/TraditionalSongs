package com.amou.traditionalsongs.pojos;

import java.io.Serializable;

/**
 * Created by dimitrios on 18/12/2015.
 */
public class SongPojo implements Serializable {
    private static final long serialVersionUID = -4267080999734381773L;

    private int id;
    private String title;
    private boolean hasLyrics;
    private boolean hasDance;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isHasLyrics() {
        return hasLyrics;
    }

    public void setHasLyrics(boolean hasLyrics) {
        this.hasLyrics = hasLyrics;
    }

    public boolean isHasDance() {
        return hasDance;
    }

    public void setHasDance(boolean hasDance) {
        this.hasDance = hasDance;
    }
}
