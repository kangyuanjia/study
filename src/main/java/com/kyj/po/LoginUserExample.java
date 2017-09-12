package com.kyj.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class LoginUserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LoginUserExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("user_id like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("user_id not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNull() {
            addCriterion("user_name is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("user_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("user_name =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("user_name <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("user_name >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_name >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("user_name <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("user_name <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("user_name like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("user_name not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("user_name in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("user_name not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("user_name between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("user_name not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andStartDateIsNull() {
            addCriterion("start_date is null");
            return (Criteria) this;
        }

        public Criteria andStartDateIsNotNull() {
            addCriterion("start_date is not null");
            return (Criteria) this;
        }

        public Criteria andStartDateEqualTo(Date value) {
            addCriterionForJDBCDate("start_date =", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("start_date <>", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateGreaterThan(Date value) {
            addCriterionForJDBCDate("start_date >", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("start_date >=", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateLessThan(Date value) {
            addCriterionForJDBCDate("start_date <", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("start_date <=", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateIn(List<Date> values) {
            addCriterionForJDBCDate("start_date in", values, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("start_date not in", values, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("start_date between", value1, value2, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("start_date not between", value1, value2, "startDate");
            return (Criteria) this;
        }

        public Criteria andEndDateIsNull() {
            addCriterion("end_date is null");
            return (Criteria) this;
        }

        public Criteria andEndDateIsNotNull() {
            addCriterion("end_date is not null");
            return (Criteria) this;
        }

        public Criteria andEndDateEqualTo(Date value) {
            addCriterionForJDBCDate("end_date =", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("end_date <>", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateGreaterThan(Date value) {
            addCriterionForJDBCDate("end_date >", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("end_date >=", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLessThan(Date value) {
            addCriterionForJDBCDate("end_date <", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("end_date <=", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateIn(List<Date> values) {
            addCriterionForJDBCDate("end_date in", values, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("end_date not in", values, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("end_date between", value1, value2, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("end_date not between", value1, value2, "endDate");
            return (Criteria) this;
        }

        public Criteria andUserPwdIsNull() {
            addCriterion("user_pwd is null");
            return (Criteria) this;
        }

        public Criteria andUserPwdIsNotNull() {
            addCriterion("user_pwd is not null");
            return (Criteria) this;
        }

        public Criteria andUserPwdEqualTo(String value) {
            addCriterion("user_pwd =", value, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdNotEqualTo(String value) {
            addCriterion("user_pwd <>", value, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdGreaterThan(String value) {
            addCriterion("user_pwd >", value, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdGreaterThanOrEqualTo(String value) {
            addCriterion("user_pwd >=", value, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdLessThan(String value) {
            addCriterion("user_pwd <", value, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdLessThanOrEqualTo(String value) {
            addCriterion("user_pwd <=", value, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdLike(String value) {
            addCriterion("user_pwd like", value, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdNotLike(String value) {
            addCriterion("user_pwd not like", value, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdIn(List<String> values) {
            addCriterion("user_pwd in", values, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdNotIn(List<String> values) {
            addCriterion("user_pwd not in", values, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdBetween(String value1, String value2) {
            addCriterion("user_pwd between", value1, value2, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdNotBetween(String value1, String value2) {
            addCriterion("user_pwd not between", value1, value2, "userPwd");
            return (Criteria) this;
        }

        public Criteria andPwdInitFlagIsNull() {
            addCriterion("pwd_init_flag is null");
            return (Criteria) this;
        }

        public Criteria andPwdInitFlagIsNotNull() {
            addCriterion("pwd_init_flag is not null");
            return (Criteria) this;
        }

        public Criteria andPwdInitFlagEqualTo(Integer value) {
            addCriterion("pwd_init_flag =", value, "pwdInitFlag");
            return (Criteria) this;
        }

        public Criteria andPwdInitFlagNotEqualTo(Integer value) {
            addCriterion("pwd_init_flag <>", value, "pwdInitFlag");
            return (Criteria) this;
        }

        public Criteria andPwdInitFlagGreaterThan(Integer value) {
            addCriterion("pwd_init_flag >", value, "pwdInitFlag");
            return (Criteria) this;
        }

        public Criteria andPwdInitFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("pwd_init_flag >=", value, "pwdInitFlag");
            return (Criteria) this;
        }

        public Criteria andPwdInitFlagLessThan(Integer value) {
            addCriterion("pwd_init_flag <", value, "pwdInitFlag");
            return (Criteria) this;
        }

        public Criteria andPwdInitFlagLessThanOrEqualTo(Integer value) {
            addCriterion("pwd_init_flag <=", value, "pwdInitFlag");
            return (Criteria) this;
        }

        public Criteria andPwdInitFlagIn(List<Integer> values) {
            addCriterion("pwd_init_flag in", values, "pwdInitFlag");
            return (Criteria) this;
        }

        public Criteria andPwdInitFlagNotIn(List<Integer> values) {
            addCriterion("pwd_init_flag not in", values, "pwdInitFlag");
            return (Criteria) this;
        }

        public Criteria andPwdInitFlagBetween(Integer value1, Integer value2) {
            addCriterion("pwd_init_flag between", value1, value2, "pwdInitFlag");
            return (Criteria) this;
        }

        public Criteria andPwdInitFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("pwd_init_flag not between", value1, value2, "pwdInitFlag");
            return (Criteria) this;
        }

        public Criteria andUserHis1PwdIsNull() {
            addCriterion("user_his1_pwd is null");
            return (Criteria) this;
        }

        public Criteria andUserHis1PwdIsNotNull() {
            addCriterion("user_his1_pwd is not null");
            return (Criteria) this;
        }

        public Criteria andUserHis1PwdEqualTo(String value) {
            addCriterion("user_his1_pwd =", value, "userHis1Pwd");
            return (Criteria) this;
        }

        public Criteria andUserHis1PwdNotEqualTo(String value) {
            addCriterion("user_his1_pwd <>", value, "userHis1Pwd");
            return (Criteria) this;
        }

        public Criteria andUserHis1PwdGreaterThan(String value) {
            addCriterion("user_his1_pwd >", value, "userHis1Pwd");
            return (Criteria) this;
        }

        public Criteria andUserHis1PwdGreaterThanOrEqualTo(String value) {
            addCriterion("user_his1_pwd >=", value, "userHis1Pwd");
            return (Criteria) this;
        }

        public Criteria andUserHis1PwdLessThan(String value) {
            addCriterion("user_his1_pwd <", value, "userHis1Pwd");
            return (Criteria) this;
        }

        public Criteria andUserHis1PwdLessThanOrEqualTo(String value) {
            addCriterion("user_his1_pwd <=", value, "userHis1Pwd");
            return (Criteria) this;
        }

        public Criteria andUserHis1PwdLike(String value) {
            addCriterion("user_his1_pwd like", value, "userHis1Pwd");
            return (Criteria) this;
        }

        public Criteria andUserHis1PwdNotLike(String value) {
            addCriterion("user_his1_pwd not like", value, "userHis1Pwd");
            return (Criteria) this;
        }

        public Criteria andUserHis1PwdIn(List<String> values) {
            addCriterion("user_his1_pwd in", values, "userHis1Pwd");
            return (Criteria) this;
        }

        public Criteria andUserHis1PwdNotIn(List<String> values) {
            addCriterion("user_his1_pwd not in", values, "userHis1Pwd");
            return (Criteria) this;
        }

        public Criteria andUserHis1PwdBetween(String value1, String value2) {
            addCriterion("user_his1_pwd between", value1, value2, "userHis1Pwd");
            return (Criteria) this;
        }

        public Criteria andUserHis1PwdNotBetween(String value1, String value2) {
            addCriterion("user_his1_pwd not between", value1, value2, "userHis1Pwd");
            return (Criteria) this;
        }

        public Criteria andUserHis2PwdIsNull() {
            addCriterion("user_his2_pwd is null");
            return (Criteria) this;
        }

        public Criteria andUserHis2PwdIsNotNull() {
            addCriterion("user_his2_pwd is not null");
            return (Criteria) this;
        }

        public Criteria andUserHis2PwdEqualTo(String value) {
            addCriterion("user_his2_pwd =", value, "userHis2Pwd");
            return (Criteria) this;
        }

        public Criteria andUserHis2PwdNotEqualTo(String value) {
            addCriterion("user_his2_pwd <>", value, "userHis2Pwd");
            return (Criteria) this;
        }

        public Criteria andUserHis2PwdGreaterThan(String value) {
            addCriterion("user_his2_pwd >", value, "userHis2Pwd");
            return (Criteria) this;
        }

        public Criteria andUserHis2PwdGreaterThanOrEqualTo(String value) {
            addCriterion("user_his2_pwd >=", value, "userHis2Pwd");
            return (Criteria) this;
        }

        public Criteria andUserHis2PwdLessThan(String value) {
            addCriterion("user_his2_pwd <", value, "userHis2Pwd");
            return (Criteria) this;
        }

        public Criteria andUserHis2PwdLessThanOrEqualTo(String value) {
            addCriterion("user_his2_pwd <=", value, "userHis2Pwd");
            return (Criteria) this;
        }

        public Criteria andUserHis2PwdLike(String value) {
            addCriterion("user_his2_pwd like", value, "userHis2Pwd");
            return (Criteria) this;
        }

        public Criteria andUserHis2PwdNotLike(String value) {
            addCriterion("user_his2_pwd not like", value, "userHis2Pwd");
            return (Criteria) this;
        }

        public Criteria andUserHis2PwdIn(List<String> values) {
            addCriterion("user_his2_pwd in", values, "userHis2Pwd");
            return (Criteria) this;
        }

        public Criteria andUserHis2PwdNotIn(List<String> values) {
            addCriterion("user_his2_pwd not in", values, "userHis2Pwd");
            return (Criteria) this;
        }

        public Criteria andUserHis2PwdBetween(String value1, String value2) {
            addCriterion("user_his2_pwd between", value1, value2, "userHis2Pwd");
            return (Criteria) this;
        }

        public Criteria andUserHis2PwdNotBetween(String value1, String value2) {
            addCriterion("user_his2_pwd not between", value1, value2, "userHis2Pwd");
            return (Criteria) this;
        }

        public Criteria andUserHis3PwdIsNull() {
            addCriterion("user_his3_pwd is null");
            return (Criteria) this;
        }

        public Criteria andUserHis3PwdIsNotNull() {
            addCriterion("user_his3_pwd is not null");
            return (Criteria) this;
        }

        public Criteria andUserHis3PwdEqualTo(String value) {
            addCriterion("user_his3_pwd =", value, "userHis3Pwd");
            return (Criteria) this;
        }

        public Criteria andUserHis3PwdNotEqualTo(String value) {
            addCriterion("user_his3_pwd <>", value, "userHis3Pwd");
            return (Criteria) this;
        }

        public Criteria andUserHis3PwdGreaterThan(String value) {
            addCriterion("user_his3_pwd >", value, "userHis3Pwd");
            return (Criteria) this;
        }

        public Criteria andUserHis3PwdGreaterThanOrEqualTo(String value) {
            addCriterion("user_his3_pwd >=", value, "userHis3Pwd");
            return (Criteria) this;
        }

        public Criteria andUserHis3PwdLessThan(String value) {
            addCriterion("user_his3_pwd <", value, "userHis3Pwd");
            return (Criteria) this;
        }

        public Criteria andUserHis3PwdLessThanOrEqualTo(String value) {
            addCriterion("user_his3_pwd <=", value, "userHis3Pwd");
            return (Criteria) this;
        }

        public Criteria andUserHis3PwdLike(String value) {
            addCriterion("user_his3_pwd like", value, "userHis3Pwd");
            return (Criteria) this;
        }

        public Criteria andUserHis3PwdNotLike(String value) {
            addCriterion("user_his3_pwd not like", value, "userHis3Pwd");
            return (Criteria) this;
        }

        public Criteria andUserHis3PwdIn(List<String> values) {
            addCriterion("user_his3_pwd in", values, "userHis3Pwd");
            return (Criteria) this;
        }

        public Criteria andUserHis3PwdNotIn(List<String> values) {
            addCriterion("user_his3_pwd not in", values, "userHis3Pwd");
            return (Criteria) this;
        }

        public Criteria andUserHis3PwdBetween(String value1, String value2) {
            addCriterion("user_his3_pwd between", value1, value2, "userHis3Pwd");
            return (Criteria) this;
        }

        public Criteria andUserHis3PwdNotBetween(String value1, String value2) {
            addCriterion("user_his3_pwd not between", value1, value2, "userHis3Pwd");
            return (Criteria) this;
        }

        public Criteria andPwdSetTimeIsNull() {
            addCriterion("pwd_set_time is null");
            return (Criteria) this;
        }

        public Criteria andPwdSetTimeIsNotNull() {
            addCriterion("pwd_set_time is not null");
            return (Criteria) this;
        }

        public Criteria andPwdSetTimeEqualTo(Date value) {
            addCriterion("pwd_set_time =", value, "pwdSetTime");
            return (Criteria) this;
        }

        public Criteria andPwdSetTimeNotEqualTo(Date value) {
            addCriterion("pwd_set_time <>", value, "pwdSetTime");
            return (Criteria) this;
        }

        public Criteria andPwdSetTimeGreaterThan(Date value) {
            addCriterion("pwd_set_time >", value, "pwdSetTime");
            return (Criteria) this;
        }

        public Criteria andPwdSetTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("pwd_set_time >=", value, "pwdSetTime");
            return (Criteria) this;
        }

        public Criteria andPwdSetTimeLessThan(Date value) {
            addCriterion("pwd_set_time <", value, "pwdSetTime");
            return (Criteria) this;
        }

        public Criteria andPwdSetTimeLessThanOrEqualTo(Date value) {
            addCriterion("pwd_set_time <=", value, "pwdSetTime");
            return (Criteria) this;
        }

        public Criteria andPwdSetTimeIn(List<Date> values) {
            addCriterion("pwd_set_time in", values, "pwdSetTime");
            return (Criteria) this;
        }

        public Criteria andPwdSetTimeNotIn(List<Date> values) {
            addCriterion("pwd_set_time not in", values, "pwdSetTime");
            return (Criteria) this;
        }

        public Criteria andPwdSetTimeBetween(Date value1, Date value2) {
            addCriterion("pwd_set_time between", value1, value2, "pwdSetTime");
            return (Criteria) this;
        }

        public Criteria andPwdSetTimeNotBetween(Date value1, Date value2) {
            addCriterion("pwd_set_time not between", value1, value2, "pwdSetTime");
            return (Criteria) this;
        }

        public Criteria andPwdResetDaysIsNull() {
            addCriterion("pwd_reset_days is null");
            return (Criteria) this;
        }

        public Criteria andPwdResetDaysIsNotNull() {
            addCriterion("pwd_reset_days is not null");
            return (Criteria) this;
        }

        public Criteria andPwdResetDaysEqualTo(Integer value) {
            addCriterion("pwd_reset_days =", value, "pwdResetDays");
            return (Criteria) this;
        }

        public Criteria andPwdResetDaysNotEqualTo(Integer value) {
            addCriterion("pwd_reset_days <>", value, "pwdResetDays");
            return (Criteria) this;
        }

        public Criteria andPwdResetDaysGreaterThan(Integer value) {
            addCriterion("pwd_reset_days >", value, "pwdResetDays");
            return (Criteria) this;
        }

        public Criteria andPwdResetDaysGreaterThanOrEqualTo(Integer value) {
            addCriterion("pwd_reset_days >=", value, "pwdResetDays");
            return (Criteria) this;
        }

        public Criteria andPwdResetDaysLessThan(Integer value) {
            addCriterion("pwd_reset_days <", value, "pwdResetDays");
            return (Criteria) this;
        }

        public Criteria andPwdResetDaysLessThanOrEqualTo(Integer value) {
            addCriterion("pwd_reset_days <=", value, "pwdResetDays");
            return (Criteria) this;
        }

        public Criteria andPwdResetDaysIn(List<Integer> values) {
            addCriterion("pwd_reset_days in", values, "pwdResetDays");
            return (Criteria) this;
        }

        public Criteria andPwdResetDaysNotIn(List<Integer> values) {
            addCriterion("pwd_reset_days not in", values, "pwdResetDays");
            return (Criteria) this;
        }

        public Criteria andPwdResetDaysBetween(Integer value1, Integer value2) {
            addCriterion("pwd_reset_days between", value1, value2, "pwdResetDays");
            return (Criteria) this;
        }

        public Criteria andPwdResetDaysNotBetween(Integer value1, Integer value2) {
            addCriterion("pwd_reset_days not between", value1, value2, "pwdResetDays");
            return (Criteria) this;
        }

        public Criteria andPwdResetFlagIsNull() {
            addCriterion("pwd_reset_flag is null");
            return (Criteria) this;
        }

        public Criteria andPwdResetFlagIsNotNull() {
            addCriterion("pwd_reset_flag is not null");
            return (Criteria) this;
        }

        public Criteria andPwdResetFlagEqualTo(Integer value) {
            addCriterion("pwd_reset_flag =", value, "pwdResetFlag");
            return (Criteria) this;
        }

        public Criteria andPwdResetFlagNotEqualTo(Integer value) {
            addCriterion("pwd_reset_flag <>", value, "pwdResetFlag");
            return (Criteria) this;
        }

        public Criteria andPwdResetFlagGreaterThan(Integer value) {
            addCriterion("pwd_reset_flag >", value, "pwdResetFlag");
            return (Criteria) this;
        }

        public Criteria andPwdResetFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("pwd_reset_flag >=", value, "pwdResetFlag");
            return (Criteria) this;
        }

        public Criteria andPwdResetFlagLessThan(Integer value) {
            addCriterion("pwd_reset_flag <", value, "pwdResetFlag");
            return (Criteria) this;
        }

        public Criteria andPwdResetFlagLessThanOrEqualTo(Integer value) {
            addCriterion("pwd_reset_flag <=", value, "pwdResetFlag");
            return (Criteria) this;
        }

        public Criteria andPwdResetFlagIn(List<Integer> values) {
            addCriterion("pwd_reset_flag in", values, "pwdResetFlag");
            return (Criteria) this;
        }

        public Criteria andPwdResetFlagNotIn(List<Integer> values) {
            addCriterion("pwd_reset_flag not in", values, "pwdResetFlag");
            return (Criteria) this;
        }

        public Criteria andPwdResetFlagBetween(Integer value1, Integer value2) {
            addCriterion("pwd_reset_flag between", value1, value2, "pwdResetFlag");
            return (Criteria) this;
        }

        public Criteria andPwdResetFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("pwd_reset_flag not between", value1, value2, "pwdResetFlag");
            return (Criteria) this;
        }

        public Criteria andUserStatusIsNull() {
            addCriterion("user_status is null");
            return (Criteria) this;
        }

        public Criteria andUserStatusIsNotNull() {
            addCriterion("user_status is not null");
            return (Criteria) this;
        }

        public Criteria andUserStatusEqualTo(Integer value) {
            addCriterion("user_status =", value, "userStatus");
            return (Criteria) this;
        }

        public Criteria andUserStatusNotEqualTo(Integer value) {
            addCriterion("user_status <>", value, "userStatus");
            return (Criteria) this;
        }

        public Criteria andUserStatusGreaterThan(Integer value) {
            addCriterion("user_status >", value, "userStatus");
            return (Criteria) this;
        }

        public Criteria andUserStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_status >=", value, "userStatus");
            return (Criteria) this;
        }

        public Criteria andUserStatusLessThan(Integer value) {
            addCriterion("user_status <", value, "userStatus");
            return (Criteria) this;
        }

        public Criteria andUserStatusLessThanOrEqualTo(Integer value) {
            addCriterion("user_status <=", value, "userStatus");
            return (Criteria) this;
        }

        public Criteria andUserStatusIn(List<Integer> values) {
            addCriterion("user_status in", values, "userStatus");
            return (Criteria) this;
        }

        public Criteria andUserStatusNotIn(List<Integer> values) {
            addCriterion("user_status not in", values, "userStatus");
            return (Criteria) this;
        }

        public Criteria andUserStatusBetween(Integer value1, Integer value2) {
            addCriterion("user_status between", value1, value2, "userStatus");
            return (Criteria) this;
        }

        public Criteria andUserStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("user_status not between", value1, value2, "userStatus");
            return (Criteria) this;
        }

        public Criteria andUserTypeIsNull() {
            addCriterion("user_type is null");
            return (Criteria) this;
        }

        public Criteria andUserTypeIsNotNull() {
            addCriterion("user_type is not null");
            return (Criteria) this;
        }

        public Criteria andUserTypeEqualTo(Integer value) {
            addCriterion("user_type =", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotEqualTo(Integer value) {
            addCriterion("user_type <>", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeGreaterThan(Integer value) {
            addCriterion("user_type >", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_type >=", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeLessThan(Integer value) {
            addCriterion("user_type <", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeLessThanOrEqualTo(Integer value) {
            addCriterion("user_type <=", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeIn(List<Integer> values) {
            addCriterion("user_type in", values, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotIn(List<Integer> values) {
            addCriterion("user_type not in", values, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeBetween(Integer value1, Integer value2) {
            addCriterion("user_type between", value1, value2, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("user_type not between", value1, value2, "userType");
            return (Criteria) this;
        }

        public Criteria andPersonIdIsNull() {
            addCriterion("person_id is null");
            return (Criteria) this;
        }

        public Criteria andPersonIdIsNotNull() {
            addCriterion("person_id is not null");
            return (Criteria) this;
        }

        public Criteria andPersonIdEqualTo(String value) {
            addCriterion("person_id =", value, "personId");
            return (Criteria) this;
        }

        public Criteria andPersonIdNotEqualTo(String value) {
            addCriterion("person_id <>", value, "personId");
            return (Criteria) this;
        }

        public Criteria andPersonIdGreaterThan(String value) {
            addCriterion("person_id >", value, "personId");
            return (Criteria) this;
        }

        public Criteria andPersonIdGreaterThanOrEqualTo(String value) {
            addCriterion("person_id >=", value, "personId");
            return (Criteria) this;
        }

        public Criteria andPersonIdLessThan(String value) {
            addCriterion("person_id <", value, "personId");
            return (Criteria) this;
        }

        public Criteria andPersonIdLessThanOrEqualTo(String value) {
            addCriterion("person_id <=", value, "personId");
            return (Criteria) this;
        }

        public Criteria andPersonIdLike(String value) {
            addCriterion("person_id like", value, "personId");
            return (Criteria) this;
        }

        public Criteria andPersonIdNotLike(String value) {
            addCriterion("person_id not like", value, "personId");
            return (Criteria) this;
        }

        public Criteria andPersonIdIn(List<String> values) {
            addCriterion("person_id in", values, "personId");
            return (Criteria) this;
        }

        public Criteria andPersonIdNotIn(List<String> values) {
            addCriterion("person_id not in", values, "personId");
            return (Criteria) this;
        }

        public Criteria andPersonIdBetween(String value1, String value2) {
            addCriterion("person_id between", value1, value2, "personId");
            return (Criteria) this;
        }

        public Criteria andPersonIdNotBetween(String value1, String value2) {
            addCriterion("person_id not between", value1, value2, "personId");
            return (Criteria) this;
        }

        public Criteria andOrgIdIsNull() {
            addCriterion("org_id is null");
            return (Criteria) this;
        }

        public Criteria andOrgIdIsNotNull() {
            addCriterion("org_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrgIdEqualTo(String value) {
            addCriterion("org_id =", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotEqualTo(String value) {
            addCriterion("org_id <>", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdGreaterThan(String value) {
            addCriterion("org_id >", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdGreaterThanOrEqualTo(String value) {
            addCriterion("org_id >=", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdLessThan(String value) {
            addCriterion("org_id <", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdLessThanOrEqualTo(String value) {
            addCriterion("org_id <=", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdLike(String value) {
            addCriterion("org_id like", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotLike(String value) {
            addCriterion("org_id not like", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdIn(List<String> values) {
            addCriterion("org_id in", values, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotIn(List<String> values) {
            addCriterion("org_id not in", values, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdBetween(String value1, String value2) {
            addCriterion("org_id between", value1, value2, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotBetween(String value1, String value2) {
            addCriterion("org_id not between", value1, value2, "orgId");
            return (Criteria) this;
        }

        public Criteria andPositionIdIsNull() {
            addCriterion("position_id is null");
            return (Criteria) this;
        }

        public Criteria andPositionIdIsNotNull() {
            addCriterion("position_id is not null");
            return (Criteria) this;
        }

        public Criteria andPositionIdEqualTo(String value) {
            addCriterion("position_id =", value, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdNotEqualTo(String value) {
            addCriterion("position_id <>", value, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdGreaterThan(String value) {
            addCriterion("position_id >", value, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdGreaterThanOrEqualTo(String value) {
            addCriterion("position_id >=", value, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdLessThan(String value) {
            addCriterion("position_id <", value, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdLessThanOrEqualTo(String value) {
            addCriterion("position_id <=", value, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdLike(String value) {
            addCriterion("position_id like", value, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdNotLike(String value) {
            addCriterion("position_id not like", value, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdIn(List<String> values) {
            addCriterion("position_id in", values, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdNotIn(List<String> values) {
            addCriterion("position_id not in", values, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdBetween(String value1, String value2) {
            addCriterion("position_id between", value1, value2, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdNotBetween(String value1, String value2) {
            addCriterion("position_id not between", value1, value2, "positionId");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andOperatorIsNull() {
            addCriterion("operator is null");
            return (Criteria) this;
        }

        public Criteria andOperatorIsNotNull() {
            addCriterion("operator is not null");
            return (Criteria) this;
        }

        public Criteria andOperatorEqualTo(String value) {
            addCriterion("operator =", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotEqualTo(String value) {
            addCriterion("operator <>", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorGreaterThan(String value) {
            addCriterion("operator >", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorGreaterThanOrEqualTo(String value) {
            addCriterion("operator >=", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorLessThan(String value) {
            addCriterion("operator <", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorLessThanOrEqualTo(String value) {
            addCriterion("operator <=", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorLike(String value) {
            addCriterion("operator like", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotLike(String value) {
            addCriterion("operator not like", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorIn(List<String> values) {
            addCriterion("operator in", values, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotIn(List<String> values) {
            addCriterion("operator not in", values, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorBetween(String value1, String value2) {
            addCriterion("operator between", value1, value2, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotBetween(String value1, String value2) {
            addCriterion("operator not between", value1, value2, "operator");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}