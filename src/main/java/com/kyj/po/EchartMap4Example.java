package com.kyj.po;

import java.util.ArrayList;
import java.util.List;

public class EchartMap4Example {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EchartMap4Example() {
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

        public Criteria andCityNameIsNull() {
            addCriterion("city_name is null");
            return (Criteria) this;
        }

        public Criteria andCityNameIsNotNull() {
            addCriterion("city_name is not null");
            return (Criteria) this;
        }

        public Criteria andCityNameEqualTo(String value) {
            addCriterion("city_name =", value, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameNotEqualTo(String value) {
            addCriterion("city_name <>", value, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameGreaterThan(String value) {
            addCriterion("city_name >", value, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameGreaterThanOrEqualTo(String value) {
            addCriterion("city_name >=", value, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameLessThan(String value) {
            addCriterion("city_name <", value, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameLessThanOrEqualTo(String value) {
            addCriterion("city_name <=", value, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameLike(String value) {
            addCriterion("city_name like", value, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameNotLike(String value) {
            addCriterion("city_name not like", value, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameIn(List<String> values) {
            addCriterion("city_name in", values, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameNotIn(List<String> values) {
            addCriterion("city_name not in", values, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameBetween(String value1, String value2) {
            addCriterion("city_name between", value1, value2, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameNotBetween(String value1, String value2) {
            addCriterion("city_name not between", value1, value2, "cityName");
            return (Criteria) this;
        }

        public Criteria andLongitudeNumIsNull() {
            addCriterion("longitude_num is null");
            return (Criteria) this;
        }

        public Criteria andLongitudeNumIsNotNull() {
            addCriterion("longitude_num is not null");
            return (Criteria) this;
        }

        public Criteria andLongitudeNumEqualTo(String value) {
            addCriterion("longitude_num =", value, "longitudeNum");
            return (Criteria) this;
        }

        public Criteria andLongitudeNumNotEqualTo(String value) {
            addCriterion("longitude_num <>", value, "longitudeNum");
            return (Criteria) this;
        }

        public Criteria andLongitudeNumGreaterThan(String value) {
            addCriterion("longitude_num >", value, "longitudeNum");
            return (Criteria) this;
        }

        public Criteria andLongitudeNumGreaterThanOrEqualTo(String value) {
            addCriterion("longitude_num >=", value, "longitudeNum");
            return (Criteria) this;
        }

        public Criteria andLongitudeNumLessThan(String value) {
            addCriterion("longitude_num <", value, "longitudeNum");
            return (Criteria) this;
        }

        public Criteria andLongitudeNumLessThanOrEqualTo(String value) {
            addCriterion("longitude_num <=", value, "longitudeNum");
            return (Criteria) this;
        }

        public Criteria andLongitudeNumLike(String value) {
            addCriterion("longitude_num like", value, "longitudeNum");
            return (Criteria) this;
        }

        public Criteria andLongitudeNumNotLike(String value) {
            addCriterion("longitude_num not like", value, "longitudeNum");
            return (Criteria) this;
        }

        public Criteria andLongitudeNumIn(List<String> values) {
            addCriterion("longitude_num in", values, "longitudeNum");
            return (Criteria) this;
        }

        public Criteria andLongitudeNumNotIn(List<String> values) {
            addCriterion("longitude_num not in", values, "longitudeNum");
            return (Criteria) this;
        }

        public Criteria andLongitudeNumBetween(String value1, String value2) {
            addCriterion("longitude_num between", value1, value2, "longitudeNum");
            return (Criteria) this;
        }

        public Criteria andLongitudeNumNotBetween(String value1, String value2) {
            addCriterion("longitude_num not between", value1, value2, "longitudeNum");
            return (Criteria) this;
        }

        public Criteria andLatitudeNumIsNull() {
            addCriterion("latitude_num is null");
            return (Criteria) this;
        }

        public Criteria andLatitudeNumIsNotNull() {
            addCriterion("latitude_num is not null");
            return (Criteria) this;
        }

        public Criteria andLatitudeNumEqualTo(String value) {
            addCriterion("latitude_num =", value, "latitudeNum");
            return (Criteria) this;
        }

        public Criteria andLatitudeNumNotEqualTo(String value) {
            addCriterion("latitude_num <>", value, "latitudeNum");
            return (Criteria) this;
        }

        public Criteria andLatitudeNumGreaterThan(String value) {
            addCriterion("latitude_num >", value, "latitudeNum");
            return (Criteria) this;
        }

        public Criteria andLatitudeNumGreaterThanOrEqualTo(String value) {
            addCriterion("latitude_num >=", value, "latitudeNum");
            return (Criteria) this;
        }

        public Criteria andLatitudeNumLessThan(String value) {
            addCriterion("latitude_num <", value, "latitudeNum");
            return (Criteria) this;
        }

        public Criteria andLatitudeNumLessThanOrEqualTo(String value) {
            addCriterion("latitude_num <=", value, "latitudeNum");
            return (Criteria) this;
        }

        public Criteria andLatitudeNumLike(String value) {
            addCriterion("latitude_num like", value, "latitudeNum");
            return (Criteria) this;
        }

        public Criteria andLatitudeNumNotLike(String value) {
            addCriterion("latitude_num not like", value, "latitudeNum");
            return (Criteria) this;
        }

        public Criteria andLatitudeNumIn(List<String> values) {
            addCriterion("latitude_num in", values, "latitudeNum");
            return (Criteria) this;
        }

        public Criteria andLatitudeNumNotIn(List<String> values) {
            addCriterion("latitude_num not in", values, "latitudeNum");
            return (Criteria) this;
        }

        public Criteria andLatitudeNumBetween(String value1, String value2) {
            addCriterion("latitude_num between", value1, value2, "latitudeNum");
            return (Criteria) this;
        }

        public Criteria andLatitudeNumNotBetween(String value1, String value2) {
            addCriterion("latitude_num not between", value1, value2, "latitudeNum");
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