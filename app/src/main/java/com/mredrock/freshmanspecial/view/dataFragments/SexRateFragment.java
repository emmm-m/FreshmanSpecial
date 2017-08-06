package com.mredrock.freshmanspecial.view.dataFragments;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.mredrock.freshmanspecial.Beans.SexBean;
import com.mredrock.freshmanspecial.R;
import com.mredrock.freshmanspecial.Units.ChartData;
import com.mredrock.freshmanspecial.Units.CircleChart;
import com.mredrock.freshmanspecial.Units.base.BaseFragment;
import com.mredrock.freshmanspecial.model.HttpModel;
import com.mredrock.freshmanspecial.presenter.DataFragmentPresenter;
import com.mredrock.freshmanspecial.presenter.IDataFragmentPresenter;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;


public class SexRateFragment extends BaseFragment implements IDataFragment {

    private Button button;
    private List<String> collegeList = new ArrayList<>();
    private SexBean mSexBean = new SexBean();
    private List<ChartData> dataList = new ArrayList<>();
    private CircleChart circleChart;
    private IDataFragmentPresenter presenter;

    @Override
    protected void initData() {
        presenter = new DataFragmentPresenter(this);
        button = $(R.id.sexRate_button);
        circleChart = $(R.id.sexRate_chart);
        HttpModel.bulid().getSex(new Subscriber<SexBean>() {
            @Override
            public void onCompleted() {
                collegeList.clear();
                for(SexBean.DataBean bean : mSexBean.getData()){
                    collegeList.add(bean.getCollege());
                }
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        presenter.showPickerView(collegeList, new DataFragmentPresenter.OnPickerViewChoosed() {
                            @Override
                            public void getString(String data) {
                                button.setText(data);
                                for(SexBean.DataBean bean : mSexBean.getData()){
                                    if(data.equals(bean.getCollege())){
                                        presenter.setSexRateDataList(bean);
                                        circleChart.setData(dataList);
                                        circleChart.setSpace(90);
                                        circleChart.setSpeed(2);
                                        circleChart.run();
                                    }
                                }
                            }
                        });
                    }
                });
            }

            @Override
            public void onError(Throwable e) {
                Toast.makeText(getContext(), "获取信息出错！", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNext(SexBean sexBean) {
                mSexBean = sexBean;
            }
        });
        /*presenter.setCollegeList();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.showPickerView(collegeList, new DataFragmentPresenter.OnPickerViewChoosed() {
                    @Override
                    public void getString(String data) {
                        button.setText(data);
                        presenter.setSexRateDataList(data);
                        circleChart.setData(dataList);
                        circleChart.setSpace(90);
                        circleChart.setSpeed(2);
                        circleChart.openLog();
                        circleChart.run();
                    }
                });
            }
        });*/
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
