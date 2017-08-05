package com.mredrock.freshmanspecial.view;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.mredrock.freshmanspecial.R;
import com.mredrock.freshmanspecial.Units.base.BaseActivity;
import com.mredrock.freshmanspecial.Units.ViewPagerAdapter;
import com.mredrock.freshmanspecial.presenter.DataPresenter;
import com.mredrock.freshmanspecial.presenter.IDataPresenter;
import com.mredrock.freshmanspecial.view.dataFragments.JobRateFragment;
import com.mredrock.freshmanspecial.view.dataFragments.MostDifficultFragment;
import com.mredrock.freshmanspecial.view.dataFragments.SexRateFragment;

public class DataActivity extends BaseActivity implements IDataActivity {

    private ViewPager viewPager;
    private TabLayout tabLayout;
    private IDataPresenter presenter;
    private TextView title;
    private ImageView back;


    private void setTitle(String title) {
        this.title.setText(title);
    }

    private void setPager() {
        //设置下划线边距
        presenter.setTabLayoutBottomLine(20);
    }

    private void initPager() {
        String[] tabTitles = new String[]{"男女比例", "最难科目", "就业比例"};
        Fragment[] fragments = new Fragment[]{new SexRateFragment(), new MostDifficultFragment(), new JobRateFragment()};
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(), tabTitles, fragments);
        viewPager.setOffscreenPageLimit(2);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    protected void initData() {
        viewPager = $(R.id.data_viewPager);
        tabLayout = $(R.id.data_tabLayout);
        title = $(R.id.title_text);
        back = $(R.id.back);
        presenter = new DataPresenter(this);
        initPager();
        setPager();
        setTitle("重邮数据");
        setBack();
    }

    @Override
    protected int getContentViewId() {
        return R.layout.special_2017_activity_data;
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
