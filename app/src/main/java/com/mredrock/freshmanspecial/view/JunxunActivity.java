package com.mredrock.freshmanspecial.view;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.mredrock.freshmanspecial.R;
import com.mredrock.freshmanspecial.Units.ViewPagerAdapter;
import com.mredrock.freshmanspecial.Units.base.BaseActivity;
import com.mredrock.freshmanspecial.presenter.DataPresenter;
import com.mredrock.freshmanspecial.presenter.IDataPresenter;
import com.mredrock.freshmanspecial.presenter.JunxunPresenter;
import com.mredrock.freshmanspecial.view.JunxunFragments.FengcaiFragment;
import com.mredrock.freshmanspecial.view.JunxunFragments.TipsFragment;
import com.mredrock.freshmanspecial.view.dataFragments.JobRateFragment;
import com.mredrock.freshmanspecial.view.dataFragments.MostDifficultFragment;
import com.mredrock.freshmanspecial.view.dataFragments.SexRateFragment;

public class JunxunActivity extends BaseActivity implements IDataActivity {

    private ViewPager viewPager;
    private TabLayout tabLayout;
    private TextView title;
    private IDataPresenter presenter;
    private ImageView back;

    @Override
    protected void initData() {
        presenter = new JunxunPresenter(this);
        viewPager = $(R.id.junxun_viewPager);
        tabLayout = $(R.id.junxun_tabLayout);
        title = $(R.id.title_text);
        back = $(R.id.back);
        initPager();
        setPager();
        setTitle("军训特辑");
        setBack();
    }

    private void setTitle(String title) {
        this.title.setText(title);
    }

    private void setPager() {
        //设置下划线边距
        presenter.setTabLayoutBottomLine(40);
    }

    private void initPager() {
        String[] tabTitles = new String[]{"军训贴士", "军训风采"};
        Fragment[] fragments = new Fragment[]{new TipsFragment(), new FengcaiFragment()};
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(), tabTitles, fragments);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    protected int getContentViewId() {
        return R.layout.special_2017_activity_junxun;
    }

    @Override
    public TabLayout getTabLayout() {
        return tabLayout;
    }

    @Override
    public void setBack() {
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}
