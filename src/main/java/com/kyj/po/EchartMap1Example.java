package com.kyj.po;

import java.util.ArrayList;
import java.util.List;

public class EchartMap1Example {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EchartMap1Example() {
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

        public Criteria andIphoneTypeIsNull() {
            addCriterion("iphone_type is null");
            return (Criteria) this;
        }

        public Criteria andIphoneTypeIsNotNull() {
            addCriterion("iphone_type is not null");
            return (Criteria) this;
        }

        public Criteria andIphoneTypeEqualTo(String value) {
            addCriterion("iphone_type =", value, "iphoneType");
            return (Criteria) this;
        }

        public Criteria andIphoneTypeNotEqualTo(String value) {
            addCriterion("iphone_type <>", value, "iphoneType");
            return (Criteria) this;
        }

        public Criteria andIphoneTypeGreaterThan(String value) {
            addCriterion("iphone_type >", value, "iphoneType");
            return (Criteria) this;
        }

        public Criteria andIphoneTypeGreaterThanOrEqualTo(String value) {
            addCriterion("iphone_type >=", value, "iphoneType");
            return (Criteria) this;
        }

        public Criteria andIphoneTypeLessThan(String value) {
            addCriterion("iphone_type <", value, "iphoneType");
            return (Criteria) this;
        }

        public Criteria andIphoneTypeLessThanOrEqualTo(String value) {
            addCriterion("iphone_type <=", value, "iphoneType");
            return (Criteria) this;
        }

        public Criteria andIphoneTypeLike(String value) {
            addCriterion("iphone_type like", value, "iphoneType");
            return (Criteria) this;
        }

        public Criteria andIphoneTypeNotLike(String value) {
            addCriterion("iphone_type not like", value, "iphoneType");
            return (Criteria) this;
        }

        public Criteria andIphoneTypeIn(List<String> values) {
            addCriterion("iphone_type in", values, "iphoneType");
            return (Criteria) this;
        }

        public Criteria andIphoneTypeNotIn(List<String> values) {
            addCriterion("iphone_type not in", values, "iphoneType");
            return (Criteria) this;
        }

        public Criteria andIphoneTypeBetween(String value1, String value2) {
            addCriterion("iphone_type between", value1, value2, "iphoneType");
            return (Criteria) this;
        }

        public Criteria andIphoneTypeNotBetween(String value1, String value2) {
            addCriterion("iphone_type not between", value1, value2, "iphoneType");
            return (Criteria) this;
        }

        public Criteria andProvNameIsNull() {
            addCriterion("prov_name is null");
            return (Criteria) this;
        }

        public Criteria andProvNameIsNotNull() {
            addCriterion("prov_name is not null");
            return (Criteria) this;
        }

        public Criteria andProvNameEqualTo(String value) {
            addCriterion("prov_name =", value, "provName");
            return (Criteria) this;
        }

        public Criteria andProvNameNotEqualTo(String value) {
            addCriterion("prov_name <>", value, "provName");
            return (Criteria) this;
        }

        public Criteria andProvNameGreaterThan(String value) {
            addCriterion("prov_name >", value, "provName");
            return (Criteria) this;
        }

        public Criteria andProvNameGreaterThanOrEqualTo(String value) {
            addCriterion("prov_name >=", value, "provName");
            return (Criteria) this;
        }

        public Criteria andProvNameLessThan(String value) {
            addCriterion("prov_name <", value, "provName");
            return (Criteria) this;
        }

        public Criteria andProvNameLessThanOrEqualTo(String value) {
            addCriterion("prov_name <=", value, "provName");
            return (Criteria) this;
        }

        public Criteria andProvNameLike(String value) {
            addCriterion("prov_name like", value, "provName");
            return (Criteria) this;
        }

        public Criteria andProvNameNotLike(String value) {
            addCriterion("prov_name not like", value, "provName");
            return (Criteria) this;
        }

        public Criteria andProvNameIn(List<String> values) {
            addCriterion("prov_name in", values, "provName");
            return (Criteria) this;
        }

        public Criteria andProvNameNotIn(List<String> values) {
            addCriterion("prov_name not in", values, "provName");
            return (Criteria) this;
        }

        public Criteria andProvNameBetween(String value1, String value2) {
            addCriterion("prov_name between", value1, value2, "provName");
            return (Criteria) this;
        }

        public Criteria andProvNameNotBetween(String value1, String value2) {
            addCriterion("prov_name not between", value1, value2, "provName");
            return (Criteria) this;
        }

        public Criteria andSaleTotalIsNull() {
            addCriterion("sale_total is null");
            return (Criteria) this;
        }

        public Criteria andSaleTotalIsNotNull() {
            addCriterion("sale_total is not null");
            return (Criteria) this;
        }

        public Criteria andSaleTotalEqualTo(String value) {
            addCriterion("sale_total =", value, "saleTotal");
            return (Criteria) this;
        }

        public Criteria andSaleTotalNotEqualTo(String value) {
            addCriterion("sale_total <>", value, "saleTotal");
            return (Criteria) this;
        }

        public Criteria andSaleTotalGreaterThan(String value) {
            addCriterion("sale_total >", value, "saleTotal");
            return (Criteria) this;
        }

        public Criteria andSaleTotalGreaterThanOrEqualTo(String value) {
            addCriterion("sale_total >=", value, "saleTotal");
            return (Criteria) this;
        }

        public Criteria andSaleTotalLessThan(String value) {
            addCriterion("sale_total <", value, "saleTotal");
            return (Criteria) this;
        }

        public Criteria andSaleTotalLessThanOrEqualTo(String value) {
            addCriterion("sale_total <=", value, "saleTotal");
            return (Criteria) this;
        }

        public Criteria andSaleTotalLike(String value) {
            addCriterion("sale_total like", value, "saleTotal");
            return (Criteria) this;
        }

        public Criteria andSaleTotalNotLike(String value) {
            addCriterion("sale_total not like", value, "saleTotal");
            return (Criteria) this;
        }

        public Criteria andSaleTotalIn(List<String> values) {
            addCriterion("sale_total in", values, "saleTotal");
            return (Criteria) this;
        }

        public Criteria andSaleTotalNotIn(List<String> values) {
            addCriterion("sale_total not in", values, "saleTotal");
            return (Criteria) this;
        }

        public Criteria andSaleTotalBetween(String value1, String value2) {
            addCriterion("sale_total between", value1, value2, "saleTotal");
            return (Criteria) this;
        }

        public Criteria andSaleTotalNotBetween(String value1, String value2) {
            addCriterion("sale_total not between", value1, value2, "saleTotal");
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