package com.mredrock.freshmanspecial.view;

import android.support.v4.view.ViewPager;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.mredrock.freshmanspecial.R;
import com.mredrock.freshmanspecial.Units.MyViewPager;
import com.mredrock.freshmanspecial.Units.SlidePagerAdapter;
import com.mredrock.freshmanspecial.Units.base.BaseActivity;

import java.util.List;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class SlideActivity extends BaseActivity implements ISlideActivity {

    private MyViewPager viewPager;
    private TextView progressView, titleView;
    private RelativeLayout layout;
    private Animation alpha_in, alpha_out;
    private boolean isLayoutShow = true;
    private boolean isTowPointClick = false;

    @Override
    protected void initData() {
        viewPager = $(R.id.slide_viewpager);
        progressView = $(R.id.slide_progress);
        titleView = $(R.id.slide_title);
        layout = $(R.id.slide_layout);
        alpha_in = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        alpha_out = AnimationUtils.loadAnimation(this, R.anim.fade_out);
        //第一次进入界面加载文字
        progressView.setText((getPosition() + 1) + "/" + getImageUrlList().size());
        titleView.setText(getTitleList().get(getPosition()));

        SlidePagerAdapter adapter = new SlidePagerAdapter(getSupportFragmentManager(), this, getTitleList(), getImageUrlList());
        viewPager.setAdapter(adapter);

        viewPager.setOffscreenPageLimit(1);
        //设置当前位置
        viewPager.setCurrentItem(getPosition());
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (!isTowPointClick) {
                    layout.startAnimation(alpha_in);
                    layout.setVisibility(View.VISIBLE);
                    isLayoutShow = true;
                }
                //设置上面的进度文字和下面的描述文字，图片加载在SlideFragment里面，不在这里处理
                progressView.setText((position + 1) + "/" + getImageUrlList().size());
                titleView.setText(getTitleList().get(position));
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        final long[] time = new long[1];
        viewPager.setOnMyClick(new MyViewPager.OnMyClick() {
            @Override
            public void onActionDown(MotionEvent event) {
                time[0] = System.currentTimeMillis();
            }

            @Override
            public void onTwoPointClick(MotionEvent event) {

                if (isLayoutShow) {
//                    isTowPointClick = true;
                    layout.startAnimation(alpha_out);
                    layout.setVisibility(View.INVISIBLE);
                    isLayoutShow = false;
                }

            }

            @Override
            public void onOnePointClick(MotionEvent event) {
//                isTowPointClick = false;
            }

            @Override
            public void onActionUp(MotionEvent event) {
                long time_up = System.currentTimeMillis();
                boolean isClick = ((time_up - time[0]) < 200);
                if (isClick && isLayoutShow) {
                    layout.startAnimation(alpha_out);
                    layout.setVisibility(View.INVISIBLE);
                    isLayoutShow = false;
                } else {
                    if (isClick && !isLayoutShow) {
                        layout.startAnimation(alpha_in);
                        layout.setVisibility(View.VISIBLE);
                        isLayoutShow = true;
                    }
                }
//                isTowPointClick = false;
            }
        });
    }

    @Override
    protected int getContentViewId() {
        return R.layout.special_2017_activity_slide;
    }

    /**
     * 获取描述文字集合
     *
     * @return
     */
    @Override
    public List<String> getTitleList() {
        return getIntent().getStringArrayListExtra("titleList");
    }

    /**
     * 获取相片url集合
     *
     * @return
     */
    @Override
    public List<String> getImageUrlList() {
        return getIntent().getStringArrayListExtra("imageUrlList");
    }

    /**
     * 获取浏览位置
     *
     * @return
     */
    @Override
    public int getPosition() {
        return getIntent().getIntExtra("position", 0);
    }

}
