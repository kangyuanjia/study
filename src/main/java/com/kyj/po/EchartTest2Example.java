package com.kyj.po;

import java.util.ArrayList;
import java.util.List;

public class EchartTest2Example {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EchartTest2Example() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andSysNameIsNull() {
            addCriterion("sys_name is null");
            return (Criteria) this;
        }

        public Criteria andSysNameIsNotNull() {
            addCriterion("sys_name is not null");
            return (Criteria) this;
        }

        public Criteria andSysNameEqualTo(String value) {
            addCriterion("sys_name =", value, "sysName");
            return (Criteria) this;
        }

        public Criteria andSysNameNotEqualTo(String value) {
            addCriterion("sys_name <>", value, "sysName");
            return (Criteria) this;
        }

        public Criteria andSysNameGreaterThan(String value) {
            addCriterion("sys_name >", value, "sysName");
            return (Criteria) this;
        }

        public Criteria andSysNameGreaterThanOrEqualTo(String value) {
            addCriterion("sys_name >=", value, "sysName");
            return (Criteria) this;
        }

        public Criteria andSysNameLessThan(String value) {
            addCriterion("sys_name <", value, "sysName");
            return (Criteria) this;
        }

        public Criteria andSysNameLessThanOrEqualTo(String value) {
            addCriterion("sys_name <=", value, "sysName");
            return (Criteria) this;
        }

        public Criteria andSysNameLike(String value) {
            addCriterion("sys_name like", value, "sysName");
            return (Criteria) this;
        }

        public Criteria andSysNameNotLike(String value) {
            addCriterion("sys_name not like", value, "sysName");
            return (Criteria) this;
        }

        public Criteria andSysNameIn(List<String> values) {
            addCriterion("sys_name in", values, "sysName");
            return (Criteria) this;
        }

        public Criteria andSysNameNotIn(List<String> values) {
            addCriterion("sys_name not in", values, "sysName");
            return (Criteria) this;
        }

        public Criteria andSysNameBetween(String value1, String value2) {
            addCriterion("sys_name between", value1, value2, "sysName");
            return (Criteria) this;
        }

        public Criteria andSysNameNotBetween(String value1, String value2) {
            addCriterion("sys_name not between", value1, value2, "sysName");
            return (Criteria) this;
        }

        public Criteria andAccessDateIsNull() {
            addCriterion("access_date is null");
            return (Criteria) this;
        }

        public Criteria andAccessDateIsNotNull() {
            addCriterion("access_date is not null");
            return (Criteria) this;
        }

        public Criteria andAccessDateEqualTo(String value) {
            addCriterion("access_date =", value, "accessDate");
            return (Criteria) this;
        }

        public Criteria andAccessDateNotEqualTo(String value) {
            addCriterion("access_date <>", value, "accessDate");
            return (Criteria) this;
        }

        public Criteria andAccessDateGreaterThan(String value) {
            addCriterion("access_date >", value, "accessDate");
            return (Criteria) this;
        }

        public Criteria andAccessDateGreaterThanOrEqualTo(String value) {
            addCriterion("access_date >=", value, "accessDate");
            return (Criteria) this;
        }

        public Criteria andAccessDateLessThan(String value) {
            addCriterion("access_date <", value, "accessDate");
            return (Criteria) this;
        }

        public Criteria andAccessDateLessThanOrEqualTo(String value) {
            addCriterion("access_date <=", value, "accessDate");
            return (Criteria) this;
        }

        public Criteria andAccessDateLike(String value) {
            addCriterion("access_date like", value, "accessDate");
            return (Criteria) this;
        }

        public Criteria andAccessDateNotLike(String value) {
            addCriterion("access_date not like", value, "accessDate");
            return (Criteria) this;
        }

        public Criteria andAccessDateIn(List<String> values) {
            addCriterion("access_date in", values, "accessDate");
            return (Criteria) this;
        }

        public Criteria andAccessDateNotIn(List<String> values) {
            addCriterion("access_date not in", values, "accessDate");
            return (Criteria) this;
        }

        public Criteria andAccessDateBetween(String value1, String value2) {
            addCriterion("access_date between", value1, value2, "accessDate");
            return (Criteria) this;
        }

        public Criteria andAccessDateNotBetween(String value1, String value2) {
            addCriterion("access_date not between", value1, value2, "accessDate");
            return (Criteria) this;
        }

        public Criteria andAccessTotalIsNull() {
            addCriterion("access_total is null");
            return (Criteria) this;
        }

        public Criteria andAccessTotalIsNotNull() {
            addCriterion("access_total is not null");
            return (Criteria) this;
        }

        public Criteria andAccessTotalEqualTo(Integer value) {
            addCriterion("access_total =", value, "accessTotal");
            return (Criteria) this;
        }

        public Criteria andAccessTotalNotEqualTo(Integer value) {
            addCriterion("access_total <>", value, "accessTotal");
            return (Criteria) this;
        }

        public Criteria andAccessTotalGreaterThan(Integer value) {
            addCriterion("access_total >", value, "accessTotal");
            return (Criteria) this;
        }

        public Criteria andAccessTotalGreaterThanOrEqualTo(Integer value) {
            addCriterion("access_total >=", value, "accessTotal");
            return (Criteria) this;
        }

        public Criteria andAccessTotalLessThan(Integer value) {
            addCriterion("access_total <", value, "accessTotal");
            return (Criteria) this;
        }

        public Criteria andAccessTotalLessThanOrEqualTo(Integer value) {
            addCriterion("access_total <=", value, "accessTotal");
            return (Criteria) this;
        }

        public Criteria andAccessTotalIn(List<Integer> values) {
            addCriterion("access_total in", values, "accessTotal");
            return (Criteria) this;
        }

        public Criteria andAccessTotalNotIn(List<Integer> values) {
            addCriterion("access_total not in", values, "accessTotal");
            return (Criteria) this;
        }

        public Criteria andAccessTotalBetween(Integer value1, Integer value2) {
            addCriterion("access_total between", value1, value2, "accessTotal");
            return (Criteria) this;
        }

        public Criteria andAccessTotalNotBetween(Integer value1, Integer value2) {
            addCriterion("access_total not between", value1, value2, "accessTotal");
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