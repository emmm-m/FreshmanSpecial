package com.mredrock.freshmanspecial.model;

import com.mredrock.freshmanspecial.Beans.FailBean;
import com.mredrock.freshmanspecial.Beans.QQGroupsBean;
import com.mredrock.freshmanspecial.Beans.SexBean;
import com.mredrock.freshmanspecial.Beans.WorkBean;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by zxzhu on 2017/8/6.
 */

public interface Services {

    //http://www.yangruixin.com/test/apiRatio.php
    @FormUrlEncoded
    @POST("test/apiRatio.php")
    Observable<SexBean> getSex(@Field("RequestType") String requestType);

    @FormUrlEncoded
    @POST("test/apiRatio.php")
    Observable<WorkBean> getWork(@Field("RequestType") String requestType);

    @FormUrlEncoded
    @POST("test/apiRatio.php")
    Observable<QQGroupsBean> getQQGroups(@Field("RequestType") String requestType);

    @FormUrlEncoded
    @POST("test/apiRatio.php")
    Observable<FailBean> getFail(@Field("RequestType") String requestType);
}