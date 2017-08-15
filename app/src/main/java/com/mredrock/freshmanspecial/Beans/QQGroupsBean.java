package com.mredrock.freshmanspecial.Beans;

import java.util.List;

/**
 * Created by zxzhu on 2017/8/6.
 */

public class QQGroupsBean {

    /**
     * Status : 200
     * Info : success
     * Version : 1.0
     * Data : {"homeland":[{"GroupName":"贵州","Number":"601631814"},{"GroupName":"江苏","Number":"123736116"},{"GroupName":"山西","Number":"119738941"},{"GroupName":"福建","Number":"623621146"},{"GroupName":"安徽","Number":"558183547"},{"GroupName":"陕西","Number":"193388613"},{"GroupName":"广东","Number":"113179139"},{"GroupName":"辽宁","Number":"134489031"},{"GroupName":"海南","Number":"9334029"},{"GroupName":"贵州","Number":"601631814"},{"GroupName":"吉林","Number":"118060379"},{"GroupName":"浙江","Number":"247010642"},{"GroupName":"宁夏","Number":"319432002"},{"GroupName":"湖南","Number":"204491110"},{"GroupName":"天津","Number":"8690505"},{"GroupName":"湖北","Number":"33861584"},{"GroupName":"山东","Number":"384043802"},{"GroupName":"河北","Number":"644348638"},{"GroupName":"四川","Number":"142604890"},{"GroupName":"江西","Number":"476426072"},{"GroupName":"黑龙江","Number":"316348915"},{"GroupName":"河南","Number":"603517442"},{"GroupName":"云南宣威","Number":"211910023"},{"GroupName":"云南玉溪","Number":"256581906"},{"GroupName":"云南曲靖","Number":"117499346"},{"GroupName":"广西贵港","Number":"5819894"},{"GroupName":"广东韶山","Number":"66484867"},{"GroupName":"广东惠州","Number":"213337022"},{"GroupName":"四川成都","Number":"298299346"},{"GroupName":"四川自贡","Number":"444020511"},{"GroupName":"四川绵阳","Number":"191653502"},{"GroupName":"四川眉山","Number":"273968035"},{"GroupName":"武隆","Number":"123122421"},{"GroupName":"涪陵","Number":"199748999"},{"GroupName":"梁平","Number":"85423833"},{"GroupName":"璧山","Number":"112571803"},{"GroupName":"綦江","Number":"109665788"},{"GroupName":"巫溪","Number":"143884210"},{"GroupName":"云阳","Number":"118971621"},{"GroupName":"长寿","Number":"594337683"},{"GroupName":"开州","Number":"5657168"},{"GroupName":"南川","Number":"423494314"},{"GroupName":"彭水","Number":"283978475"},{"GroupName":"石柱","Number":"289615375"},{"GroupName":"丰都","Number":"343292119"},{"GroupName":"永川","Number":"467050041"},{"GroupName":"大足","Number":"462534986"},{"GroupName":"铜梁","Number":"198472776"},{"GroupName":"忠县","Number":"115637967"},{"GroupName":"奉节","Number":"50078959"},{"GroupName":"黔江","Number":"102897346"}],"college":[{"GroupName":"通信与信息工程学院","Number":"498167991"},{"GroupName":"计算机与科学技术学院","Number":"638612170"},{"GroupName":"自动化学院","Number":"574872113"},{"GroupName":"光电学院国际半导体学院","Number":"636449199"},{"GroupName":"外国语学院","Number":"333094013"},{"GroupName":"传媒艺术学院","Number":"527468298"},{"GroupName":"编导","Number":"621039140"},{"GroupName":"2017级重邮编导交流群","Number":"277821038"},{"GroupName":"生物学院","Number":"637402699"},{"GroupName":"生物2017级新生群","Number":"654028289"},{"GroupName":"信管","Number":"362192309"},{"GroupName":"经济管理学院","Number":"545772871"},{"GroupName":"工程管理","Number":"552540368"},{"GroupName":"软件工程学院","Number":"482656306"},{"GroupName":"安法学院院学生会认证官方新生群","Number":"162240404"},{"GroupName":"安法学院新生群","Number":"615223073"},{"GroupName":"理学院","Number":"575159267"},{"GroupName":"体育学院","Number":"649510732"},{"GroupName":"国际学院","Number":"17443276"},{"GroupName":"先进制造学院","Number":"563565394"}]}
     */

    private int Status;
    private String Info;
    private String Version;
    private DataBean Data;

    public int getStatus() {
        return Status;
    }

    public void setStatus(int Status) {
        this.Status = Status;
    }

    public String getInfo() {
        return Info;
    }

    public void setInfo(String Info) {
        this.Info = Info;
    }

    public String getVersion() {
        return Version;
    }

    public void setVersion(String Version) {
        this.Version = Version;
    }

    public DataBean getData() {
        return Data;
    }

    public void setData(DataBean Data) {
        this.Data = Data;
    }

    public static class DataBean {
        private List<HomelandBean> homeland;
        private List<CollegeBean> college;

        public List<HomelandBean> getHomeland() {
            return homeland;
        }

        public void setHomeland(List<HomelandBean> homeland) {
            this.homeland = homeland;
        }

        public List<CollegeBean> getCollege() {
            return college;
        }

        public void setCollege(List<CollegeBean> college) {
            this.college = college;
        }

        public static class HomelandBean {
            /**
             * GroupName : 贵州
             * Number : 601631814
             */

            private String GroupName;
            private String Number;

            public String getGroupName() {
                return GroupName;
            }

            public void setGroupName(String GroupName) {
                this.GroupName = GroupName;
            }

            public String getNumber() {
                return Number;
            }

            public void setNumber(String Number) {
                this.Number = Number;
            }
        }

        public static class CollegeBean {
            /**
             * GroupName : 通信与信息工程学院
             * Number : 498167991
             */

            private String GroupName;
            private String Number;

            public String getGroupName() {
                return GroupName;
            }

            public void setGroupName(String GroupName) {
                this.GroupName = GroupName;
            }

            public String getNumber() {
                return Number;
            }

            public void setNumber(String Number) {
                this.Number = Number;
            }
        }
    }
}
