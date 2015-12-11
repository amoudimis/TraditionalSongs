package com.amou.traditionalsongs.pojos;

import java.io.Serializable;

/**
 * Created by dimitrios on 11/12/2015.
 */
public class AreasPojo implements Serializable {
    private static final long serialVersionUID = -4591043571406913596L;

    private int id;
    private int regionId;
    private String name;

    public AreasPojo(int id, int regionId, String name) {
        this.id = id;
        this.regionId = regionId;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRegionId() {
        return regionId;
    }

    public void setRegionId(int regionId) {
        this.regionId = regionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
