package com.mredrock.freshmanspecial.view.MienFragments;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.mredrock.freshmanspecial.Beans.MienBeans.ExcellentBean;
import com.mredrock.freshmanspecial.R;
import com.mredrock.freshmanspecial.Units.MyRecyclerAdapter;
import com.mredrock.freshmanspecial.Units.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zxzhu on 2017/8/8.
 */

public class StudentFragment extends BaseFragment {
    private RecyclerView recyclerView;
    private LinearLayoutManager manager;
    private List<ExcellentBean> list;

    @Override
    protected void initData() {
        recyclerView = $(R.id.list_student);
        manager = new GridLayoutManager(getActivity(), 1);
        list = new ArrayList<>();
        setData();

    }

    private void setData() {
        ExcellentBean student1 = new ExcellentBean();
        student1.setImg(getResources().getDrawable(R.mipmap.special_2017_chongyoufengcai));
        student1.setName("丛广林");
        student1.setContent("颁奖词：重邮小帮手背后的技术好能手，用创意传递团思党意；红岩网校里辛勤的代码探索者，用产品激活青春正能量。用原创游戏贴近同学，建专题网站打造主流，带技能培训熔炼团队，抓宣传跟帖清朗网络。他就是将实践服务融入网络的社会主义核心价值观传播者。\n" +
                "\n" +
                "——e路有你，书写无悔青春");
        list.add(student1);
        ExcellentBean student2 = new ExcellentBean();
        student2.setImg(getResources().getDrawable(R.mipmap.special_2017_chongyoufengcai));
        student2.setName("刘志宗");
        student2.setContent("颁奖词：艰辛坎坷的生活中，他勇于担当，挑起家庭重担，用奖助学金及兼职收入补贴家用；追逐梦想的道路上，他自信自强，以优异的成绩保送重大。怀瑾握瑜，精心照顾三位重症家人；被褐怀珠，用坚韧的信念改写人生。以坚强、责任与孝道感染众人，他是重邮学子的道德楷模。\n" +
                "\n" +
                "——逐梦，为更好的自己");
        list.add(student2);
        ExcellentBean student3 = new ExcellentBean();
        student3.setImg(getResources().getDrawable(R.mipmap.special_2017_chongyoufengcai));
        student3.setName("冯益青");
        student3.setContent("颁奖词：两次国家奖学金、学业绩点3.8、必修课平均分91.1分是她三年学业的骄人成绩；美国数模竞赛特等奖（最高奖）、全国英语竞赛特等奖等6项省部级以上奖项，是她课外竞赛的累累硕果；50余小时的“云互助”朋辈辅导授课，共同进步的寝室氛围营造，是她乐于奉献的真实写照。她是一个求真知、重实践、讲奉献，努力筑梦青春的全能学子。\n" +
                "\n" +
                "——全面发展行路远，心底无私天地宽");
        list.add(student3);
        ExcellentBean student4 = new ExcellentBean();
        student4.setImg(getResources().getDrawable(R.mipmap.special_2017_chongyoufengcai));
        student4.setName("刘慧鹏");
        student4.setContent("颁奖词：他心中有一片海，虽布满漩涡与礁石，但前行时目光笃定。知识是船身，夯实科创基础；思想是罗盘，指引前行方向；坚持是桅杆，支撑奋斗风帆。电设、数模、机器人大赛等国家级奖项4项，公开发表论文3篇，都是他航程中登上的一座座新大陆。奋力吹响科技创新的集结号，他就是科创界的弄潮儿。\n" +
                "\n" +
                "——科研创新炼真金，风浪搏击显本色");
        list.add(student4);
        ExcellentBean student5 = new ExcellentBean();
        student5.setImg(getResources().getDrawable(R.mipmap.special_2017_chongyoufengcai));
        student5.setName("郭鑫");
        student5.setContent("颁奖词：他是创趣异站创始人，重庆森蓝戈科技有限公司总经理，VIPC创业团队组建者。创业路上他一度艰难前行，蹲马路，参路演，拉投资，无所畏惧。创业艰辛也不忘反哺母校，带领百余学弟学妹踏上“双创”征程。他的先进事迹荣登《光明日报》，他就是以创新创造价值的重邮创客。\n" +
                "\n" +
                "——创新是为了产生实际价值");
        list.add(student5);
        ExcellentBean student6 = new ExcellentBean();
        student6.setImg(getResources().getDrawable(R.mipmap.special_2017_chongyoufengcai));
        student6.setName("马晨歌");
        student6.setContent("颁奖词：他以梦为马，从阳光校广走向全国舞台，用声音抒发满腔热忱；他如沐晨曦，从重邮校园跳向全能国标，以舞步谱写艺术篇章；他人生当歌，从青春梦想迈向腾讯事业，将旋律唱进明媚未来。主持、舞蹈、歌唱，他是因执着而让梦想熠熠闪光的文艺工科男。\n" +
                "\n" +
                "——悠悠歌声伴我心,信息科创任我行");
        list.add(student6);
        ExcellentBean student7 = new ExcellentBean();
        student7.setImg(getResources().getDrawable(R.mipmap.special_2017_chongyoufengcai));
        student7.setName("田彬人");
        student7.setContent("颁奖词：她笔走一方纸卷，学业绩点3.8，专业排名第一，荣获国家奖学金和特等奖学金；她推演数理逻辑，数学建模屡创佳绩，校园的路灯见证了她的勤奋和坚守。大学三年，20余项荣誉，5项国家级、省部级奖项完美诠释了天道酬勤的真谛，她用最朴实的方式践行当代大学生以学为先的天职，她是重邮优良学风的践行者。\n" +
                "\n" +
                "——青春正当时，不予负流年");
        list.add(student7);
        ExcellentBean student8 = new ExcellentBean();
        student8.setImg(getResources().getDrawable(R.mipmap.special_2017_chongyoufengcai));
        student8.setName("谢贵燕");
        student8.setContent("颁奖词：19岁，她开始承担家庭重任；800元，是她每月辛苦兼职所得报酬；450小时，是她平均每月学习和工作时间。她未曾享受过宁静的大学生活，而是分秒必争地奔跑在学习和兼职的道路上。国家励志奖学金、专业排名前五是她辛勤付出的回报；传递爱心、心系公益是她回馈母校的报答。穷且益坚，她就是自立自强，永不言弃的坚毅女孩。\n" +
                "\n" +
                "——千磨万击还坚劲，任尔东西南北风");
        list.add(student8);
        ExcellentBean student9 = new ExcellentBean();
        student9.setImg(getResources().getDrawable(R.mipmap.special_2017_chongyoufengcai));
        student9.setName("20-810宿舍");
        student9.setContent("颁奖词：青春闲不住，百舸争流勤者胜；梦想在奋斗，铿锵玫瑰共进退。参加数模竞赛、申请发明专利、发表核心论文、投身志愿服务，她们用2项专利、4张录取通知书、7个100%、28项技能认证、54次荣誉奖项证明了：努力的女孩最美丽！ 她们就是携手前行的重邮四姐妹。\n" +
                "\n" +
                "——以梦为马，努力趁年华");
        list.add(student9);
        ExcellentBean student10 = new ExcellentBean();
        student10.setImg(getResources().getDrawable(R.mipmap.special_2017_chongyoufengcai));
        student10.setName("04991401班");
        student10.setContent("颁奖词：平均绩点3.0，人均科技竞赛获奖2.2次，他们是修德、博学精神的追寻者；担任社会工作114人次，志愿服务总时长1800小时，他们是求实、创新誓言的践行者。集体奖16项、个人奖223项，他们携手在三年时光里，用青春和汗水镌刻出一面 “聚似一团火，散作满天星”的集体荣誉墙。\n" +
                "\n" +
                "——让优秀成为一种习惯");
        list.add(student10);
        ExcellentBean student11 = new ExcellentBean();
        student11.setImg(getResources().getDrawable(R.mipmap.special_2017_chongyoufengcai));
        student11.setName("热则耶·吐尔洪");
        student11.setContent("简介：热则耶·吐尔洪，女，维吾尔族，中共党员，经济管理学院2012级经济学专业学生，担任学生五支部副书记、班级学习委员、寝室长。\n" +
                "\n" +
                "座右铭：单丝不成线，独木不成林！");
        list.add(student11);
        ExcellentBean student12 = new ExcellentBean();
        student12.setImg(getResources().getDrawable(R.mipmap.special_2017_chongyoufengcai));
        student12.setName("姜玉琦");
        student12.setContent("简介：姜玉琦，女，共青团员，经济管理学院2013级会计学专业学生，担任朋辈学长、学习委员。\n" +
                "\n" +
                "座右铭：Attitude is everything.");
        list.add(student12);
        ExcellentBean student13 = new ExcellentBean();
        student13.setImg(getResources().getDrawable(R.mipmap.special_2017_chongyoufengcai));
        student13.setName("谭威");
        student13.setContent("简介：谭威，男，自动化学院2014级自动化专业卓越工程师班学生。\n" +
                "\n" +
                "座右铭：天行健，君子以自强不息；地势坤，");
        list.add(student13);
        ExcellentBean student14 = new ExcellentBean();
        student14.setImg(getResources().getDrawable(R.mipmap.special_2017_chongyoufengcai));
        student14.setName("王金鸡");
        student14.setContent("简介：王金鸡，女，共青团员，传媒艺术学院2013级广播电视编导专业学生。任重庆邮电大学校史展览馆志愿者解说队队长。\n" +
                "\n" +
                "座右铭：心有多大，舞台就有多大。");
        list.add(student14);
        ExcellentBean student15 = new ExcellentBean();
        student15.setImg(getResources().getDrawable(R.mipmap.special_2017_chongyoufengcai));
        student15.setName("刘国栋");
        student15.setContent("简介：刘国栋，男，共青团员员，自动化学院2014级控制工程专业学生, 在非线性动力学与控制创新团队中从事仿人机器人相关研究，任实验室机器人方向负责人。\n" +
                "\n" +
                "座右铭：天道酬勤。");
        list.add(student15);
        ExcellentBean student16 = new ExcellentBean();
        student16.setImg(getResources().getDrawable(R.mipmap.special_2017_chongyoufengcai));
        student16.setName("刘锐");
        student16.setContent("简介：刘锐，男，共青团员，通信与信息工程学院2013级信息工程专业学生,现任“重邮e站”微+平台主编。\n" +
                "\n" +
                "座右铭：精感石没羽，岂云惮险艰。");
        list.add(student16);
        ExcellentBean student17 = new ExcellentBean();
        student17.setImg(getResources().getDrawable(R.mipmap.special_2017_chongyoufengcai));
        student17.setName("王秋毅");
        student17.setContent("简介：王秋毅，男，共产党员，自动化学院2012级物联网工程专业学生。\n" +
                "\n" +
                "座右铭：大爱无疆，小爱润物。");
        list.add(student17);
        ExcellentBean student18 = new ExcellentBean();
        student18.setImg(getResources().getDrawable(R.mipmap.special_2017_chongyoufengcai));
        student18.setName("刘志凡");
        student18.setContent("简介：刘志凡，男，共青团员，经济管理学院2012级工程管理专业学生，重庆标码旅行社有限责任公司创始人，重庆市创业家协会常委，目前该生已保送东北财经大学攻读硕士研究生。获全国性杂志《大学生》两页专题报道《刘志凡，露营我们做的深》，重庆电视台招考直通车栏目组专题报道，重庆商报整版报道《深耕高校旅游市场，大学生三月赚五万》。\n" +
                "\n" +
                "座右铭：无穷的远方，无尽的人们，都与我有关。");
        list.add(student18);
        ExcellentBean student19 = new ExcellentBean();
        student19.setImg(getResources().getDrawable(R.mipmap.special_2017_chongyoufengcai));
        student19.setName("王婷");
        student19.setContent("简介：王婷，女，共青团员，生物信息学院2013级制药工程专业学生,现任校女子排球队队长、班级生活委员。\n" +
                "\n" +
                "座右铭：坚持就是胜利！");
        list.add(student19);
        ExcellentBean student20 = new ExcellentBean();
        student20.setImg(getResources().getDrawable(R.mipmap.special_2017_chongyoufengcai));
        student20.setName("0491201班");
        student20.setContent("简介：0491201班,计算机科学与技术学院2012级计算机科学与技术专业卓越工程师班,共35人,其中中共党员11人,中共预备党员8人。\n" +
                "\n" +
                "座右铭：团结奋进、拼搏创新、计科卓一、永争第一");
        list.add(student20);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(new MyRecyclerAdapter(getActivity(), list, MyRecyclerAdapter.STUDENT));
    }

    @Override
    protected int getResourceId() {
        return R.layout.special_2017_fragment_student;
    }
}
