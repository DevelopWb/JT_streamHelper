package com.juntai.wisdom.basecomponent.bean;

import com.google.gson.annotations.SerializedName;
import com.juntai.wisdom.basecomponent.base.BaseResult;

import java.util.List;

/**
 * @Author: tobato
 * @Description: 作用描述  搜索结果
 * @CreateDate: 2020/4/29 10:11
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/4/29 10:11
 */
public class SearchResultBean extends BaseResult {

    private List<JtZhcgCaseBean> jtZhcgCase;
    private List<UUserBean> uUser;
    private List<CameraBean> camera;

    public List<JtZhcgCaseBean> getJtZhcgCase() {
        return jtZhcgCase;
    }

    public void setJtZhcgCase(List<JtZhcgCaseBean> jtZhcgCase) {
        this.jtZhcgCase = jtZhcgCase;
    }

    public List<UUserBean> getUUser() {
        return uUser;
    }

    public void setUUser(List<UUserBean> uUser) {
        this.uUser = uUser;
    }

    public List<CameraBean> getCamera() {
        return camera;
    }

    public void setCamera(List<CameraBean> camera) {
        this.camera = camera;
    }

    public static class JtZhcgCaseBean {
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
         * id : 929
         * caseName : NJ20190122125501
         * caseCategory : 彭承艳
         * caseRegoinId : 0
         * casePlace : 山东省临沂市河东区李公街
         * caseGrid : 1
         * caseLongitude : 118.39389
         * caseLatitude : 35.082304
         * caseReporter : 董瑞斌
         * caseReportDate : 1548089701000
         * caseReportSource : 2
         * caseBigCategory : 39
         * caseSmallCategory : 42
         * casePhone : 15588059987
         * casePhotoOne : 1228
         * casePhotoTwo : 1229
         * casePhotoThree : 1230
         * caseVideo : 541
         * caseVideoPhoto : 0
         * caseHandler : 47
         * caseCaseDate : 1546745456000
         * caseContent : 赵玉彩
         * caseDeContent : 李纪华 32号楼3单元101
         * caseCaseType : 2
         * caseUpdateDate : 1550733176000
         * caseUpdateId : 47
         * caseCreateDate : 1548132901000
         * caseCreateId : 47
         * caseType : null
         * caseState : null
         * caseRemark : J03
         * nickname : 董瑞斌
         * regionName : 临沂市
         * caseFId : 723
         * cateName : 居家托养
         * serviceStaff : null
         * cateBigName : null
         * cateSmallName : null
         * uploadingYear : 2019
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
        private String caseCategory;
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
        private String caseContent;
        private String caseDeContent;
        private int caseCaseType;
        private long caseUpdateDate;
        private int caseUpdateId;
        private long caseCreateDate;
        private int caseCreateId;
        private Object caseType;
        private Object caseState;
        private String caseRemark;
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

        public String getCaseCategory() {
            return caseCategory;
        }

