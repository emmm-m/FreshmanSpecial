package com.mredrock.freshmanspecial.view;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.widget.TextView;

import com.mredrock.freshmanspecial.R;
import com.mredrock.freshmanspecial.Units.BaseActivity;
import com.mredrock.freshmanspecial.Units.ViewPagerAdapter;
import com.mredrock.freshmanspecial.presenter.IMienPresenter;
import com.mredrock.freshmanspecial.presenter.MienPresenter;
import com.mredrock.freshmanspecial.view.MienFragments.BeautyFragment;
import com.mredrock.freshmanspecial.view.MienFragments.ExcellentFragment;
import com.mredrock.freshmanspecial.view.MienFragments.OriginalFragment;
import com.mredrock.freshmanspecial.view.MienFragments.StudentGroupFragment;

public class MienActivity extends BaseActivity implements IMienActivity{


    private ViewPager viewPager;
    private TabLayout tabLayout;
    private IMienPresenter presenter;
    private TextView title;


    private void setTitle(String title) {
        this.title.setText(title);
    }

    private void setPager() {
        //设置下划线边距
        presenter.setTabLayoutBottomLine(20);
    }

    private void initPager() {
//        int wide = ScreenUnit.bulid(this).getDpWide()*2/7;
//        tabLayout.setMinimumWidth(wide);
        String[] tabTitles = new String[]{"学生组织", "原创重邮", "美在重邮","优秀师生"};
        Fragment[] fragments = new Fragment[]{new StudentGroupFragment(), new OriginalFragment(), new BeautyFragment(), new ExcellentFragment()};
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(), tabTitles, fragments);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }


    @Override
    protected void initData() {
        viewPager = $(R.id.vp_mien);
        tabLayout = $(R.id.tab_mien);
        title = $(R.id.title_text);
        presenter = new MienPresenter(this);
        initPager();
        setPager();
        setTitle("重邮风采");
    }

    @Override
    protected int getContentViewId() {
        return R.layout.special_2017_activity_cqupt_mien;
    }

    @Override
    public TabLayout getTabLayout() {
        return tabLayout;
    }


}
