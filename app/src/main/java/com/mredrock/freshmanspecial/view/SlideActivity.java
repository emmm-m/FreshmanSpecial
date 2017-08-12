package com.mredrock.freshmanspecial.view;

import android.app.Activity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
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
    private TextView progressView,titleView;
    private RelativeLayout layout;

    @Override
    protected void initData() {
        viewPager = $(R.id.slide_viewpager);
        progressView = $(R.id.slide_progress);
        titleView = $(R.id.slide_title);
        layout = $(R.id.slide_layout);
        //第一次进入界面加载文字
        progressView.setText((getPosition()+1)+"/"+getImageUrlList().size());
        titleView.setText(getTitleList().get(getPosition()));

        SlidePagerAdapter adapter = new SlidePagerAdapter(getSupportFragmentManager(),this,getTitleList(),getImageUrlList());
        viewPager.setAdapter(adapter);
        //设置当前位置
        viewPager.setCurrentItem(getPosition());
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                /*layout.setVisibility(View.INVISIBLE);*/
            }

            @Override
            public void onPageSelected(int position) {
                //设置上面的进度文字和下面的描述文字，图片加载在SlideFragment里面，不在这里处理
                progressView.setText((position+1)+"/"+getImageUrlList().size());
                titleView.setText(getTitleList().get(position));
                /*layout.setVisibility(View.VISIBLE);
                Animation animation = AnimationUtils.loadAnimation(SlideActivity.this,R.anim.fade_out);
                layout.setAnimation(animation);*/
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

    /**
     * 获取描述文字集合
     * @return
     */
    @Override
    public List<String> getTitleList() {
        return getIntent().getStringArrayListExtra("titleList");
    }

    /**
     * 获取相片url集合
     * @return
     */
    @Override
    public List<String> getImageUrlList() {
        return getIntent().getStringArrayListExtra("imageUrlList");
    }

    /**
     * 获取浏览位置
     * @return
     */
    @Override
    public int getPosition() {
        return getIntent().getIntExtra("position",0);
    }


}
