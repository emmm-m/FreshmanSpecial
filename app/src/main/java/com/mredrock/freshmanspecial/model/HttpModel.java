package com.mredrock.freshmanspecial.model;


import com.mredrock.freshmanspecial.Beans.FailBean;
import com.mredrock.freshmanspecial.Beans.QQGroupsBean;
import com.mredrock.freshmanspecial.Beans.SexBean;
import com.mredrock.freshmanspecial.Beans.WorkBean;

import java.util.concurrent.TimeUnit;


import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by zxzhu on 2017/8/6.
 */

public class HttpModel {

    public static final String URL = "http://www.yangruixin.com/";
    private static final int DEFAULT_TIMEOUT = 5;
    private OkHttpClient.Builder httpClientBuilder = new OkHttpClient().newBuilder();
    private Retrofit retrofit;
    private Services service;
    //private Context context;


    /**
     * 获取单例
     * @return
     */
    public static HttpModel bulid(){
        return new HttpModel();
    }


    /**
     * 获取男女比例
     * @param subscriber
     */
    public void getSex(Subscriber<SexBean> subscriber){
        retrofit = new Retrofit.Builder()
                .client(httpClientBuilder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(URL)
                .build();
        service = retrofit.create(Services.class);
        service.getSex("SexRatio")
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    /**
     * 获取就业率
     */
    public Observable<WorkBean> getWork(){
        retrofit = new Retrofit.Builder()
                .client(httpClientBuilder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(URL)
                .build();
        service = retrofit.create(Services.class);
        return  service.getWork("WorkRatio").
                subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    /**
     * 获取挂科率
     * @param subscriber
     */
    public void getFail(Subscriber<FailBean> subscriber){
        retrofit = new Retrofit.Builder()
                .client(httpClientBuilder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(URL)
                .build();
        service = retrofit.create(Services.class);
        service.getFail("FailRatio")
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    /**
     * 获取QQ群
     * @param subscriber
     */
    public void getQQGroups(Subscriber<QQGroupsBean> subscriber){
        retrofit = new Retrofit.Builder()
                .client(httpClientBuilder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(URL)
                .build();
        service = retrofit.create(Services.class);
        service.getQQGroups("QQGroup")
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }
}