package com.mredrock.freshmanspecial.presenter;

import com.mredrock.freshmanspecial.Beans.SexBean;
import com.mredrock.freshmanspecial.Beans.WorkBean;

import java.util.List;

/**
 * Created by zia on 17-8-5.
 */

public interface IDataFragmentPresenter {
    void setCollegeList();
    void setMajorList(String collegeName);
    void setSexRateDataList(SexBean.DataBean bean);
    void setMostDifficultDataList(String majorName);
    void setJobRateDataList(WorkBean.DataBean bean);
    void showPickerView(List<String> collegeList, DataFragmentPresenter.OnPickerViewChoosed onPickerViewChoosed);
}
