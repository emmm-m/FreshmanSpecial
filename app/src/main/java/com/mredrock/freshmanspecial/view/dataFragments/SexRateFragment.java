package com.mredrock.freshmanspecial.view.dataFragments;

import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.mredrock.freshmanspecial.R;
import com.mredrock.freshmanspecial.Units.ChartData;
import com.mredrock.freshmanspecial.Units.CircleChart;
import com.mredrock.freshmanspecial.Units.base.BaseFragment;
import com.mredrock.freshmanspecial.presenter.DataFragmentPresenter;
import com.mredrock.freshmanspecial.presenter.IDataFragmentPresenter;

import java.util.ArrayList;
import java.util.List;


public class SexRateFragment extends BaseFragment implements IDataFragment {

    private Button button;
    private List<String> collegeList = new ArrayList<>();
    private List<ChartData> dataList = new ArrayList<>();
    private CircleChart circleChart;
    private IDataFragmentPresenter presenter;

    @Override
    protected void initData() {
        presenter = new DataFragmentPresenter(this);
        button = $(R.id.sexRate_button);
        circleChart = $(R.id.sexRate_chart);
        presenter.setCollegeList();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.showPickerView(collegeList, new DataFragmentPresenter.OnPickerViewChoosed() {
                    @Override
                    public void getString(String data) {
                        button.setText(data);
                        presenter.setSexRateDataList(data);
                        circleChart.setData(dataList);
                        circleChart.setSpace(110);
                        circleChart.setSpeed(3);
                        circleChart.openLog();
                        circleChart.run();
                    }
                });
            }
        });
    }

    @Override
    protected int getResourceId() {
        return R.layout.special_2017_fragment_sex_rate;
    }

    @Override
    public List<String> getCollegeList() {
        return collegeList;
    }

    @Override
    public List<ChartData> getDataList() {
        return dataList;
    }
}
