package com.mredrock.freshmanspecial.presenter;

import android.content.Context;
import android.content.Intent;

import com.mredrock.freshmanspecial.view.JunxunActivity;
import com.mredrock.freshmanspecial.view.MainActivity;
import com.mredrock.freshmanspecial.view.ShujuActivity;

/**
 * Created by zia on 17-8-3.
 */

public class MainPresenter implements IMainPresenter {

    private Context context;

    public MainPresenter(MainActivity activity){
        context = activity;
    }

    @Override
    public void gotojunxunActivity() {
        Intent intent = new Intent(context, JunxunActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void gotoshujuActivity() {
        Intent intent = new Intent(context, ShujuActivity.class);
        context.startActivity(intent);
    }
}
