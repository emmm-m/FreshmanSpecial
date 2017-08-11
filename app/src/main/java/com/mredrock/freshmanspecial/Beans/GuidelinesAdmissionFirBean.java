package com.mredrock.freshmanspecial.Beans;

import java.util.List;

/**
 * Created by glossimar on 2017/8/10.
 */

public class GuidelinesAdmissionFirBean {
    private String FirstTitle;

    public String getFirstTitle() {
        return FirstTitle;
    }

    public void setFirstTitle(String firstTitle) {
        FirstTitle = firstTitle;
    }

    public List<GuidelinesAdmissionSecBean> getGuidelinesAdmissionSecBeanList() {
        return guidelinesAdmissionSecBeanList;
    }

    public void setGuidelinesAdmissionSecBeanList(List<GuidelinesAdmissionSecBean> guidelinesAdmissionSecBeanList) {
        this.guidelinesAdmissionSecBeanList = guidelinesAdmissionSecBeanList;
    }

    private List<GuidelinesAdmissionSecBean> guidelinesAdmissionSecBeanList;

    public static class GuidelinesAdmissionSecBean {
        private String SecondTitle;
        private String secondText;

        public String getSecondTitle() {
            return SecondTitle;
        }

        public void setSecondTitle(String secondTitle) {
            SecondTitle = secondTitle;
        }

        public String getSecondText() {
            return secondText;
        }

        public void setSecondText(String secondText) {
            this.secondText = secondText;
        }
    }
}
