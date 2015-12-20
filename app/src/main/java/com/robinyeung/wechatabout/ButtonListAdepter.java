package com.robinyeung.wechatabout;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by RobinYeung on 15/12/16.
 */
public class ButtonListAdepter extends BaseAdapter {
    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private List<String> mData;
    public ButtonListAdepter(Context context, List<String> data) {
        mContext = context;
        mData = data;
        mLayoutInflater = (LayoutInflater)mContext.getSystemService(mContext.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView==null) {
            convertView = mLayoutInflater.inflate(R.layout.button_items, null);
            viewHolder = new ViewHolder();
            viewHolder.mButtonItem = (TextView)convertView.findViewById(R.id.item_button);
            convertView.setTag(viewHolder);
        }
        else{
            viewHolder = (ViewHolder)convertView.getTag();
        }

        viewHolder.mButtonItem.setText(mData.get(position));
        return convertView;
    }

    public void refreshData(List<String> data) {
        mData = data;
        notifyDataSetChanged();
    }

    class ViewHolder{
        TextView mButtonItem;
    }
}
