package com.mredrock.freshmanspecial.view;

import android.support.v4.app.FragmentManager;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mredrock.freshmanspecial.R;
import com.mredrock.freshmanspecial.Units.SlidePagerAdapter;
import com.mredrock.freshmanspecial.Units.base.BaseActivity;

import java.util.List;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class SlideActivity extends BaseActivity implements ISlideActivity {

    private ViewPager viewPager;
    private TextView progressView;

    @Override
    protected void initData() {
        viewPager = $(R.id.slide_viewpager);
        progressView = $(R.id.slide_progress);
        progressView.setText((getPosition()+1)+"/"+getImageUrlList().size());
        SlidePagerAdapter adapter = new SlidePagerAdapter(getSupportFragmentManager(),this,getTitleList(),getImageUrlList());
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(getPosition());
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                progressView.setText((position+1)+"/"+getImageUrlList().size());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    protected int getContentViewId() {
        return R.layout.special_2017_activity_slide;
    }

    @Override
    public List<String> getTitleList() {
        return getIntent().getStringArrayListExtra("titleList");
    }

    @Override
    public List<String> getImageUrlList() {
        return getIntent().getStringArrayListExtra("imageUrlList");
    }

    @Override
    public int getPosition() {
        return getIntent().getIntExtra("position",0);
    }
}
