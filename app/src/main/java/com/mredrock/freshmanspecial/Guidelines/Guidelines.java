package com.mredrock.freshmanspecial.Guidelines;

import android.support.v4.app.Fragment;

import android.support.design.widget.TabLayout;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.HorizontalScrollView;

import com.mredrock.freshmanspecial.Guidelines.Adapter.InfoFragmentAdapter;
import com.mredrock.freshmanspecial.Guidelines.GiudelinesFragment.AdmissionNoticeFragment;
import com.mredrock.freshmanspecial.Guidelines.GiudelinesFragment.CafeteriaFragment;
import com.mredrock.freshmanspecial.Guidelines.GiudelinesFragment.CampusEnvironmentFragment;
import com.mredrock.freshmanspecial.Guidelines.GiudelinesFragment.DailyLifeFragment;
import com.mredrock.freshmanspecial.Guidelines.GiudelinesFragment.DormitoryFragment;
import com.mredrock.freshmanspecial.Guidelines.GiudelinesFragment.PeripheralCuisineFragment;
import com.mredrock.freshmanspecial.Guidelines.GiudelinesFragment.QQgroupFragment;
import com.mredrock.freshmanspecial.Guidelines.GiudelinesFragment.SurroundingBeautyFragment;
import com.mredrock.freshmanspecial.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Glossimar on 2017/8/3
 * 专题 ： 邮子攻略
 * 界面 ： 邮子攻略-主界面
 **/

public class Guidelines extends AppCompatActivity {


    private List<String> titles = new ArrayList<>();
    private List<Fragment> fragments = new ArrayList<>();

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private HorizontalScrollView horizontalScrollView;

    private InfoFragmentAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guidelines);

        initData();
        initViews();
    }


    public void initData() {
        titles.add("校园环境");
        titles.add("学生寝室");
        titles.add("学校食堂");
        titles.add("入学须知");
        titles.add("QQ群");
        titles.add("日常生活");
        titles.add("周边美食");
        titles.add("周边美景");

        fragments.add(new CampusEnvironmentFragment());
        fragments.add(new DormitoryFragment());
        fragments.add(new CafeteriaFragment());
        fragments.add(new AdmissionNoticeFragment());
        fragments.add(new QQgroupFragment());
        fragments.add(new DailyLifeFragment());
        fragments.add(new PeripheralCuisineFragment());
        fragments.add(new SurroundingBeautyFragment());

        adapter = new InfoFragmentAdapter(getSupportFragmentManager()
                , titles, fragments, Guidelines.this);
    }

    public void initViews() {
        tabLayout = (TabLayout) findViewById(R.id.guidelines_tablayout);
        viewPager = (ViewPager) findViewById(R.id.guidelines_viewpager);
//        horizontalScrollView = (HorizontalScrollView) findViewById(R.id.guidelines_horizontal_scroller);

        viewPager.setAdapter(adapter);


        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        for (int i = 0; i < titles.size(); i++) {
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            if (tabLayout != null) {
                tab.setCustomView(adapter.getTabView(i)); // 将自定义的tab加入
            }
        }

    }
}
