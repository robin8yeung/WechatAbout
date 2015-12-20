package com.robinyeung.wechatabout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView mButtonItem;
    private ImageView mLogoView;
    private List<String> mData = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLogoView = (ImageView)findViewById(R.id.image_view);
        mLogoView.setImageResource(R.drawable.weixin);
        mButtonItem = (ListView)findViewById(R.id.list_view);

        mData.add("去评分");
        mData.add("功能介绍");
        mData.add("系统通知");
        mData.add("帮助与反馈");
        mData.add("检查新版本");

        final ButtonListAdepter mButtonListAdepter = new ButtonListAdepter(MainActivity.this, mData);
        mButtonItem.setAdapter(mButtonListAdepter);
        mButtonItem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position==0){
                    mData.clear();
                    mData.add("清空");
                    mButtonListAdepter.refreshData(mData);
                }
                else
                    Toast.makeText(MainActivity.this, mData.get(position), Toast.LENGTH_LONG).show();
            }
        });
    }
}
