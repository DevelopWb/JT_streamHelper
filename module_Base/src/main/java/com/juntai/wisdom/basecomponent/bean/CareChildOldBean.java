package com.juntai.wisdom.basecomponent.bean;

import com.juntai.wisdom.basecomponent.base.BaseResult;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: tobato
 * @Description: 作用描述
 * @CreateDate: 2020/8/8 15:42
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/8/8 15:42
 */
public class CareChildOldBean extends BaseResult {


        /**
         * data : [{"date1":null,"date2":null,"date3":"卫生清洁","date6":null,"date7":null,"date4":null,"date5":null,"date8":null,"page":null,"pageON":null,"id":3685,"caseName":"NJ20200423055546","caseCategory":null,"caseRegoinId":2,"casePlace":"中国山东省临沂市河东区人民大街中段","caseGrid":"1","caseLongitude":118.4023704,"caseLatitude":35.0885636,"caseReporter":"测试1","caseReportDate":1587635746000,"caseReportSource":"2","caseBigCategory":"39","caseSmallCategory":"42","casePhone":12345678910,"casePhotoOne":10165,"casePhotoTwo":10166,"casePhotoThree":10167,"caseVideo":3423,"caseVideoPhoto":10168,"caseHandler":66,"caseCaseDate":1587635744000,"caseContent":null,"caseDeContent":"测试","caseCaseType":2,"caseUpdateDate":null,"caseUpdateId":null,"caseCreateDate":1587635746000,"caseCreateId":66,"caseType":null,"caseState":null,"caseRemark":null,"nickname":"测试1","regionName":"河东区","caseFId":0,"cateName":"居家托养","serviceStaff":null,"cateBigName":null,"cateSmallName":null,"uploadingYear":2020},{"date1":null,"date2":null,"date3":"卫生清洁","date6":null,"date7":null,"date4":null,"date5":null,"date8":null,"page":null,"pageON":null,"id":3686,"caseName":"NJ20200423055617","caseCategory":null,"caseRegoinId":2,"casePlace":"中国山东省临沂市河东区人民大街中段","caseGrid":"1","caseLongitude":118.4023704,"caseLatitude":35.0885636,"caseReporter":"测试1","caseReportDate":1587635777000,"caseReportSource":"2","caseBigCategory":"39","caseSmallCategory":"42","casePhone":12345678910,"casePhotoOne":10169,"casePhotoTwo":10170,"casePhotoThree":10171,"caseVideo":3424,"caseVideoPhoto":10172,"caseHandler":66,"caseCaseDate":1587635744000,"caseContent":null,"caseDeContent":"测试1","caseCaseType":2,"caseUpdateDate":null,"caseUpdateId":null,"caseCreateDate":1587635777000,"caseCreateId":66,"caseType":null,"caseState":null,"caseRemark":null,"nickname":"测试1","regionName":"河东区","caseFId":3685,"cateName":"居家托养","serviceStaff":null,"cateBigName":null,"cateSmallName":null,"uploadingYear":2020},{"date1":null,"date2":null,"date3":"宣传政策","date6":null,"date7":null,"date4":null,"date5":null,"date8":null,"page":null,"pageON":null,"id":3697,"caseName":"NJ20200425041950","caseCategory":null,"caseRegoinId":2,"casePlace":"中国山东省临沂市河东区人民大街中段","caseGrid":"1","caseLongitude":118.4023704,"caseLatitude":35.0885636,"caseReporter":"测试1","caseReportDate":1587802790000,"caseReportSource":"2","caseBigCategory":"40","caseSmallCategory":"53","casePhone":12345678910,"casePhotoOne":10207,"casePhotoTwo":10208,"casePhotoThree":0,"caseVideo":3435,"caseVideoPhoto":0,"caseHandler":66,"caseCaseDate":1587635744000,"caseContent":null,"caseDeContent":"测试3","caseCaseType":2,"caseUpdateDate":null,"caseUpdateId":null,"caseCreateDate":1587802790000,"caseCreateId":66,"caseType":null,"caseState":null,"caseRemark":null,"nickname":"测试1","regionName":"河东区","caseFId":3685,"cateName":"上门走访","serviceStaff":null,"cateBigName":null,"cateSmallName":null,"uploadingYear":2020}]
         * Message : 成功
         */

