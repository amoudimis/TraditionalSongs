package com.amou.traditionalsongs.objects;

import java.util.ArrayList;

/**
 * Created by dimitrios on 4/12/2015.
 */
public class MyArraylist<T> extends ArrayList<T> {

    private static final long serialVersionUID = -1119053455342685160L;

    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}

