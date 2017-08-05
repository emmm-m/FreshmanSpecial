package com.mredrock.freshmanspecial.view.dataFragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.mredrock.freshmanspecial.R;
import com.mredrock.freshmanspecial.Units.ChartData;
import com.mredrock.freshmanspecial.Units.CircleChart;
import com.mredrock.freshmanspecial.Units.base.BaseFragment;
import com.mredrock.freshmanspecial.presenter.DataFragmentPresenter;
import com.mredrock.freshmanspecial.presenter.IDataFragmentPresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MostDifficultFragment extends BaseFragment implements IDataFragment {

    private Button button,majorButton;
    private List<String> collegeList = new ArrayList<>();
    private List<String> majorList = new ArrayList<>();
    private List<ChartData> dataList = new ArrayList<>();
    private CircleChart circleChart;
    private IDataFragmentPresenter presenter;


    @Override
    protected void initData() {
        presenter = new DataFragmentPresenter(this);
        button = $(R.id.mostDifficult_button);
        majorButton = $(R.id.mostDifficult_button_major);
        majorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "请先选择学院", Toast.LENGTH_SHORT).show();
            }
        });
        circleChart = $(R.id.mostDifficult_chart);
        presenter.setCollegeList();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.showPickerView(collegeList, new DataFragmentPresenter.OnPickerViewChoosed() {
                    @Override
                    public void getString(String data) {
                        button.setText(data);
                        presenter.setMajorList(data);
                        majorButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                presenter.showPickerView(majorList, new DataFragmentPresenter.OnPickerViewChoosed() {
                                    @Override
                                    public void getString(String data1) {
                                        majorButton.setText(data1);
                                        presenter.setMostDifficultDataList(data1);
                                        circleChart.setData(dataList);
                                        circleChart.setSpace(90);
                                        circleChart.setSpeed(2);
                                        circleChart.openLog();
                                        circleChart.run();
                                    }
                                });
                            }
                        });
                    }
                });
            }
        });
    }

    @Override
    protected int getResourceId() {
        return R.layout.special_2017_fragment_most_difficult;
    }

    @Override
    public List<String> getCollegeList() {
        return collegeList;
    }

    @Override
    public List<ChartData> getDataList() {
        return dataList;
    }

    @Override
    public List<String> getMajorList() {
        return majorList;
    }
}
