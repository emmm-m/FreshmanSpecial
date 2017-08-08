package com.mredrock.freshmanspecial.view.dataFragments;


import android.support.v4.app.Fragment;
import android.view.View;
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
public class JobRateFragment extends BaseFragment implements IDataFragment {

    private Button button;
    private List<String> collegeList = new ArrayList<>();
    private List<ChartData> dataList = new ArrayList<>();
    private CircleChart circleChart;
    private IDataFragmentPresenter presenter;


    @Override
    protected void initData() {
        presenter = new DataFragmentPresenter(this);
        button = $(R.id.jobRate_button);
        circleChart = $(R.id.jobRate_chart);
        presenter.setSexRateCollegeList();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //弹出选择窗口
                presenter.showPickerView(collegeList, new DataFragmentPresenter.OnPickerViewChoosed() {
                    @Override
                    public void getString(final String data) {
                        //设置按钮文字为选中文字
                        button.setText(data);
                        //网络请求
                        presenter.loadJobRateData(data, new DataFragmentPresenter.OnDataLoaded() {
                            @Override
                            public void finish(String msg) {
                                //启动数据图动画
                                presenter.runChart(dataList);
                            }
                        });
                    }
                });
            }
        });
    }

    @Override
    protected int getResourceId() {
        return R.layout.special_2017_fragment_job_rate;
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
        return null;
    }

    @Override
    public CircleChart getChart() {
        return circleChart;
    }

    @Override
    public void toast(String msg) {
        Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
    }
}
