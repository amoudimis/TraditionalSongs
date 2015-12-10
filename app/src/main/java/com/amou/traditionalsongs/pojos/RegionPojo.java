package com.amou.traditionalsongs.pojos;

import java.io.Serializable;

/**
 * Created by dimitrios on 10/12/2015.
 */
public class RegionPojo implements Serializable {

    private static final long serialVersionUID = 1261692273011320602L;

    private int id;
    private String name;

    public RegionPojo(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
