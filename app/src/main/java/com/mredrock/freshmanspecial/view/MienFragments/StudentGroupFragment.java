package com.mredrock.freshmanspecial.view.MienFragments;

import android.support.design.widget.TabLayout;

import com.mredrock.freshmanspecial.R;
import com.mredrock.freshmanspecial.Units.BaseFragment;

/**
 * Created by zxzhu on 2017/8/4.
 */

public class StudentGroupFragment extends BaseFragment {
    private TabLayout tabs;
    @Override
    protected void initData() {
        tabs = $(R.id.tab_student_groups);
    }

    @Override
    protected int getResourceId() {
        return R.layout.special_2017_fragment_student_group;
    }
}
