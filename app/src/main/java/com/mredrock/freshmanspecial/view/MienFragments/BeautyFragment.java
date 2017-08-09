package com.mredrock.freshmanspecial.view.MienFragments;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.mredrock.freshmanspecial.Beans.MienBeans.BeautyBean;
import com.mredrock.freshmanspecial.R;
import com.mredrock.freshmanspecial.Units.MyRecyclerAdapter;
import com.mredrock.freshmanspecial.Units.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zxzhu on 2017/8/4.
 */

public class BeautyFragment extends BaseFragment {
    private RecyclerView recyclerView;
    private LinearLayoutManager manager;
    @Override
    protected void initData() {
        recyclerView = $(R.id.list_beauty);
        manager = new GridLayoutManager(getActivity(), 1);
        setData();
    }

    private void setData(){
        List<BeautyBean> list = new ArrayList<>();
        BeautyBean bean1 = new BeautyBean();
        bean1.setImg(getResources().getDrawable(R.mipmap.special_2017_chongyoufengcai));
        bean1.setTitle("春日落樱");
        bean1.setContent("樱花烂漫红陌上，花开花落皆是景\n" +
                "春风暖，吹绿了重邮，朵朵樱花饱吮着雨露的滋润，与绿叶相衬，在春风的轻抚中缓缓舒展。让我们一起漫步在三月的重邮，去欣赏那些美丽的存在。\n");
        list.add(bean1);
        BeautyBean bean2 = new BeautyBean();
        bean2.setImg(getResources().getDrawable(R.mipmap.special_2017_chongyoufengcai));
        bean2.setTitle("立夏蝉鸣");
        bean2.setContent("蝉鸣午后雨红莲，日落黄昏文峰塔\n" +
                "伴着盛夏的阳光与阵阵蝉鸣，我知道，那个夏天，就像青春一样回不来。 所以，你好，再见，这是毕业的季节。\n");
        list.add(bean2);
        BeautyBean bean3 = new BeautyBean();
        bean3.setImg(getResources().getDrawable(R.mipmap.special_2017_chongyoufengcai));
        bean3.setTitle("杏染秋色");
        bean3.setContent("秋风瑟瑟杏叶飞，雾绕重邮山麓间\n" +
                "秋天，银杏叶由翠绿变得金黄，飒飒秋风，叶片如黄蝶飞舞，落到地上铺成金黄色的地毯。二教，老图，校园，秋意浓。\n");
        list.add(bean3);
        BeautyBean bean4 = new BeautyBean();
        bean4.setImg(getResources().getDrawable(R.mipmap.special_2017_chongyoufengcai));
        bean4.setTitle("冬至慕雪");
        bean4.setContent("最美纷纷南山雪，邮苑万物裹银装\n" +
                "南山的冬天，没有草木枯荣的景象，绿叶在寒风中展示着一种生命力，轻柔的雪花悠悠地飘落，形成白绿相映的美景。\n");
        list.add(bean1);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(new MyRecyclerAdapter(getActivity(),list,MyRecyclerAdapter.BEAUTY));
    }

    @Override
    protected int getResourceId() {
        return R.layout.special_2017_fragment_beauty;
    }
}
