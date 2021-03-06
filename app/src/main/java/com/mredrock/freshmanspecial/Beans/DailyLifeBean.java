package com.mredrock.freshmanspecial.Beans;

import java.util.List;

/**
 * Created by glossimar on 2017/8/11.
 */

public class DailyLifeBean {
    private  int Status;
    private String  Info;
    private double Version;
    private List<DailyLifeDataBean> Data;

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

    public List<DailyLifeDataBean> getData() {
        return Data;
    }

    public void setData(List<DailyLifeDataBean> data) {
        Data = data;
    }

    static public class DailyLifeDataBean {
        private String name;
        private String resume;
        private String location;
        private List<String> url;

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
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
