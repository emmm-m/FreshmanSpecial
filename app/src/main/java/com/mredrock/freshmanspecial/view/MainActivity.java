package com.mredrock.freshmanspecial.view;

import android.graphics.Color;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.mredrock.freshmanspecial.R;
import com.mredrock.freshmanspecial.Units.BaseActivity;
import com.mredrock.freshmanspecial.presenter.IMainPresenter;
import com.mredrock.freshmanspecial.presenter.MainPresenter;

public class MainActivity extends BaseActivity{

    private ImageView junxun,shuju;
    private IMainPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new MainPresenter(this);
        setClick();
        setToolbar();
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
    }

    @Override
    protected void initData() {
        junxun = $(R.id.main_junxun);
        shuju = $(R.id.main_shuju);
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
