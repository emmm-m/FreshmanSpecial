package com.mredrock.freshmanspecial.view.dataFragments;

import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.mredrock.freshmanspecial.Beans.ShujuBeans.SexBean;
import com.mredrock.freshmanspecial.R;
import com.mredrock.freshmanspecial.Units.ChartData;
import com.mredrock.freshmanspecial.Units.CircleChart;
import com.mredrock.freshmanspecial.Units.SmallCircle;
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

    private List<ChartData> dataList = new ArrayList<>();
    private CircleChart circleChart;
    private SmallCircle smallCircle;
    private IDataFragmentPresenter presenter;

    @Override
    protected void initData() {
        presenter = new DataFragmentPresenter(this);
        button = $(R.id.sexRate_button);
        circleChart = $(R.id.sexRate_chart);
        smallCircle = $(R.id.sexRate_circle);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //从本地设置学院集合
                presenter.setSexRateCollegeList();
                //将集合加载到pickerView里
                presenter.showPickerView(collegeList, new DataFragmentPresenter.OnPickerViewChoosed() {
                    @Override
                    public void getString(final String data) {
                        //在按钮上显示选中学院
                        button.setText(data);
                        //网络请求该学院数据
                        HttpModel.bulid().getSex(new Subscriber<SexBean>() {
                            private SexBean mSexBean = new SexBean();
                            @Override
                            public void onCompleted() {
                                for (SexBean.DataBean bean : mSexBean.getData()) {
                                    if (data.equals(bean.getCollege())) {
                                        presenter.setSexRateDataList(bean);
                                        presenter.runChart(dataList);
                                        initSmallCircle();
                                    }
                                }
                            }

                            @Override
                            public void onError(Throwable e) {
                                Toast.makeText(getContext(), "获取信息失败！", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onNext(SexBean sexBean) {
                                mSexBean = sexBean;
                            }
                        });

                    }
                });

            }
        });
    }

    private void initSmallCircle(){
        List<String> texts = new ArrayList<String>();
        List<Integer> colors = new ArrayList<Integer>();
        List<Integer> shadows = new ArrayList<Integer>();
        for (ChartData d : dataList) {
            texts.add(d.getText());
            colors.add(d.getColor());
            shadows.add(d.getStrokeColor());
        }
        smallCircle.setTexts(texts);
        smallCircle.setColors(colors);
        smallCircle.setShadows(shadows);
        smallCircle.draw();
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
