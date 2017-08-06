package com.mredrock.freshmanspecial.presenter;

import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.bigkoo.pickerview.OptionsPickerView;
import com.bigkoo.pickerview.listener.CustomListener;
import com.mredrock.freshmanspecial.Beans.SexBean;
import com.mredrock.freshmanspecial.Beans.WorkBean;
import com.mredrock.freshmanspecial.R;
import com.mredrock.freshmanspecial.Units.ChartData;
import com.mredrock.freshmanspecial.model.DataModel;
import com.mredrock.freshmanspecial.model.HttpModel;
import com.mredrock.freshmanspecial.view.dataFragments.IDataFragment;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;

/**
 * Created by zia on 17-8-5.
 */

public class DataFragmentPresenter implements IDataFragmentPresenter {

    private IDataFragment fragment;
    private DataModel model;
    private OptionsPickerView optionsPickerView;

    public DataFragmentPresenter(IDataFragment fragment){
        this.fragment = fragment;
        model = new DataModel();
    }


    /**
     * 设置学院名称集合，fragment必须实现IDataFragment接口
     */
    @Override
    public void setCollegeList() {
        fragment.getCollegeList().clear();
        fragment.getCollegeList().addAll(model.getCollegeList());
    }

    @Override
    public void setMajorList(String collegeName) {
        fragment.getMajorList().clear();
        if(model.getMajorList(collegeName) != null){
            fragment.getMajorList().addAll(model.getMajorList(collegeName));
        }
    }

    @Override
    public void setSexRateDataList(SexBean.DataBean bean) {
        fragment.getDataList().clear();
        fragment.getDataList().addAll(model.getSexRateDataList(bean));
    }

    @Override
    public void setMostDifficultDataList(String majorName) {
        fragment.getDataList().clear();
        if(model.getMostDifficultDataList(majorName) != null){
            fragment.getDataList().addAll(model.getMostDifficultDataList(majorName));
        }
    }

    @Override
    public void setJobRateDataList(WorkBean.DataBean bean) {
        fragment.getDataList().clear();
        if(model.getJobRateDataList(bean) != null){
            fragment.getDataList().addAll(model.getJobRateDataList(bean));
        }
    }


    /**
     * 一个回调接口，当pickerView
     */
    public interface OnPickerViewChoosed{
        void getString(String data);
    }

    /**
     * 生成PickerView并在底部显示
     */
    @Override
    public void showPickerView(final List<String> collegeList, final OnPickerViewChoosed onPickerViewChoosed) {
         optionsPickerView = new OptionsPickerView.Builder(fragment.getActivity(), new OptionsPickerView.OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int options2, int options3, View v) {
                //返回的分别是三个级别的选中位置
                //选择回调接口
                onPickerViewChoosed.getString(collegeList.get(options1));
            }
        })
                .setLayoutRes(R.layout.special_2017_options_picker_view, new CustomListener() {
                    @Override
                    public void customLayout(View v) {
                        final TextView tvSubmit = (TextView) v.findViewById(R.id.tv_finish);
                        tvSubmit.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                optionsPickerView.returnData();
                                optionsPickerView.dismiss();
                            }
                        });

                    }
                })
                .setTextColorCenter(Color.parseColor("#FFFFFF"))
                .setBgColor(Color.parseColor("#F3F8FA"))
                .setTitleBgColor(Color.parseColor("#F3F8FA"))
                .setSubmitColor(Color.parseColor("#81C0FE"))
                .build();
        optionsPickerView.setPicker(collegeList);
        optionsPickerView.show();
    }

    @Override
    public void runChart(List<ChartData> dataList){
        if(fragment.getChart() == null) return;
        fragment.getChart().setData(dataList);
        fragment.getChart().setSpace(90);
        fragment.getChart().setSpeed(2);
        fragment.getChart().run();
    }

    /**
     * 回调
     */
    public interface OnDataLoaded{
        void finish(String msg);
    }

    @Override
    public void loadJobRateData(final String college, final OnDataLoaded onDataLoaded) {
        HttpModel.bulid().getWork()
                .flatMap(new Func1<WorkBean, Observable<WorkBean.DataBean>>() {
                    @Override
                    public Observable<WorkBean.DataBean> call(WorkBean workBean) {
                        return Observable.from(workBean.getData());
                    }
                })
                .subscribe(new Subscriber<WorkBean.DataBean>() {
                    @Override
                    public void onCompleted() {
                        onDataLoaded.finish(college);
                    }

                    @Override
                    public void onError(Throwable e) {
                        fragment.toast("获取信息失败！");
                    }

                    @Override
                    public void onNext(WorkBean.DataBean dataBean) {
                        if(dataBean.getCollege().equals(college)){
                            Log.d("Job",dataBean.getCollege());
                            setJobRateDataList(dataBean);
                        }
                    }
                });
    }
}
