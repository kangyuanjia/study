package com.kyj.po;

public class EchartMap3 {
    private String startCity;

    private String endCity;

    private Integer shipmentTotal;

    public String getStartCity() {
        return startCity;
    }

    public void setStartCity(String startCity) {
        this.startCity = startCity == null ? null : startCity.trim();
    }

    public String getEndCity() {
        return endCity;
    }

    public void setEndCity(String endCity) {
        this.endCity = endCity == null ? null : endCity.trim();
    }

    public Integer getShipmentTotal() {
        return shipmentTotal;
    }

    public void setShipmentTotal(Integer shipmentTotal) {
        this.shipmentTotal = shipmentTotal;
    }
}