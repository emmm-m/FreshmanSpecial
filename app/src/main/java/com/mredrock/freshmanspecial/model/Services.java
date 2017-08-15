package com.mredrock.freshmanspecial.model;

import com.mredrock.freshmanspecial.Beans.CafeteriaBean;
import com.mredrock.freshmanspecial.Beans.CampusBean;
import com.mredrock.freshmanspecial.Beans.CuisineBean;
import com.mredrock.freshmanspecial.Beans.DailyLifeBean;
import com.mredrock.freshmanspecial.Beans.DormitoryBean;
import com.mredrock.freshmanspecial.Beans.FengcaiBeans.JunxunpicBeans;
import com.mredrock.freshmanspecial.Beans.FengcaiBeans.JunxunvideoBeans;
import com.mredrock.freshmanspecial.Beans.MienBeans.BeautyBean;
import com.mredrock.freshmanspecial.Beans.MienBeans.OriginalBean;
import com.mredrock.freshmanspecial.Beans.MienBeans.StudentsBean;
import com.mredrock.freshmanspecial.Beans.MienBeans.TeacherBean;
import com.mredrock.freshmanspecial.Beans.ShujuBeans.FailBean;
import com.mredrock.freshmanspecial.Beans.QQGroupsBean;
import com.mredrock.freshmanspecial.Beans.ShujuBeans.SexBean;
import com.mredrock.freshmanspecial.Beans.ShujuBeans.WorkBean;
import com.mredrock.freshmanspecial.Beans.SurroundingBeautyBean;

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
    @POST("welcome/2017/api/apiRatio.php")
    Observable<SexBean> getSex(@Field("RequestType") String requestType);

    @FormUrlEncoded
    @POST("welcome/2017/api/apiRatio.php")
    Observable<WorkBean> getWork(@Field("RequestType") String requestType);

    @FormUrlEncoded
    @POST("welcome/2017/api/apiRatio.php")
    Observable<FailBean> getFail(@Field("RequestType") String requestType);

    @GET("welcome/2017/api/apiForGuide.php")
    Observable<JunxunpicBeans> getJunxunpic(@Query("RequestType") String requestType);

    @GET("welcome/2017/api/apiForGuide.php")
    Observable<JunxunvideoBeans> getJunxunvideo(@Query("RequestType") String requestType);

    @GET("welcome/2017/api/apiForText.php")
    Observable<TeacherBean> getTeachers(@Query("RequestType") String requestType);

    @GET("welcome/2017/api/apiForText.php")
    Observable<StudentsBean> getStudents(@Query("RequestType") String requestType);

    @GET("welcome/2017/api/apiForText.php")
    Observable<BeautyBean> getBeauties(@Query("RequestType") String requestType);

    @GET("welcome/2017/api/apiForText.php")
    Observable<OriginalBean> getOriginal(@Query("RequestType") String requestType);

    //邮子攻略
    @GET("welcome/2017/api/apiForGuide.php")
    Observable<CampusBean> getCampus(@Query("RequestType") String requestType);//SchoolBuildings

    @GET("welcome/2017/api/apiForGuide.php")
    Observable<DormitoryBean> getDormitory(@Query("RequestType") String requestType);

    @GET("welcome/2017/api/apiForGuide.php")
    Observable<CafeteriaBean> getCafeteria(@Query("RequestType") String requestType);//Canteen

    @GET("welcome/2017/api/apiForGuide.php")
    Observable<QQGroupsBean> getQQGroups(@Query("RequestType") String requestType);

    @GET("welcome/2017/api/apiForGuide.php")
    Observable<DailyLifeBean> getDailyLife(@Query("RequestType") String requestType);

    @GET("welcome/2017/api/apiForGuide.php")
    Observable<CuisineBean> getCuisine(@Query("RequestType") String requestType);

    @GET("welcome/2017/api/apiForGuide.php")
    Observable<SurroundingBeautyBean> getSurroundingBeauty(@Query("RequestType") String requestType);//BeautyInNear


}