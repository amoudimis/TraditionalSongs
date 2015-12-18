package com.amou.traditionalsongs.listeners;

import android.view.View;

/**
 * Created by dimitrios on 18/12/2015.
 */
public interface TextLinkClickListener {

    /**
     *This method is called when the TextLink is clicked from
     *LinkEnabledTextView
     *
     * @param view
     * @param clickedString
     */
    public void onTextLinkClick(View view, String clickedString);
}
