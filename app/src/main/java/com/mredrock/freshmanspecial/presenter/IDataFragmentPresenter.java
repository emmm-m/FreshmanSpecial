package com.mredrock.freshmanspecial.presenter;

import java.util.List;

/**
 * Created by zia on 17-8-5.
 */

public interface IDataFragmentPresenter {
    void setCollegeList();
    void setMajorList(String collegeName);
    void setSexRateDataList(String collegeName);
    void setMostDifficultDataList(String majorName);
    void setJobRateDataList(String collegeName);
    void showPickerView(List<String> collegeList, DataFragmentPresenter.OnPickerViewChoosed onPickerViewChoosed);
}