        private List<DataBean> data;

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }

        public static class DataBean implements Serializable {
            /**
             * date1 : null
             * date2 : null
             * date3 : 卫生清洁
             * date6 : null
             * date7 : null
             * date4 : null
             * date5 : null
             * date8 : null
             * page : null
             * pageON : null
             * id : 3685
             * caseName : NJ20200423055546
             * caseCategory : null
             * caseRegoinId : 2
             * casePlace : 中国山东省临沂市河东区人民大街中段
             * caseGrid : 1
             * caseLongitude : 118.4023704
             * caseLatitude : 35.0885636
             * caseReporter : 测试1
             * caseReportDate : 1587635746000
             * caseReportSource : 2
             * caseBigCategory : 39
             * caseSmallCategory : 42
             * casePhone : 12345678910
             * casePhotoOne : 10165
             * casePhotoTwo : 10166
             * casePhotoThree : 10167
             * caseVideo : 3423
             * caseVideoPhoto : 10168
             * caseHandler : 66
             * caseCaseDate : 1587635744000
             * caseContent : null
             * caseDeContent : 测试
             * caseCaseType : 2
             * caseUpdateDate : null
             * caseUpdateId : null
             * caseCreateDate : 1587635746000
             * caseCreateId : 66
             * caseType : null
             * caseState : null
             * caseRemark : null
             * nickname : 测试1
             * regionName : 河东区
             * caseFId : 0
             * cateName : 居家托养
             * serviceStaff : null
             * cateBigName : null
             * cateSmallName : null
             * uploadingYear : 2020
             */

            private Object date1;
            private Object date2;
            private String date3;
            private Object date6;
            private Object date7;
            private Object date4;
            private Object date5;
            private Object date8;
            private Object page;
            private Object pageON;
            private int id;
            private String caseName;
            private Object caseCategory;
            private int caseRegoinId;
            private String casePlace;
            private String caseGrid;
            private double caseLongitude;
            private double caseLatitude;
            private String caseReporter;
            private long caseReportDate;
            private String caseReportSource;
            private String caseBigCategory;
            private String caseSmallCategory;
            private long casePhone;
            private int casePhotoOne;
            private int casePhotoTwo;
            private int casePhotoThree;
            private int caseVideo;
            private int caseVideoPhoto;
            private int caseHandler;
            private long caseCaseDate;
            private Object caseContent;
            private String caseDeContent;
            private int caseCaseType;
            private Object caseUpdateDate;
            private Object caseUpdateId;
            private long caseCreateDate;
            private int caseCreateId;
            private Object caseType;
            private Object caseState;
            private Object caseRemark;
            private String nickname;
            private String regionName;
            private int caseFId;
            private String cateName;
            private Object serviceStaff;
            private Object cateBigName;
            private Object cateSmallName;
            private int uploadingYear;

            public Object getDate1() {
                return date1;
            }

            public void setDate1(Object date1) {
                this.date1 = date1;
            }

            public Object getDate2() {
                return date2;
            }

            public void setDate2(Object date2) {
                this.date2 = date2;
            }

            public String getDate3() {
                return date3;
            }

            public void setDate3(String date3) {
                this.date3 = date3;
            }

            public Object getDate6() {
                return date6;
            }

            public void setDate6(Object date6) {
                this.date6 = date6;
            }

            public Object getDate7() {
                return date7;
            }

            public void setDate7(Object date7) {
                this.date7 = date7;
            }

            public Object getDate4() {
                return date4;
            }

            public void setDate4(Object date4) {
                this.date4 = date4;
            }

            public Object getDate5() {
                return date5;
            }

            public void setDate5(Object date5) {
                this.date5 = date5;
            }

            public Object getDate8() {
                return date8;
            }

            public void setDate8(Object date8) {
                this.date8 = date8;
            }

            public Object getPage() {
                return page;
            }

            public void setPage(Object page) {
                this.page = page;
            }

            public Object getPageON() {
                return pageON;
            }

            public void setPageON(Object pageON) {
                this.pageON = pageON;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getCaseName() {
                return caseName;
            }

            public void setCaseName(String caseName) {
                this.caseName = caseName;
            }

            public Object getCaseCategory() {
                return caseCategory;
            }

            public void setCaseCategory(Object caseCategory) {
                this.caseCategory = caseCategory;
            }

            public int getCaseRegoinId() {
                return caseRegoinId;
            }

            public void setCaseRegoinId(int caseRegoinId) {
                this.caseRegoinId = caseRegoinId;
            }

            public String getCasePlace() {
                return casePlace;
            }

            public void setCasePlace(String casePlace) {
                this.casePlace = casePlace;
            }

            public String getCaseGrid() {
                return caseGrid;
            }

            public void setCaseGrid(String caseGrid) {
                this.caseGrid = caseGrid;
            }

            public double getCaseLongitude() {
                return caseLongitude;
            }

            public void setCaseLongitude(double caseLongitude) {
                this.caseLongitude = caseLongitude;
            }

            public double getCaseLatitude() {
                return caseLatitude;
            }

            public void setCaseLatitude(double caseLatitude) {
                this.caseLatitude = caseLatitude;
            }

            public String getCaseReporter() {
                return caseReporter;
            }

            public void setCaseReporter(String caseReporter) {
                this.caseReporter = caseReporter;
            }

            public long getCaseReportDate() {
                return caseReportDate;
            }

            public void setCaseReportDate(long caseReportDate) {
                this.caseReportDate = caseReportDate;
            }

            public String getCaseReportSource() {
                return caseReportSource;
            }

            public void setCaseReportSource(String caseReportSource) {
                this.caseReportSource = caseReportSource;
            }

            public String getCaseBigCategory() {
                return caseBigCategory;
            }

            public void setCaseBigCategory(String caseBigCategory) {
                this.caseBigCategory = caseBigCategory;
            }

            public String getCaseSmallCategory() {
                return caseSmallCategory;
            }

            public void setCaseSmallCategory(String caseSmallCategory) {
                this.caseSmallCategory = caseSmallCategory;
            }

            public long getCasePhone() {
                return casePhone;
            }

            public void setCasePhone(long casePhone) {
                this.casePhone = casePhone;
            }

            public int getCasePhotoOne() {
                return casePhotoOne;
            }

            public void setCasePhotoOne(int casePhotoOne) {
                this.casePhotoOne = casePhotoOne;
            }

            public int getCasePhotoTwo() {
                return casePhotoTwo;
            }

            public void setCasePhotoTwo(int casePhotoTwo) {
                this.casePhotoTwo = casePhotoTwo;
            }

            public int getCasePhotoThree() {
                return casePhotoThree;
            }

            public void setCasePhotoThree(int casePhotoThree) {
                this.casePhotoThree = casePhotoThree;
            }

            public int getCaseVideo() {
                return caseVideo;
            }

            public void setCaseVideo(int caseVideo) {
                this.caseVideo = caseVideo;
            }

            public int getCaseVideoPhoto() {
                return caseVideoPhoto;
            }

            public void setCaseVideoPhoto(int caseVideoPhoto) {
                this.caseVideoPhoto = caseVideoPhoto;
            }

            public int getCaseHandler() {
                return caseHandler;
            }

            public void setCaseHandler(int caseHandler) {
                this.caseHandler = caseHandler;
            }

            public long getCaseCaseDate() {
                return caseCaseDate;
            }

            public void setCaseCaseDate(long caseCaseDate) {
                this.caseCaseDate = caseCaseDate;
            }

            public Object getCaseContent() {
                return caseContent;
            }

            public void setCaseContent(Object caseContent) {
                this.caseContent = caseContent;
            }

            public String getCaseDeContent() {
                return caseDeContent;
            }

            public void setCaseDeContent(String caseDeContent) {
                this.caseDeContent = caseDeContent;
            }

            public int getCaseCaseType() {
                return caseCaseType;
            }

            public void setCaseCaseType(int caseCaseType) {
                this.caseCaseType = caseCaseType;
            }

            public Object getCaseUpdateDate() {
                return caseUpdateDate;
            }

            public void setCaseUpdateDate(Object caseUpdateDate) {
                this.caseUpdateDate = caseUpdateDate;
            }

            public Object getCaseUpdateId() {
                return caseUpdateId;
            }

            public void setCaseUpdateId(Object caseUpdateId) {
                this.caseUpdateId = caseUpdateId;
            }

            public long getCaseCreateDate() {
                return caseCreateDate;
            }

            public void setCaseCreateDate(long caseCreateDate) {
                this.caseCreateDate = caseCreateDate;
            }

            public int getCaseCreateId() {
                return caseCreateId;
            }

            public void setCaseCreateId(int caseCreateId) {
                this.caseCreateId = caseCreateId;
            }

            public Object getCaseType() {
                return caseType;
            }

            public void setCaseType(Object caseType) {
                this.caseType = caseType;
            }

            public Object getCaseState() {
                return caseState;
            }

            public void setCaseState(Object caseState) {
                this.caseState = caseState;
            }

            public Object getCaseRemark() {
                return caseRemark;
            }

            public void setCaseRemark(Object caseRemark) {
                this.caseRemark = caseRemark;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public String getRegionName() {
                return regionName;
            }

            public void setRegionName(String regionName) {
                this.regionName = regionName;
            }

            public int getCaseFId() {
                return caseFId;
            }

            public void setCaseFId(int caseFId) {
                this.caseFId = caseFId;
            }

            public String getCateName() {
                return cateName;
            }

            public void setCateName(String cateName) {
                this.cateName = cateName;
            }

            public Object getServiceStaff() {
                return serviceStaff;
            }

            public void setServiceStaff(Object serviceStaff) {
                this.serviceStaff = serviceStaff;
            }

            public Object getCateBigName() {
                return cateBigName;
            }

            public void setCateBigName(Object cateBigName) {
                this.cateBigName = cateBigName;
            }

            public Object getCateSmallName() {
                return cateSmallName;
            }

            public void setCateSmallName(Object cateSmallName) {
                this.cateSmallName = cateSmallName;
            }

            public int getUploadingYear() {
                return uploadingYear;
            }

            public void setUploadingYear(int uploadingYear) {
                this.uploadingYear = uploadingYear;
            }
        }
    }
