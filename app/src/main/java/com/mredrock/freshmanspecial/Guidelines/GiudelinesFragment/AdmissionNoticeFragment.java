package com.mredrock.freshmanspecial.Guidelines.GiudelinesFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mredrock.freshmanspecial.Beans.AdmissionBean;
import com.mredrock.freshmanspecial.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Glossimar on 2017/8/3.
 * 专题 ： 邮子攻略
 * 界面 ： 邮子攻略-入学须知
 */

public class AdmissionNoticeFragment extends Fragment{
    private List<AdmissionBean> admissionBeanList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.special_2017_fragment_admission, container, false);
        initData();
        return view;
    }

    public void initData() {
        admissionBeanList = new ArrayList<>();
        addAdmission("新生清单","1.报道时间：本科新生2017年9月14、15日报道\n" +
                "2.报道地点：重庆邮电大学风雨操场\n" +
                "3.新生必带：\t自带同版近期照片共15张（要求光面相纸洗印，白底一寸，半神，正脸，免冠大头照片），新生档案，党团关系证明，户口本（需要迁户口的同学携带），录取通知书，高考准考证，身份证以及身份证（复印件多复印几份，多复印几份，虽然学校并未做要求）\n" +
                "，银行卡（缴学费）,少量现金。\n" +
                "\n" +
                "4.洗 护 用 品 ：男生的剃须刀，女生的护肤品（男生也可以适当准备一些），日常洗漱需要的物品（诸如牙膏牙刷，毛巾，沐浴露，盆桶一以及洗衣物所需要的洗衣液，刷子等等。\n" +
                "\n" +
                "5.衣 物 方 面：四季的外套、袜子等等（要是重庆本地的同学或者是经常回家的同学非当季的衣物可以不用携带），各种四晾衣物的工具（如衣叉，衣架等等）。蚊帐（根据个人喜好，也可以采用驱蚊液，这样就可以不挂蚊帐），一些基本的床上用品（枕头，被子等，被单最好准备两张，枕套同样如此），凉席（有了空调你也许会忘掉它），遮光帘（根据个人情况，要是对灯光比较敏感，建议准备），一些日常使用的药品（感冒药，创可贴之类的），台灯，还有各类寝室神器（这些就根据自己的实际需要进行添置）。\n" +
                "\n" +
                "6.个人物品：\n" +
                "电脑（笔记本最宜，其他的数码产品根据自己的情况进行添置），以及一些学习物品（签字笔，笔记本等等），台灯，水杯等等。\n");

        addAdmission("安全守则", "1.  防止上当受骗。一些不法分子利用新生刚入学不熟悉的情况，以老师，学长或者老乡的身份骗取新生信任，然后以代\n" +
                "费、减免学费等多种方式进行诈骗。\n" +
                "2.  不携带过多现金。数额较大的现金应该及时存入银行，存折、银行卡、身份证尽量分开放；使用银行卡要谨慎以防密\n" +
                "码泄露。\n" +
                "3.  拒绝上门推销。许多不法分子以到寝室推销为名进行诈骗或盗窃，如若发现上门推销人员，应该及时报告宿管人员或者\n" +
                "保卫处。\n" +
                "4.  室内注意防盗。要保管好自己的笔记本电脑、手机等贵重物品，不要将其随意放置，以免被“顺手牵羊”。\n" +
                "5.  注意消防安全。爱护消防设施，寝室内不违章使用大功率电器。\n" +
                "6.  注意交通安全。不乘坐“黑车”和存在安全隐患的车辆\n" +
                "7.  遇到情况及时与公安机关联系。在遇到不法侵害时，要及时与公安机关（110）或者学校保卫处联系（62461018,62460110）\n");
        addAdmission("乘车路线", "迎新接站：\n" +
                "报道期间，我校将在重庆火车北站南、北广场设新生接待站，有同学负责引导新生到指定地点乘车\n" +
                "\n" +
                "重庆江北机场（距离学校约40公里）：\n" +
                "可乘机场大巴至上清寺后转乘108路公交车至南坪，再转乘346或347路公交车到学校；或乘轻轨三号线到南坪，再转乘346或347路公交车到学校；直接打车到校费用约为70元；\n" +
                "\n" +
                "龙头寺火车站、重庆北站（距离学校约20公里）：\n" +
                "乘323路或168路公交车至南坪，转乘346或347路公交车至学校：或乘轻轨三号线到南坪，再转乘346或347路公交\n" +
                "车到学校；直接打车到校费用约40元；\n" +
                "\n" +
                "菜园坝火车站、汽车站（距离学校约12公里）：\n" +
                "可在菜园坝广场乘347路公交车至学校；直接打车到校费用约为25元；\n" +
                "\n" +
                "朝天门码头（距离学校约9公里）：\n" +
                "可乘车至南坪后转乘346或347路公交车至学校；直接打车到校费用约为20元。\n" +
                "\n");


    }

    public void addAdmission(String title, String text) {
        AdmissionBean bean = new AdmissionBean();
        bean.text = title;
        bean.title = text;
        admissionBeanList.add(bean);
    }
}
