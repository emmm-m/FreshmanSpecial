package com.mredrock.freshmanspecial.model;


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


import okhttp3.OkHttpClient;
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
    private static Retrofit retrofit;
    private static OkHttpClient.Builder httpClientBuilder = new OkHttpClient().newBuilder();
    private static Services service;
    //private Context context;


    /**
     * 获取单例
     *
     * @return
     */
    public static HttpModel bulid() {
        retrofit = new Retrofit.Builder()
                .client(httpClientBuilder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(URL)
                .build();
        service = retrofit.create(Services.class);
        return new HttpModel();
    }


    /**
     * 获取男女比例
     *
     * @param subscriber
     */
    public void getSex(Subscriber<SexBean> subscriber) {
        service.getSex("SexRatio")
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    /**
     * 获取就业率
     */
    public Observable<WorkBean> getWork() {
        return service.getWork("WorkRatio").
                subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    /**
     * 获取挂科率
     */
    public Observable<FailBean> getFail() {
        return service.getFail("FailRatio")
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    /**
     * 获取军训视频
     *
     * @return video
     */
    public Observable<JunxunvideoBeans> getJunxunvideo() {
        return service.getJunxunvideo("MilitaryTrainingVideo")
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    /**
     * 获取军训图片
     *
     * @return pic
     */
    public Observable<JunxunpicBeans> getJunxunpic() {
        return service.getJunxunpic("MilitaryTrainingPhoto")
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    /**
     * 获取QQ群
     *
     * @param subscriber
     */
    public void getQQGroups(Subscriber<QQGroupsBean> subscriber) {
        service.getQQGroups("QQGroup")
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    /**
     * 获取优秀教师
     *
     * @param subscriber
     */
    public void getTeachers(Subscriber<TeacherBean> subscriber) {
        service.getTeachers("excellentTech")
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    /**
     * 获取优秀学生
     *
     * @param subscriber
     */
    public void getStudents(Subscriber<StudentsBean> subscriber) {
        service.getStudents("excellentStu")
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    /**
     * 获取美在重邮
     *
     * @param subscriber
     */
    public void getBeauties(Subscriber<BeautyBean> subscriber) {
        service.getBeauties("beautyInCQUPT")
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    /**
     * 获取原创重邮
     * @param subscriber
     */
    public void getBOriginal(Subscriber<OriginalBean> subscriber) {
        service.getOriginal("natureCQUPT")
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }
}