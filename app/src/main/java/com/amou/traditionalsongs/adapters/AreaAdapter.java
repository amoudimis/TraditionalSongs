package com.amou.traditionalsongs.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.amou.traditionalsongs.R;
import com.amou.traditionalsongs.pojos.AreasPojo;
import com.amou.traditionalsongs.pojos.RegionPojo;

import java.util.ArrayList;

/**
 * Created by dimitrios on 11/12/2015.
 */
public class AreaAdapter extends ArrayAdapter<AreasPojo> {

    private Context context;


    public AreaAdapter(Context context, ArrayList<AreasPojo> items) {
        super(context, 0, items);
        this.context = context;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolderArea viewHolder = null;
        AreasPojo item = getItem(position);

        if (convertView != null) {
            // Get viewholder from view
            viewHolder = (ViewHolderArea) convertView.getTag();
        } else {
            viewHolder = new ViewHolderArea();
            convertView = View.inflate(context, R.layout.listview_areas, null);
            viewHolder.textView1 = (TextView) convertView.findViewById(R.id.textViewAreaName);
        }

        viewHolder.textView1.setText(item.getName());
        convertView.setTag(viewHolder);

        return convertView;
    }

    public class ViewHolderArea
    {
        TextView textView1;
    }
}