        public void setCaseCategory(String caseCategory) {
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

        public String getCaseContent() {
            return caseContent;
        }

        public void setCaseContent(String caseContent) {
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

        public long getCaseUpdateDate() {
            return caseUpdateDate;
        }

        public void setCaseUpdateDate(long caseUpdateDate) {
            this.caseUpdateDate = caseUpdateDate;
        }

        public int getCaseUpdateId() {
            return caseUpdateId;
        }

        public void setCaseUpdateId(int caseUpdateId) {
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

        public String getCaseRemark() {
            return caseRemark;
        }

        public void setCaseRemark(String caseRemark) {
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

    public static class UUserBean {
        /**
         * date1 : null
         * date2 : null
         * date3 : null
         * date6 : null
         * date7 : null
         * date4 : null
         * date5 : null
         * date8 : null
         * page : null
         * pageON : null
         * id : 47
         * sex : 1
         * age : 1
         * postId : 21
         * deptId : 18
         * regionId : 0
         * phone : 15588059987
         * number : 1
         * nature : 1
         * grid : 1
         * updateDate : 1587891475000
         * updateId : null
         * state : null
         * type : null
         * remarl : 1
         * registrationId : 1104a8979236720e66a
         * lng : 118.392553
         * lat : 35.062279
         * headId : 99
         * loginState : 1
         * userId : 47
         * nickname : 董瑞斌
         * email : 15588059987
         * pswd : e841e291214c4bf975ce852f38047583
         * createTime : 1542847137000
         * lastLoginTime : 1587891477000
         * status : 1
         * postName : 职务
         * depaName : 办公室
         * regionName : 临沂市
         * category : 1
         * rId : null
         */

        private Object date1;
        private Object date2;
        private Object date3;
        private Object date6;
        private Object date7;
        private Object date4;
        private Object date5;
        private Object date8;
        private Object page;
        private Object pageON;
        private int id;
        private int sex;
        private int age;
        private int postId;
        private int deptId;
        private int regionId;
        private long phone;
        private int number;
        private String nature;
        private String grid;
        private long updateDate;
        private Object updateId;
        private Object state;
        private Object type;
        private String remarl;
        private String registrationId;
        private double lng;
        private double lat;
        private int headId;
        private int loginState;
        private int userId;
        private String nickname;
        private String email;
        private String pswd;
        private long createTime;
        private long lastLoginTime;
        @SerializedName("status")
        private int statusX;
        private String postName;
        private String depaName;
        private String regionName;
        private int category;
        private Object rId;

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

        public Object getDate3() {
            return date3;
        }

        public void setDate3(Object date3) {
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

        public int getSex() {
            return sex;
        }

        public void setSex(int sex) {
            this.sex = sex;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public int getPostId() {
            return postId;
        }

        public void setPostId(int postId) {
            this.postId = postId;
        }

        public int getDeptId() {
            return deptId;
        }

        public void setDeptId(int deptId) {
            this.deptId = deptId;
        }

        public int getRegionId() {
            return regionId;
        }

        public void setRegionId(int regionId) {
            this.regionId = regionId;
        }

        public long getPhone() {
            return phone;
        }

        public void setPhone(long phone) {
            this.phone = phone;
        }

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }

        public String getNature() {
            return nature;
        }

        public void setNature(String nature) {
            this.nature = nature;
        }

        public String getGrid() {
            return grid;
        }

        public void setGrid(String grid) {
            this.grid = grid;
        }

        public long getUpdateDate() {
            return updateDate;
        }

        public void setUpdateDate(long updateDate) {
            this.updateDate = updateDate;
        }

        public Object getUpdateId() {
            return updateId;
        }

        public void setUpdateId(Object updateId) {
            this.updateId = updateId;
        }

        public Object getState() {
            return state;
        }

        public void setState(Object state) {
            this.state = state;
        }

        public Object getType() {
            return type;
        }

        public void setType(Object type) {
            this.type = type;
        }

        public String getRemarl() {
            return remarl;
        }

        public void setRemarl(String remarl) {
            this.remarl = remarl;
        }

        public String getRegistrationId() {
            return registrationId;
        }

        public void setRegistrationId(String registrationId) {
            this.registrationId = registrationId;
        }

        public double getLng() {
            return lng;
        }

        public void setLng(double lng) {
            this.lng = lng;
        }

        public double getLat() {
            return lat;
        }

        public void setLat(double lat) {
            this.lat = lat;
        }

        public int getHeadId() {
            return headId;
        }

        public void setHeadId(int headId) {
            this.headId = headId;
        }

        public int getLoginState() {
            return loginState;
        }

        public void setLoginState(int loginState) {
            this.loginState = loginState;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPswd() {
            return pswd;
        }

        public void setPswd(String pswd) {
            this.pswd = pswd;
        }

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

        public long getLastLoginTime() {
            return lastLoginTime;
        }

        public void setLastLoginTime(long lastLoginTime) {
            this.lastLoginTime = lastLoginTime;
        }

        public int getStatusX() {
            return statusX;
        }

        public void setStatusX(int statusX) {
            this.statusX = statusX;
        }

        public String getPostName() {
            return postName;
        }

        public void setPostName(String postName) {
            this.postName = postName;
        }

        public String getDepaName() {
            return depaName;
        }

        public void setDepaName(String depaName) {
            this.depaName = depaName;
        }

        public String getRegionName() {
            return regionName;
        }

        public void setRegionName(String regionName) {
            this.regionName = regionName;
        }

        public int getCategory() {
            return category;
        }

        public void setCategory(int category) {
            this.category = category;
        }

        public Object getRId() {
            return rId;
        }

        public void setRId(Object rId) {
            this.rId = rId;
        }
    }

    public static class CameraBean {
        /**
         * date1 : null
         * date2 : null
         * date3 : null
         * date6 : null
         * date7 : null
         * date4 : null
         * date5 : null
         * date8 : null
         * page : null
         * pageON : null
         * cameraId : 67
         * cameraNum : 638187229
         * cameraLongitude : 118.366779
         * cameraLatitude : 35.077585
         * regoinId : 1
         * cameraCreateDate : null
         * cameraCreateId : null
         * cameraUpdateDate : null
         * cameraUpdateId : null
         * cameraType : 1
         * cameraState : 1
         * cameraRemark : 沂河隧道广场远眺电视塔
         * regionName : 兰山区
         * cameraValidatecode : null
         * cameraPassageway : 1
         * cameraPlace : 山东省临沂市兰山区三河口隧道
         * cameraHlshd : http://hls01open.ys7.com/openlive/9243b5aba21c455c86c40407b510b9b0.hd.m3u8
         * cameraRtmphd : rtmp://rtmp01open.ys7.com/openlive/9243b5aba21c455c86c40407b510b9b0.hd
         * cameraEzopen : https://statics.ys7.com/device/assets/imgs/public/homeDevice.jpeg
         * cameraAccount : null
         * cameraImg : null
         * cameraMaccount : 10
         * account : 13656419301
         */

        private Object date1;
        private Object date2;
        private Object date3;
        private Object date6;
        private Object date7;
        private Object date4;
        private Object date5;
        private Object date8;
        private Object page;
        private Object pageON;
        private int cameraId;
        private String cameraNum;
        private double cameraLongitude;
        private double cameraLatitude;
        private int regoinId;
        private Object cameraCreateDate;
        private Object cameraCreateId;
        private Object cameraUpdateDate;
        private Object cameraUpdateId;
        private String cameraType;
        private int cameraState;
        private String cameraRemark;
        private String regionName;
        private Object cameraValidatecode;
        private int cameraPassageway;
        private String cameraPlace;
        private String cameraHlshd;
        private String cameraRtmphd;
        private String cameraEzopen;
        private Object cameraAccount;
        private Object cameraImg;
        private int cameraMaccount;
        private String account;

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

        public Object getDate3() {
            return date3;
        }

        public void setDate3(Object date3) {
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

        public int getCameraId() {
            return cameraId;
        }

        public void setCameraId(int cameraId) {
            this.cameraId = cameraId;
        }

        public String getCameraNum() {
            return cameraNum;
        }

        public void setCameraNum(String cameraNum) {
            this.cameraNum = cameraNum;
        }

        public double getCameraLongitude() {
            return cameraLongitude;
        }

        public void setCameraLongitude(double cameraLongitude) {
            this.cameraLongitude = cameraLongitude;
        }

        public double getCameraLatitude() {
            return cameraLatitude;
        }

        public void setCameraLatitude(double cameraLatitude) {
            this.cameraLatitude = cameraLatitude;
        }

        public int getRegoinId() {
            return regoinId;
        }

        public void setRegoinId(int regoinId) {
            this.regoinId = regoinId;
        }

        public Object getCameraCreateDate() {
            return cameraCreateDate;
        }

        public void setCameraCreateDate(Object cameraCreateDate) {
            this.cameraCreateDate = cameraCreateDate;
        }

        public Object getCameraCreateId() {
            return cameraCreateId;
        }

        public void setCameraCreateId(Object cameraCreateId) {
            this.cameraCreateId = cameraCreateId;
        }

        public Object getCameraUpdateDate() {
            return cameraUpdateDate;
        }

        public void setCameraUpdateDate(Object cameraUpdateDate) {
            this.cameraUpdateDate = cameraUpdateDate;
        }

        public Object getCameraUpdateId() {
            return cameraUpdateId;
        }

        public void setCameraUpdateId(Object cameraUpdateId) {
            this.cameraUpdateId = cameraUpdateId;
        }

        public String getCameraType() {
            return cameraType;
        }

        public void setCameraType(String cameraType) {
            this.cameraType = cameraType;
        }

        public int getCameraState() {
            return cameraState;
        }

        public void setCameraState(int cameraState) {
            this.cameraState = cameraState;
        }

        public String getCameraRemark() {
            return cameraRemark;
        }

        public void setCameraRemark(String cameraRemark) {
            this.cameraRemark = cameraRemark;
        }

        public String getRegionName() {
            return regionName;
        }

        public void setRegionName(String regionName) {
            this.regionName = regionName;
        }

        public Object getCameraValidatecode() {
            return cameraValidatecode;
        }

        public void setCameraValidatecode(Object cameraValidatecode) {
            this.cameraValidatecode = cameraValidatecode;
        }

        public int getCameraPassageway() {
            return cameraPassageway;
        }

        public void setCameraPassageway(int cameraPassageway) {
            this.cameraPassageway = cameraPassageway;
        }

        public String getCameraPlace() {
            return cameraPlace;
        }

        public void setCameraPlace(String cameraPlace) {
            this.cameraPlace = cameraPlace;
        }

        public String getCameraHlshd() {
            return cameraHlshd;
        }

        public void setCameraHlshd(String cameraHlshd) {
            this.cameraHlshd = cameraHlshd;
        }

        public String getCameraRtmphd() {
            return cameraRtmphd;
        }

        public void setCameraRtmphd(String cameraRtmphd) {
            this.cameraRtmphd = cameraRtmphd;
        }

        public String getCameraEzopen() {
            return cameraEzopen;
        }

        public void setCameraEzopen(String cameraEzopen) {
            this.cameraEzopen = cameraEzopen;
        }

        public Object getCameraAccount() {
            return cameraAccount;
        }

        public void setCameraAccount(Object cameraAccount) {
            this.cameraAccount = cameraAccount;
        }

        public Object getCameraImg() {
            return cameraImg;
        }

        public void setCameraImg(Object cameraImg) {
            this.cameraImg = cameraImg;
        }

        public int getCameraMaccount() {
            return cameraMaccount;
        }

        public void setCameraMaccount(int cameraMaccount) {
            this.cameraMaccount = cameraMaccount;
        }

        public String getAccount() {
            return account;
        }

        public void setAccount(String account) {
            this.account = account;
        }
    }
}
