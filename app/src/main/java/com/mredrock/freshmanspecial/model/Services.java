package com.mredrock.freshmanspecial.model;

import com.mredrock.freshmanspecial.Beans.FengcaiBeans.JunxunpicBeans;
import com.mredrock.freshmanspecial.Beans.FengcaiBeans.JunxunvideoBeans;
import com.mredrock.freshmanspecial.Beans.MienBeans.BeautyBean;
import com.mredrock.freshmanspecial.Beans.MienBeans.StudentsBean;
import com.mredrock.freshmanspecial.Beans.MienBeans.TeacherBean;
import com.mredrock.freshmanspecial.Beans.ShujuBeans.FailBean;
import com.mredrock.freshmanspecial.Beans.QQGroupsBean;
import com.mredrock.freshmanspecial.Beans.ShujuBeans.SexBean;
import com.mredrock.freshmanspecial.Beans.ShujuBeans.WorkBean;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
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

    @GET("test/apiForGuide.php")
    Observable<JunxunpicBeans> getJunxunpic(@Query("RequestType") String requestType);

    @GET("test/apiForGuide.php")
    Observable<JunxunvideoBeans> getJunxunvideo(@Query("RequestType") String requestType);

    @GET("test/apiForText.php")
    Observable<TeacherBean> getTeachers(@Query("RequestType") String requestType);

    @GET("test/apiForText.php")
    Observable<StudentsBean> getStudents(@Query("RequestType") String requestType);

    @GET("test/apiForText.php")
    Observable<BeautyBean> getBeauties(@Query("RequestType") String requestType);
}