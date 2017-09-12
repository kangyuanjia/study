package com.kyj.po;

public class EchartMap4 {
    private String cityName;

    private String longitudeNum;

    private String latitudeNum;

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName == null ? null : cityName.trim();
    }

    public String getLongitudeNum() {
        return longitudeNum;
    }

    public void setLongitudeNum(String longitudeNum) {
        this.longitudeNum = longitudeNum == null ? null : longitudeNum.trim();
    }

    public String getLatitudeNum() {
        return latitudeNum;
    }

    public void setLatitudeNum(String latitudeNum) {
        this.latitudeNum = latitudeNum == null ? null : latitudeNum.trim();
    }
}