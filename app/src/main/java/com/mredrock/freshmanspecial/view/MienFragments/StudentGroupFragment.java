package com.mredrock.freshmanspecial.view.MienFragments;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.mredrock.freshmanspecial.R;
import com.mredrock.freshmanspecial.Units.ViewPagerAdapter;
import com.mredrock.freshmanspecial.Units.base.BaseFragment;

/**
 * Created by zxzhu on 2017/8/4.
 */

public class StudentGroupFragment extends BaseFragment {
    private TabLayout tabs;
    private ViewPager viewPager;
    @Override
    protected void initData() {
        viewPager = $(R.id.vp_student_groups);
        tabs = $(R.id.tab_student_groups);
        initPager();
    }

    @Override
    protected int getResourceId() {
        return R.layout.special_2017_fragment_student_group;
    }

    private void initPager() {
//        int wide = ScreenUnit.bulid(this).getDpWide()*2/7;
//        tabLayout.setMinimumWidth(wide);
        String[] tabTitles = new String[]{"团委直属部门", "红岩网校工作站", "科技联合会", "青年志愿者协会", "校学生会", "大学生艺术团"};
        Fragment[] fragments = new Fragment[6];
        for (int i= 0; i< 6; i++){
            fragments[i] = new GroupContentFragment(tabTitles[i]);
        }
        ViewPagerAdapter adapter = new ViewPagerAdapter(getActivity().getSupportFragmentManager(), tabTitles, fragments);
        viewPager.setAdapter(adapter);
        tabs.setupWithViewPager(viewPager);
    }
}
