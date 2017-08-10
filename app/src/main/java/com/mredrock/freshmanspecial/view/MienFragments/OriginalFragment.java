package com.mredrock.freshmanspecial.view.MienFragments;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.mredrock.freshmanspecial.Beans.MienBeans.OriginalBean;
import com.mredrock.freshmanspecial.R;
import com.mredrock.freshmanspecial.Units.MyRecyclerAdapter;
import com.mredrock.freshmanspecial.Units.ScreenUnit;
import com.mredrock.freshmanspecial.Units.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zxzhu on 2017/8/4.
 */

public class OriginalFragment extends BaseFragment {
    private RecyclerView recyclerView;
    @Override
    protected void initData() {
        recyclerView = $(R.id.list_original);
        setRecyclerView();
    }

    private void setRecyclerView(){
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        List<OriginalBean> list = new ArrayList<>();
        recyclerView.setLayoutManager(layoutManager);
        OriginalBean bean1 = new OriginalBean();
        bean1.setTitle("《看见重邮》");
        bean1.setUrl("http://v.youku.com/v_show/id_XNzExODM3Njk2.html?from=y1.2-1-95.3.12-2.1-1-1-11-0");
        bean1.setImg(getResources().getDrawable(R.mipmap.special_2017_chongyoufengcai));
        bean1.setTime("03:45");
        list.add(bean1);
        OriginalBean bean2 = new OriginalBean();
        bean2.setTitle("《时间都去哪了》");
        bean2.setUrl("http://v.youku.com/v_show/id_XMTI2NjE0MDcwNA==.html?from=s1.8-1-1.2");
        bean2.setImg(getResources().getDrawable(R.mipmap.special_2017_chongyoufengcai));
        bean2.setTime("04:08");
        list.add(bean2);
        OriginalBean bean3 = new OriginalBean();
        bean3.setTitle("《2015重庆邮电大学宣传片》");
        bean3.setUrl("http://v.youku.com/v_show/id_XMTc1OTA2MzUzMg==.html?spm=a2h0k.8191407.0.0&from=s1.8-1-1.2");
        bean3.setImg(getResources().getDrawable(R.mipmap.special_2017_chongyoufengcai));
        bean3.setTime("12:44");
        list.add(bean3);
        OriginalBean bean4 = new OriginalBean();
        bean4.setTitle("《舌尖上的重邮第一集》");
        bean4.setUrl("http://v.youku.com/v_show/id_XNzA0MDc2ODA0.html?from=s1.8-1-1.1");
        bean4.setImg(getResources().getDrawable(R.mipmap.special_2017_chongyoufengcai));
        bean4.setTime("12:22");
        list.add(bean4);
        OriginalBean bean5 = new OriginalBean();
        bean5.setTitle("《舌尖上的重邮第二集》");
        bean5.setUrl("http://v.youku.com/v_show/id_XNDAzNzQ1MjA4.html?from=s1.8-1-1.1");
        bean5.setImg(getResources().getDrawable(R.mipmap.special_2017_chongyoufengcai));
        bean5.setTime("12:22");
        list.add(bean5);
        OriginalBean bean6 = new OriginalBean();
        bean6.setTitle("《舌尖上的重邮第三集》");
        bean6.setUrl("http://v.youku.com/v_show/id_XNDMyNTIzMzAw.html?from=s1.8-1-1.1");
        bean6.setImg(getResources().getDrawable(R.mipmap.special_2017_chongyoufengcai));
        bean6.setTime("8:53");
        list.add(bean6);
        OriginalBean bean7 = new OriginalBean();
        bean7.setTitle("《舌尖上的重邮第二季》");
        bean7.setUrl("http://v.youku.com/v_show/id_XNzIxODU1OTYw.html?from=s1.8-1-1.1");
        bean7.setImg(getResources().getDrawable(R.mipmap.special_2017_chongyoufengcai));
        bean7.setTime("20:48");
        list.add(bean7);
        OriginalBean bean8 = new OriginalBean();
        bean8.setTitle("《2016红岩网校工作站招新视频》");
        bean8.setUrl("http://v.youku.com/v_show/id_XMTcxOTM2MTc4MA==.html?spm=a2h0j.8191423.module_basic_relation.5~5!2~5~5!7~5~5~A");
        bean8.setImg(getResources().getDrawable(R.mipmap.special_2017_chongyoufengcai));
        bean8.setTime("02:50");
        list.add(bean8);
        recyclerView.setAdapter(new MyRecyclerAdapter(getActivity(),list,MyRecyclerAdapter.ORIGINAL));
    }

    @Override
    protected int getResourceId() {
        return R.layout.special_2017_fragment_original;
    }

}
