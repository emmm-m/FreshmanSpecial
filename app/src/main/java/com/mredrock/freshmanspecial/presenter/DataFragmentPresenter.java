package com.mredrock.freshmanspecial.presenter;

import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import com.bigkoo.pickerview.OptionsPickerView;
import com.bigkoo.pickerview.listener.CustomListener;
import com.mredrock.freshmanspecial.R;
import com.mredrock.freshmanspecial.model.DataModel;
import com.mredrock.freshmanspecial.view.dataFragments.IDataFragment;

import java.util.ArrayList;
import java.util.List;

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
    public void setSexRateDataList(String collegeName) {
        fragment.getDataList().clear();
        if(model.getSexRateDataList(collegeName) != null){
            fragment.getDataList().addAll(model.getSexRateDataList(collegeName));
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
}
