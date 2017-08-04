package com.mredrock.freshmanspecial.view.dataFragments;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.bigkoo.pickerview.OptionsPickerView;
import com.bigkoo.pickerview.listener.CustomListener;
import com.mredrock.freshmanspecial.R;
import com.mredrock.freshmanspecial.Units.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;


public class SexRateFragment extends BaseFragment {

    private Button button;
    private OptionsPickerView optionsPickerView;
    private List<String> list;

    @Override
    protected void initData() {
        button = $(R.id.sexRate_button);
        list = new ArrayList<>();
        list.add("jisuanji");
        list.add("zidonghua");
        list.add("tongxin");
        list.add("chuanmei");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("123","click");
                optionsPickerView = new OptionsPickerView.Builder(getContext(), new OptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int options2, int options3, View v) {
                        //返回的分别是三个级别的选中位置
                        //选择回调接口
                        String tx = list.get(options1);
                        Log.d("123",tx);
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
                optionsPickerView.setPicker(list);
                optionsPickerView.show();
            }
        });
    }

    @Override
    protected int getResourceId() {
        return R.layout.special_2017_fragment_sex_rate;
    }
}
