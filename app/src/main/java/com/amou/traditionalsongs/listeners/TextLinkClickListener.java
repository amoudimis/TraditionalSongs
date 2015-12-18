package com.amou.traditionalsongs.listeners;

import android.view.View;

import com.amou.traditionalsongs.values.WordPojo;

/**
 * Created by dimitrios on 18/12/2015.
 */
public interface TextLinkClickListener {

    /**
     *This method is called when the TextLink is clicked from
     *LinkEnabledTextView
     *
     * @param view
     * @param word
     */
    public void onTextLinkClick(View view, WordPojo word);
}
