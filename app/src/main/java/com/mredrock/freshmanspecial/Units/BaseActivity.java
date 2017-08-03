package com.mredrock.freshmanspecial.Units;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

/**
 * Created by zxzhu on 2017/8/2.
 */

public abstract class BaseActivity extends AppCompatActivity implements com.mredrock.freshmanspecial.Units.IBaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentViewId());
        initData();
        initState();
    }


    @Override
    public void toast(final String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public Activity getActivity() {
        return this;
    }

    public void initState() {
        /*if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }*/
    }

    //用于做数据或其他初始化的方法
    protected abstract void initData();

    //获取到当前activity的view的方法
    protected abstract int getContentViewId();

    //View快捷绑定id的方法
    public <T extends View> T $(int id) {
        return (T) findViewById(id);
    }
}
