package com.mredrock.freshmanspecial.presenter;

import android.content.res.Resources;
import android.icu.text.DateFormat;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;

import com.mredrock.freshmanspecial.Units.ViewPagerAdapter;
import com.mredrock.freshmanspecial.model.DataModel;
import com.mredrock.freshmanspecial.view.DataActivity;
import com.mredrock.freshmanspecial.view.IDataActivity;

import java.lang.reflect.Field;

/**
 * Created by zia on 17-8-4.
 */

public class DataPresenter implements IDataPresenter {

    private IDataActivity activity;
    private DataModel model;

    public DataPresenter(DataActivity activity) {
        this.activity = activity;
        model = new DataModel();
    }

    /**
     * 设置下划线边距
     * @param padding px
     */
    @Override
    public void setTabLayoutBottomLine(final int padding) {
        activity.getTabLayout().post(new Runnable() {
            @Override
            public void run() {
                model.setIndicator(activity.getTabLayout(),padding,padding);
            }
        });
    }


}
