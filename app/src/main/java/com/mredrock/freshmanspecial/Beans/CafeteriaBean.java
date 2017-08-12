package com.mredrock.freshmanspecial.Beans;

import java.util.List;

/**
 * Created by glossimar on 2017/8/11.
 */

public class CafeteriaBean {
    private  int Status;
    private String  Info;
    private double Version;
    private List<CafeteriaDataBean> Data;

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }

    public String getInfo() {
        return Info;
    }

    public void setInfo(String info) {
        Info = info;
    }

    public double getVersion() {
        return Version;
    }

    public void setVersion(double version) {
        Version = version;
    }

    public List<CafeteriaDataBean> getData() {
        return Data;
    }

    public void setData(List<CafeteriaDataBean> data) {
        Data = data;
    }

    static public class CafeteriaDataBean {
        private String name;
        private String resume;
        private List<String> url;
        private String dormitoryNumber = "";

        public String getDormitoryNumber() {
            return dormitoryNumber;
        }

        public void setDormitoryNumber(String dormitoryNumber) {
            this.dormitoryNumber = dormitoryNumber;
        }

        public String getResume() {
            return resume;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<String> getUrl() {
            return url;
        }

        public void setUrl(List<String> url) {
            this.url = url;
        }

        public void setResume(String resume) {
            this.resume = resume;
        }
    }
}
