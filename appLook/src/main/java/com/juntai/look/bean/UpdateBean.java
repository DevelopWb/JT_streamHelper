package com.juntai.look.bean;

import com.juntai.wisdom.basecomponent.base.BaseResult;

/**
 * @Author: tobato
 * @Description: 作用描述
 * @CreateDate: 2020/4/10 16:51
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/4/10 16:51
 */
public class UpdateBean extends BaseResult {


    /**
     * error : null
     * returnValue : null
     * list : null
     * type : null
     * data : {"id":2,"fileName":"托养宝2.0.2.apk","versionsCode":2,"versionsName":"v2.1.2","updateContent":"测试版本",
     * "downloadLink":"http://image.kb167.cn/downloadLocal/托养宝2.0.2.apk","constraintUpdate":false,
     * "gmtCreate":"2020-07-19 10:11:32"}
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 2
         * fileName : 托养宝2.0.2.apk
         * versionsCode : 2
         * versionsName : v2.1.2
         * updateContent : 测试版本
         * downloadLink : http://image.kb167.cn/downloadLocal/托养宝2.0.2.apk
         * constraintUpdate : false
         * gmtCreate : 2020-07-19 10:11:32
         */

        private int id;
        private String fileName;
        private int versionsCode;
        private String versionsName;
        private String updateContent;
        private String downloadLink;
        private boolean constraintUpdate;
        private String gmtCreate;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getFileName() {
            return fileName;
        }

        public void setFileName(String fileName) {
            this.fileName = fileName;
        }

        public int getVersionsCode() {
            return versionsCode;
        }

        public void setVersionsCode(int versionsCode) {
            this.versionsCode = versionsCode;
        }

        public String getVersionsName() {
            return versionsName;
        }

        public void setVersionsName(String versionsName) {
            this.versionsName = versionsName;
        }

        public String getUpdateContent() {
            return updateContent;
        }

        public void setUpdateContent(String updateContent) {
            this.updateContent = updateContent;
        }

        public String getDownloadLink() {
            return downloadLink;
        }

        public void setDownloadLink(String downloadLink) {
            this.downloadLink = downloadLink;
        }

        public boolean isConstraintUpdate() {
            return constraintUpdate;
        }

        public void setConstraintUpdate(boolean constraintUpdate) {
            this.constraintUpdate = constraintUpdate;
        }

        public String getGmtCreate() {
            return gmtCreate;
        }

        public void setGmtCreate(String gmtCreate) {
            this.gmtCreate = gmtCreate;
        }
    }
}
