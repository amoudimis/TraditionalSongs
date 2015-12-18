package com.amou.traditionalsongs.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.amou.traditionalsongs.R;
import com.amou.traditionalsongs.pojos.AreasPojo;
import com.amou.traditionalsongs.pojos.SongPojo;

import java.util.ArrayList;

/**
 * Created by dimitrios on 11/12/2015.
 */
public class SongsAdapter extends ArrayAdapter<SongPojo> {

    private Context context;


    public SongsAdapter(Context context, ArrayList<SongPojo> items) {
        super(context, 0, items);
        this.context = context;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolderSong viewHolder = null;
        SongPojo item = getItem(position);

        if (convertView != null) {
            // Get viewholder from view
            viewHolder = (ViewHolderSong) convertView.getTag();
        } else {
            viewHolder = new ViewHolderSong();
            convertView = View.inflate(context, R.layout.listview_areas, null);
            viewHolder.textView1 = (TextView) convertView.findViewById(R.id.textViewAreaName);
        }

        viewHolder.textView1.setText(item.getTitle());
        convertView.setTag(viewHolder);

        return convertView;
    }

    public class ViewHolderSong
    {
        TextView textView1;
    }
}
