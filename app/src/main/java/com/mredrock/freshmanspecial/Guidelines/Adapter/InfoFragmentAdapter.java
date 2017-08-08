package com.mredrock.freshmanspecial.Guidelines.Adapter;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;


import com.mredrock.freshmanspecial.R;

import java.util.List;

/**
 * Created by glossimar on 2017/8/3
 * 专题 ： 邮子攻略
 * 界面 ： 邮子攻略-FragmentAdapter
 */

public class InfoFragmentAdapter extends FragmentPagerAdapter {

    private List<String> titles;      //tab 标题
    private List<Fragment> fragments;

    private LayoutInflater layoutInflater;

    private Activity activity;

    public InfoFragmentAdapter(FragmentManager fm, List<String> titles, List<Fragment> fragments
                               , Activity activity) {
        super(fm);
        this.activity = activity;
        this.titles = titles;
        this.fragments = fragments;
    }


    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return titles.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }

    /**
     *  getTabView : 自定义 Tab 的布局View
     * */
    public View getTabView(int position){
        layoutInflater =LayoutInflater.from(activity);
        View view=layoutInflater.inflate(R.layout.tab_item_layout,null);
        TextView textView = (TextView) view.findViewById(R.id.tab_item_tabname);
        textView.setText(titles.get(position));
        return view;
    }
}
