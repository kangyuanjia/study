package com.kyj.po;

public class EchartMap1 {
    private String iphoneType;

    private String provName;

    private String saleTotal;
    

	public String getIphoneType() {
        return iphoneType;
    }

    public void setIphoneType(String iphoneType) {
        this.iphoneType = iphoneType == null ? null : iphoneType.trim();
    }

    public String getProvName() {
        return provName;
    }

    public void setProvName(String provName) {
        this.provName = provName == null ? null : provName.trim();
    }

    public String getSaleTotal() {
        return saleTotal;
    }

    public void setSaleTotal(String saleTotal) {
        this.saleTotal = saleTotal == null ? null : saleTotal.trim();
    }
}