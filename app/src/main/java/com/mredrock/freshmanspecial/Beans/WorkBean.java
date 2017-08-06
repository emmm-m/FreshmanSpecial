package com.mredrock.freshmanspecial.Beans;

import com.google.gson.annotations.SerializedName;

/**
 * Created by zxzhu on 2017/8/6.
 */

public class WorkBean {
    /**
     * Status : 200
     * Info : 成功
     * Version : 1.0
     * Data : {"生物信息学院":0.9724,"传媒艺术学院":0.9647,"先进制造工程学院":0.9661,"计算机科学与技术学院":0.9613,"理学院":0.9593,"体育学院":0.9559,"光电工程学院/重庆国际半导体学院":0.9553,"软件工程学院":0.9371,"经济管理学院":0.9231,"通信与信息工程学院":0.9231,"自动化学院":0.9104,"外国语学院":0.8611,"法学院":0.7222}
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
        /**
         * 生物信息学院 : 0.9724
         * 传媒艺术学院 : 0.9647
         * 先进制造工程学院 : 0.9661
         * 计算机科学与技术学院 : 0.9613
         * 理学院 : 0.9593
         * 体育学院 : 0.9559
         * 光电工程学院/重庆国际半导体学院 : 0.9553
         * 软件工程学院 : 0.9371
         * 经济管理学院 : 0.9231
         * 通信与信息工程学院 : 0.9231
         * 自动化学院 : 0.9104
         * 外国语学院 : 0.8611
         * 法学院 : 0.7222
         */

        private double 生物信息学院;
        private double 传媒艺术学院;
        private double 先进制造工程学院;
        private double 计算机科学与技术学院;
        private double 理学院;
        private double 体育学院;
        @SerializedName("光电工程学院/重庆国际半导体学院")
        private double _$298; // FIXME check this code
        private double 软件工程学院;
        private double 经济管理学院;
        private double 通信与信息工程学院;
        private double 自动化学院;
        private double 外国语学院;
        private double 法学院;

        public double get生物信息学院() {
            return 生物信息学院;
        }

        public void set生物信息学院(double 生物信息学院) {
            this.生物信息学院 = 生物信息学院;
        }

        public double get传媒艺术学院() {
            return 传媒艺术学院;
        }

        public void set传媒艺术学院(double 传媒艺术学院) {
            this.传媒艺术学院 = 传媒艺术学院;
        }

        public double get先进制造工程学院() {
            return 先进制造工程学院;
        }

        public void set先进制造工程学院(double 先进制造工程学院) {
            this.先进制造工程学院 = 先进制造工程学院;
        }

        public double get计算机科学与技术学院() {
            return 计算机科学与技术学院;
        }

        public void set计算机科学与技术学院(double 计算机科学与技术学院) {
            this.计算机科学与技术学院 = 计算机科学与技术学院;
        }

        public double get理学院() {
            return 理学院;
        }

        public void set理学院(double 理学院) {
            this.理学院 = 理学院;
        }

        public double get体育学院() {
            return 体育学院;
        }

        public void set体育学院(double 体育学院) {
            this.体育学院 = 体育学院;
        }

        public double get_$298() {
            return _$298;
        }

        public void set_$298(double _$298) {
            this._$298 = _$298;
        }

        public double get软件工程学院() {
            return 软件工程学院;
        }

        public void set软件工程学院(double 软件工程学院) {
            this.软件工程学院 = 软件工程学院;
        }

        public double get经济管理学院() {
            return 经济管理学院;
        }

        public void set经济管理学院(double 经济管理学院) {
            this.经济管理学院 = 经济管理学院;
        }

        public double get通信与信息工程学院() {
            return 通信与信息工程学院;
        }

        public void set通信与信息工程学院(double 通信与信息工程学院) {
            this.通信与信息工程学院 = 通信与信息工程学院;
        }

        public double get自动化学院() {
            return 自动化学院;
        }

        public void set自动化学院(double 自动化学院) {
            this.自动化学院 = 自动化学院;
        }

        public double get外国语学院() {
            return 外国语学院;
        }

        public void set外国语学院(double 外国语学院) {
            this.外国语学院 = 外国语学院;
        }

        public double get法学院() {
            return 法学院;
        }

        public void set法学院(double 法学院) {
            this.法学院 = 法学院;
        }
    }
}
