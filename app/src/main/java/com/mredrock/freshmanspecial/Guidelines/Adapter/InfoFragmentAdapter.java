package com.mredrock.freshmanspecial.Guidelines.Adapter;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;


import com.mredrock.freshmanspecial.Guidelines.Tools.GradientTextView;
import com.mredrock.freshmanspecial.R;

import java.util.List;

/**
 * Created by glossimar on 2017/8/3
 * 专题 ： 邮子攻略
 * 界面 ： 邮子攻略-FragmentAdapter
 */

public class InfoFragmentAdapter extends FragmentPagerAdapter {
    private final String TAG = "InfoFragmentAdapter";
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
     *  @param ifGradient   文字颜色是否需要渐变
     **/
    public View getTabView(int position, boolean ifGradient){
        layoutInflater =LayoutInflater.from(activity);
        View view = null;
        if (ifGradient) {

            view = layoutInflater.inflate(R.layout.special_2017_gradienttab_item_layout, null);
            GradientTextView gradientText = (GradientTextView) view.findViewById(R.id.gradienttab_item_tabname);
            gradientText.setText(titles.get(position));
            Log.d(TAG, "getTabView: ttttttttttttttttttttttttttttt");
        } else {
            Log.d(TAG, "getTabView: sssssssssssssss");
            view=layoutInflater.inflate(R.layout.special_2017_tab_item_layout,null);
            TextView textView = (TextView) view.findViewById(R.id.tab_item_tabname);
            textView.setText(titles.get(position));
        }
        return view;
    }

}
