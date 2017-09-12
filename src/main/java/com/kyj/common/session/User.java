 package com.kyj.common.session;
 
 import java.util.List;
 
 public class User
 {
   private String userId;
   private String userName;
   private String orgCode;
   private String orgName;
   private String orgType;
   private List<String> userRoles;
   private String lang;
 
   public String getLang()
   {
     return this.lang; }
 
   public void setLang(String lang) {
     this.lang = lang; }
 
   public String getUserId() {
     return this.userId; }
 
   public void setUserId(String userId) {
     this.userId = userId; }
 
   public String getUserName() {
     return this.userName; }
 
   public void setUserName(String userName) {
     this.userName = userName; }
 
   public String getOrgCode() {
     return this.orgCode; }
 
   public void setOrgCode(String orgCode) {
     this.orgCode = orgCode; }
 
   public String getOrgName() {
     return this.orgName; }
 
   public void setOrgName(String orgName) {
     this.orgName = orgName; }
 
   public String getOrgType() {
     return this.orgType; }
 
   public void setOrgType(String orgType) {
     this.orgType = orgType; }
 
   public List<String> getUserRoles() {
     return this.userRoles; }
 
   public void setUserRoles(List<String> userRoles) {
     this.userRoles = userRoles;
   }
 }
