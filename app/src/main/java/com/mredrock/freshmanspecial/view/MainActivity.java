package com.mredrock.freshmanspecial.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import com.mredrock.freshmanspecial.R;
import com.mredrock.freshmanspecial.Units.BaseActivity;
import com.mredrock.freshmanspecial.presenter.IMainPresenter;
import com.mredrock.freshmanspecial.presenter.MainPresenter;

public class MainActivity extends BaseActivity{

    //使用cardView按钮，有点击波纹效果
    private CardView junxun,shuju,fengcai,gonglve;
    private IMainPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new MainPresenter(this);
        setToolbar();
        setClick();
    }

    private void setClick() {
        junxun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.gotojunxunActivity();
            }
        });
        shuju.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.gotoshujuActivity();
            }
        });
        fengcai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //风采点击事件
            }
        });
        gonglve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //攻略点击事件
            }
        });
    }

    @Override
    protected void initData() {
        junxun = $(R.id.main_junxun);
        shuju = $(R.id.main_shuju);
        fengcai = $(R.id.main_fengcai);
        gonglve = $(R.id.main_gonglve);
    }

    private void setToolbar(){
        Toolbar toolbar = (Toolbar)findViewById(R.id.main_toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_main;
    }
}
