package com.kyj.po;

public class EchartTest2 {
    private Integer id;

    private String sysName;

    private String accessDate;

    private Integer accessTotal;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSysName() {
        return sysName;
    }

    public void setSysName(String sysName) {
        this.sysName = sysName == null ? null : sysName.trim();
    }

    public String getAccessDate() {
        return accessDate;
    }

    public void setAccessDate(String accessDate) {
        this.accessDate = accessDate == null ? null : accessDate.trim();
    }

    public Integer getAccessTotal() {
        return accessTotal;
    }

    public void setAccessTotal(Integer accessTotal) {
        this.accessTotal = accessTotal;
    }
}