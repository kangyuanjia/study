 package com.kyj.common.runtime;
 
 import java.util.List;
 
 public class RuntimeOperator
 {
   private String subject_id;
   private String subject_name;
   private String subject_org;
   private String subject_org_name;
   private String subject_org_type;
   private String operate_tm;
   private String operate_dt;
   private String subject_ip;
   private String lang;
   private List<String> subject_roles;
 
   public String getLang()
   {
     return this.lang; }
 
   public void setLang(String lang) {
     this.lang = lang;
   }
 
   public String getSubject_name() {
     return this.subject_name; }
 
   public void setSubject_name(String subject_name) {
     this.subject_name = subject_name; }
 
   public String getSubject_id() {
     return this.subject_id; }
 
   public String getOperate_tm() {
     return this.operate_tm; }
 
   public String getOperate_dt() {
     return this.operate_dt; }
 
   public String getSubject_ip() {
     return this.subject_ip; }
 
   public void setSubject_id(String subject_id) {
     this.subject_id = subject_id; }
 
   public void setOperate_tm(String operate_tm) {
     this.operate_tm = operate_tm; }
 
   public void setOperate_dt(String operate_dt) {
     this.operate_dt = operate_dt; }
 
   public void setSubject_ip(String subject_ip) {
     this.subject_ip = subject_ip; }
 
   public String getSubject_org() {
     return this.subject_org; }
 
   public void setSubject_org(String subject_org) {
     this.subject_org = subject_org; }
 
   public String getSubject_org_type() {
     return this.subject_org_type; }
 
   public void setSubject_org_type(String subject_org_type) {
     this.subject_org_type = subject_org_type; }
 
   public List<String> getSubject_roles() {
     return this.subject_roles; }
 
   public void setSubject_roles(List<String> subject_roles) {
     this.subject_roles = subject_roles; }
 
   public String getSubject_org_name() {
     return this.subject_org_name; }
 
   public void setSubject_org_name(String subject_org_name) {
     this.subject_org_name = subject_org_name;
   }
 }
