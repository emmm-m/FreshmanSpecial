package com.mredrock.freshmanspecial.view.dataFragments;

import android.app.Activity;

import com.mredrock.freshmanspecial.Units.ChartData;

import java.util.List;

/**
 * Created by zia on 17-8-5.
 */

public interface IDataFragment {
    List<String> getCollegeList();
    List<ChartData> getDataList();
    Activity getActivity();
}
