package com.mredrock.freshmanspecial.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.TextView;

import com.mredrock.freshmanspecial.R;
import com.mredrock.freshmanspecial.Units.BaseActivity;
import com.mredrock.freshmanspecial.presenter.IMainPresenter;
import com.mredrock.freshmanspecial.presenter.MainPresenter;

public class MainActivity extends BaseActivity{

    //使用cardView按钮，有点击波纹效果
    private CardView junxun,shuju,fengcai,gonglve;
    private IMainPresenter presenter;
    private TextView title;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new MainPresenter(this);
        setClick();
    }

    private void setClick() {
        junxun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.gotoJunxunActivity();
            }
        });
        shuju.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.gotoDataActivity();
            }
        });
        fengcai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.gotoMienActivity();
            }
        });
        gonglve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.gotoStrategyActivity();
            }
        });
    }

    @Override
    protected void initData() {
        junxun = $(R.id.main_junxun);
        shuju = $(R.id.main_shuju);
        fengcai = $(R.id.main_fengcai);
        gonglve = $(R.id.main_gonglve);
        title = $(R.id.title_text);
        title.setText("2017迎新网");
    }


    @Override
    protected int getContentViewId() {
        return R.layout.special_2017_activity_main;
    }
}
