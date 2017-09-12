package com.kyj.po;

import java.util.ArrayList;
import java.util.List;

public class EchartMap3Example {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EchartMap3Example() {
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

        public Criteria andStartCityIsNull() {
            addCriterion("start_city is null");
            return (Criteria) this;
        }

        public Criteria andStartCityIsNotNull() {
            addCriterion("start_city is not null");
            return (Criteria) this;
        }

        public Criteria andStartCityEqualTo(String value) {
            addCriterion("start_city =", value, "startCity");
            return (Criteria) this;
        }

        public Criteria andStartCityNotEqualTo(String value) {
            addCriterion("start_city <>", value, "startCity");
            return (Criteria) this;
        }

        public Criteria andStartCityGreaterThan(String value) {
            addCriterion("start_city >", value, "startCity");
            return (Criteria) this;
        }

        public Criteria andStartCityGreaterThanOrEqualTo(String value) {
            addCriterion("start_city >=", value, "startCity");
            return (Criteria) this;
        }

        public Criteria andStartCityLessThan(String value) {
            addCriterion("start_city <", value, "startCity");
            return (Criteria) this;
        }

        public Criteria andStartCityLessThanOrEqualTo(String value) {
            addCriterion("start_city <=", value, "startCity");
            return (Criteria) this;
        }

        public Criteria andStartCityLike(String value) {
            addCriterion("start_city like", value, "startCity");
            return (Criteria) this;
        }

        public Criteria andStartCityNotLike(String value) {
            addCriterion("start_city not like", value, "startCity");
            return (Criteria) this;
        }

        public Criteria andStartCityIn(List<String> values) {
            addCriterion("start_city in", values, "startCity");
            return (Criteria) this;
        }

        public Criteria andStartCityNotIn(List<String> values) {
            addCriterion("start_city not in", values, "startCity");
            return (Criteria) this;
        }

        public Criteria andStartCityBetween(String value1, String value2) {
            addCriterion("start_city between", value1, value2, "startCity");
            return (Criteria) this;
        }

        public Criteria andStartCityNotBetween(String value1, String value2) {
            addCriterion("start_city not between", value1, value2, "startCity");
            return (Criteria) this;
        }

        public Criteria andEndCityIsNull() {
            addCriterion("end_city is null");
            return (Criteria) this;
        }

        public Criteria andEndCityIsNotNull() {
            addCriterion("end_city is not null");
            return (Criteria) this;
        }

        public Criteria andEndCityEqualTo(String value) {
            addCriterion("end_city =", value, "endCity");
            return (Criteria) this;
        }

        public Criteria andEndCityNotEqualTo(String value) {
            addCriterion("end_city <>", value, "endCity");
            return (Criteria) this;
        }

        public Criteria andEndCityGreaterThan(String value) {
            addCriterion("end_city >", value, "endCity");
            return (Criteria) this;
        }

        public Criteria andEndCityGreaterThanOrEqualTo(String value) {
            addCriterion("end_city >=", value, "endCity");
            return (Criteria) this;
        }

        public Criteria andEndCityLessThan(String value) {
            addCriterion("end_city <", value, "endCity");
            return (Criteria) this;
        }

        public Criteria andEndCityLessThanOrEqualTo(String value) {
            addCriterion("end_city <=", value, "endCity");
            return (Criteria) this;
        }

        public Criteria andEndCityLike(String value) {
            addCriterion("end_city like", value, "endCity");
            return (Criteria) this;
        }

        public Criteria andEndCityNotLike(String value) {
            addCriterion("end_city not like", value, "endCity");
            return (Criteria) this;
        }

        public Criteria andEndCityIn(List<String> values) {
            addCriterion("end_city in", values, "endCity");
            return (Criteria) this;
        }

        public Criteria andEndCityNotIn(List<String> values) {
            addCriterion("end_city not in", values, "endCity");
            return (Criteria) this;
        }

        public Criteria andEndCityBetween(String value1, String value2) {
            addCriterion("end_city between", value1, value2, "endCity");
            return (Criteria) this;
        }

        public Criteria andEndCityNotBetween(String value1, String value2) {
            addCriterion("end_city not between", value1, value2, "endCity");
            return (Criteria) this;
        }

        public Criteria andShipmentTotalIsNull() {
            addCriterion("shipment_total is null");
            return (Criteria) this;
        }

        public Criteria andShipmentTotalIsNotNull() {
            addCriterion("shipment_total is not null");
            return (Criteria) this;
        }

        public Criteria andShipmentTotalEqualTo(Integer value) {
            addCriterion("shipment_total =", value, "shipmentTotal");
            return (Criteria) this;
        }

        public Criteria andShipmentTotalNotEqualTo(Integer value) {
            addCriterion("shipment_total <>", value, "shipmentTotal");
            return (Criteria) this;
        }

        public Criteria andShipmentTotalGreaterThan(Integer value) {
            addCriterion("shipment_total >", value, "shipmentTotal");
            return (Criteria) this;
        }

        public Criteria andShipmentTotalGreaterThanOrEqualTo(Integer value) {
            addCriterion("shipment_total >=", value, "shipmentTotal");
            return (Criteria) this;
        }

        public Criteria andShipmentTotalLessThan(Integer value) {
            addCriterion("shipment_total <", value, "shipmentTotal");
            return (Criteria) this;
        }

        public Criteria andShipmentTotalLessThanOrEqualTo(Integer value) {
            addCriterion("shipment_total <=", value, "shipmentTotal");
            return (Criteria) this;
        }

        public Criteria andShipmentTotalIn(List<Integer> values) {
            addCriterion("shipment_total in", values, "shipmentTotal");
            return (Criteria) this;
        }

        public Criteria andShipmentTotalNotIn(List<Integer> values) {
            addCriterion("shipment_total not in", values, "shipmentTotal");
            return (Criteria) this;
        }

        public Criteria andShipmentTotalBetween(Integer value1, Integer value2) {
            addCriterion("shipment_total between", value1, value2, "shipmentTotal");
            return (Criteria) this;
        }

        public Criteria andShipmentTotalNotBetween(Integer value1, Integer value2) {
            addCriterion("shipment_total not between", value1, value2, "shipmentTotal");
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