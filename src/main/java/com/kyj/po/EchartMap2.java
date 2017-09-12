package com.kyj.po;

public class EchartMap2 {
    private String cityName;

    private Integer shipmentTotal;

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName == null ? null : cityName.trim();
    }

    public Integer getShipmentTotal() {
        return shipmentTotal;
    }

    public void setShipmentTotal(Integer shipmentTotal) {
        this.shipmentTotal = shipmentTotal;
    }
}