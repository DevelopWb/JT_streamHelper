package com.juntai.look.bean;


import java.io.Serializable;

public class Case implements Serializable {

    private String nsname;

    private String address;
    private Double caseLongitude,caseLatitude;
    private String date;
    private String category;
    private String detail;
    private String id,fid;
    private String image1,image2,image3,video,videoCover;
    private String reporterName;
    private String reporterYear;

    public String getReporterYear() {
        return reporterYear == null ? "" : reporterYear;
    }

    public void setReporterYear(String reporterYear) {
        this.reporterYear = reporterYear == null ? "" : reporterYear;
    }

    public Case() {
    }

    public Case(String reporterYear, String nsname, String date, String address, String caseLongitude, String caseLatitude, String category, String detail, String id, String image1, String image2, String image3, String video, String videoCover, String fid) {
        this.nsname = nsname;
        this.address = address;
        this.category = category;
        this.date = date;
        this.detail = detail;
        this.fid = fid;
        this.id = id;
        this.reporterYear = reporterYear;
        this.image1 = image1;
        this.image2 = image2;
        this.image3 = image3;
        this.caseLatitude =Double.parseDouble(caseLatitude);
        this.caseLongitude = Double.parseDouble(caseLongitude);
        this.video = video;
        this.videoCover = videoCover;
        this.reporterName = "null";
    }
    public Case(String reporterYear, String nsname, String date, String address, String caseLongitude, String caseLatitude, String category, String detail, String id, String image1, String image2, String image3, String video, String videoCover, String fid, String reporterName){
        this.nsname = nsname;
        this.reporterYear = reporterYear;
        this.address = address;
        this.category = category;
        this.date = date;
        this.detail = detail;
        this.fid = fid;
        this.id = id;
        this.image1 = image1;
        this.image2 = image2;
        this.image3 = image3;
        this.caseLatitude =Double.parseDouble(caseLatitude);
        this.caseLongitude = Double.parseDouble(caseLongitude);
        this.video = video;
        this.videoCover = videoCover;
        this.reporterName = reporterName;
    }

    public String getNsname() {
        return nsname == null ? "" : nsname;
    }

    public void setNsname(String nsname) {
        this.nsname = nsname == null ? "" : nsname;
    }

    public String getAddress() {
        return address == null ? "" : address;
    }

    public void setAddress(String address) {
        this.address = address == null ? "" : address;
    }

    public Double getCaseLongitude() {
        return caseLongitude;
    }

    public void setCaseLongitude(Double caseLongitude) {
        this.caseLongitude = caseLongitude;
    }

    public Double getCaseLatitude() {
        return caseLatitude;
    }

    public void setCaseLatitude(Double caseLatitude) {
        this.caseLatitude = caseLatitude;
    }

    public String getDate() {
        return date == null ? "" : date;
    }

    public void setDate(String date) {
        this.date = date == null ? "" : date;
    }

    public String getCategory() {
        return category == null ? "" : category;
    }

    public void setCategory(String category) {
        this.category = category == null ? "" : category;
    }

    public String getDetail() {
        return detail == null ? "" : detail;
    }

    public void setDetail(String detail) {
        this.detail = detail == null ? "" : detail;
    }

    public String getId() {
        return id == null ? "" : id;
    }

    public void setId(String id) {
        this.id = id == null ? "" : id;
    }

    public String getFid() {
        return fid == null ? "" : fid;
    }

    public void setFid(String fid) {
        this.fid = fid == null ? "" : fid;
    }

    public String getImage1() {
        return image1 == null ? "" : image1;
    }

    public void setImage1(String image1) {
        this.image1 = image1 == null ? "" : image1;
    }

    public String getImage2() {
        return image2 == null ? "" : image2;
    }

    public void setImage2(String image2) {
        this.image2 = image2 == null ? "" : image2;
    }

    public String getImage3() {
        return image3 == null ? "" : image3;
    }

    public void setImage3(String image3) {
        this.image3 = image3 == null ? "" : image3;
    }

    public String getVideo() {
        return video == null ? "" : video;
    }

    public void setVideo(String video) {
        this.video = video == null ? "" : video;
    }

    public String getVideoCover() {
        return videoCover == null ? "" : videoCover;
    }

    public void setVideoCover(String videoCover) {
        this.videoCover = videoCover == null ? "" : videoCover;
    }

    public String getReporterName() {
        return reporterName == null ? "" : reporterName;
    }

    public void setReporterName(String reporterName) {
        this.reporterName = reporterName == null ? "" : reporterName;
    }
}
