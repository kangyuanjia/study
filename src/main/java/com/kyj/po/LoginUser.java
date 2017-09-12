package com.kyj.po;

import java.util.Date;

public class LoginUser {
    private String userId;

    private String userName;

    private Date startDate;

    private Date endDate;

    private String userPwd;

    private Integer pwdInitFlag;

    private String userHis1Pwd;

    private String userHis2Pwd;

    private String userHis3Pwd;

    private Date pwdSetTime;

    private Integer pwdResetDays;

    private Integer pwdResetFlag;

    private Integer userStatus;

    private Integer userType;

    private String personId;

    private String orgId;

    private String positionId;

    private Date createTime;

    private Date updateTime;

    private String operator;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd == null ? null : userPwd.trim();
    }

    public Integer getPwdInitFlag() {
        return pwdInitFlag;
    }

    public void setPwdInitFlag(Integer pwdInitFlag) {
        this.pwdInitFlag = pwdInitFlag;
    }

    public String getUserHis1Pwd() {
        return userHis1Pwd;
    }

    public void setUserHis1Pwd(String userHis1Pwd) {
        this.userHis1Pwd = userHis1Pwd == null ? null : userHis1Pwd.trim();
    }

    public String getUserHis2Pwd() {
        return userHis2Pwd;
    }

    public void setUserHis2Pwd(String userHis2Pwd) {
        this.userHis2Pwd = userHis2Pwd == null ? null : userHis2Pwd.trim();
    }

    public String getUserHis3Pwd() {
        return userHis3Pwd;
    }

    public void setUserHis3Pwd(String userHis3Pwd) {
        this.userHis3Pwd = userHis3Pwd == null ? null : userHis3Pwd.trim();
    }

    public Date getPwdSetTime() {
        return pwdSetTime;
    }

    public void setPwdSetTime(Date pwdSetTime) {
        this.pwdSetTime = pwdSetTime;
    }

    public Integer getPwdResetDays() {
        return pwdResetDays;
    }

    public void setPwdResetDays(Integer pwdResetDays) {
        this.pwdResetDays = pwdResetDays;
    }

    public Integer getPwdResetFlag() {
        return pwdResetFlag;
    }

    public void setPwdResetFlag(Integer pwdResetFlag) {
        this.pwdResetFlag = pwdResetFlag;
    }

    public Integer getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId == null ? null : personId.trim();
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId == null ? null : orgId.trim();
    }

    public String getPositionId() {
        return positionId;
    }

    public void setPositionId(String positionId) {
        this.positionId = positionId == null ? null : positionId.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }
}