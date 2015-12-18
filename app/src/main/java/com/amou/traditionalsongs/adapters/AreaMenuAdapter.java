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
 * Created by dimitrios on 10/12/2015.
 */
public class AreaMenuAdapter extends ArrayAdapter<AreasPojo> {

    private Context context;


    public AreaMenuAdapter(Context context, ArrayList<AreasPojo> items) {
        super(context, 0, items);
        this.context = context;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolderRegion viewHolder = null;
        AreasPojo item = getItem(position);

        if (convertView != null) {
            // Get viewholder from view
            viewHolder = (ViewHolderRegion) convertView.getTag();
        } else {
            viewHolder = new ViewHolderRegion();
            convertView = View.inflate(context, R.layout.listview_region, null);
            viewHolder.textView1 = (TextView) convertView.findViewById(R.id.textViewRegionName);
        }

        viewHolder.textView1.setText(item.getName());
        convertView.setTag(viewHolder);

        return convertView;
    }

    public class ViewHolderRegion
    {
        TextView textView1;
    }
}
