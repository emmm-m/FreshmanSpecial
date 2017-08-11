package com.mredrock.freshmanspecial.Guidelines.GiudelinesFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mredrock.freshmanspecial.Beans.GuidelinesVerticalBean;
import com.mredrock.freshmanspecial.Guidelines.Adapter.VerticalRecyclerAdapter;
import com.mredrock.freshmanspecial.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Glossimar on 2017/8/3.
 * 专题 ： 邮子攻略
 * 界面 ： 邮子攻略-学生寝室
 */

public class DormitoryFragment extends Fragment {
    private List<GuidelinesVerticalBean> admissionBeanList;
    private RecyclerView recyclerView;
    private VerticalRecyclerAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.special_2017_fragment_dormitory, container, false);
        initData();
        recyclerView = (RecyclerView) view.findViewById(R.id.dormitory_recycler);
        recyclerView.setLayoutManager( new LinearLayoutManager(view.getContext()));
        adapter = new VerticalRecyclerAdapter(admissionBeanList, view.getContext());
        recyclerView.setAdapter(adapter);
        return view;
    }

    public void initData() {
        admissionBeanList = new ArrayList<>();
        addDormitory("明理苑", "（24—31,39）", "位于千喜鹤食堂正街上，可以俯瞰全校以及南山的部分美丽景色，" +
                "这里也是重邮夏天最凉爽的地方。可以坐私家车直达寝室，周围有两个超市和上铺，并且校车穿过，" +
                "每个寝室都为6人间，并设有独立卫生间，每一栋楼里面配置有洗衣机可供大家使用，应有尽有，可以尽情满足同学们的平日生活需求。");
        addDormitory("宁静苑", "（8—12，32--35）", "坐落在美丽的情人坡旁，是妹子们散心聊天约会的好去处；" +
                "篮球、网球、羽毛球这些周围球场为大家的锻炼提供了方便，与新校区紧连，周边分布有“千喜鹤”、" +
                "“延生”等食堂。宿舍基本为6人间基本情况与22-24相同且有独立的阳台、卫浴，床铺是上下铺与上床下桌的混搭，人流量很少，环境比较清静。");
        addDormitory("兴业苑", "（17--23）", "屹立于悠悠重邮高处，周边风景秀丽，分布在太极运动场周围，" +
                "周边有学校的兴业苑食堂及众多的超市、商铺，校车从这里穿过，内部均设有独立卫生间，并在一些楼层设有洗衣机供大家使用，" +
                "根据每栋宿舍不同，楼层不同分为4人间、6人间两种。4人间都是上床下铺，而6人间则是上下铺与上床下桌的混搭。");
        addDormitory("知行苑", "（1—6，15,16）", "位于中心食堂附近的1,5,6栋是学校现存最老的寝室，住宿条件比较差，" +
                "整体情况是每层楼设有公用的卫生间、洗澡间，这也就意味着每个寝室都没有独立卫生间，没有阳台。处于校园中心，" +
                "上课、生活都极其便利。但位于情人坡附近的15,16栋，是学校标准的4人间，上床下桌，配有阳台，独立卫生间。楼栋周边环境一流，" +
                "食堂与超市一应俱全，为学习生活提供不少的便利。");

    }

    public void addDormitory(String dormitoryName
            , String dormitoryNumber, String dormitoryText) {
        GuidelinesVerticalBean admissionBean = new GuidelinesVerticalBean();
        admissionBean.title = dormitoryName;
        admissionBean.dormitoryNumber = dormitoryNumber;
        admissionBean.text = dormitoryText;
        admissionBeanList.add(admissionBean);
    }
}
