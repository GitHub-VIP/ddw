package com.dd.shop.manager.pojo.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PayinfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PayinfoExample() {
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

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andOrderNoIsNull() {
            addCriterion("order_no is null");
            return (Criteria) this;
        }

        public Criteria andOrderNoIsNotNull() {
            addCriterion("order_no is not null");
            return (Criteria) this;
        }

        public Criteria andOrderNoEqualTo(Integer value) {
            addCriterion("order_no =", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotEqualTo(Integer value) {
            addCriterion("order_no <>", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoGreaterThan(Integer value) {
            addCriterion("order_no >", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_no >=", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLessThan(Integer value) {
            addCriterion("order_no <", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLessThanOrEqualTo(Integer value) {
            addCriterion("order_no <=", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoIn(List<Integer> values) {
            addCriterion("order_no in", values, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotIn(List<Integer> values) {
            addCriterion("order_no not in", values, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoBetween(Integer value1, Integer value2) {
            addCriterion("order_no between", value1, value2, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotBetween(Integer value1, Integer value2) {
            addCriterion("order_no not between", value1, value2, "orderNo");
            return (Criteria) this;
        }

        public Criteria andPayPlatformIsNull() {
            addCriterion("pay_platform is null");
            return (Criteria) this;
        }

        public Criteria andPayPlatformIsNotNull() {
            addCriterion("pay_platform is not null");
            return (Criteria) this;
        }

        public Criteria andPayPlatformEqualTo(Integer value) {
            addCriterion("pay_platform =", value, "payPlatform");
            return (Criteria) this;
        }

        public Criteria andPayPlatformNotEqualTo(Integer value) {
            addCriterion("pay_platform <>", value, "payPlatform");
            return (Criteria) this;
        }

        public Criteria andPayPlatformGreaterThan(Integer value) {
            addCriterion("pay_platform >", value, "payPlatform");
            return (Criteria) this;
        }

        public Criteria andPayPlatformGreaterThanOrEqualTo(Integer value) {
            addCriterion("pay_platform >=", value, "payPlatform");
            return (Criteria) this;
        }

        public Criteria andPayPlatformLessThan(Integer value) {
            addCriterion("pay_platform <", value, "payPlatform");
            return (Criteria) this;
        }

        public Criteria andPayPlatformLessThanOrEqualTo(Integer value) {
            addCriterion("pay_platform <=", value, "payPlatform");
            return (Criteria) this;
        }

        public Criteria andPayPlatformIn(List<Integer> values) {
            addCriterion("pay_platform in", values, "payPlatform");
            return (Criteria) this;
        }

        public Criteria andPayPlatformNotIn(List<Integer> values) {
            addCriterion("pay_platform not in", values, "payPlatform");
            return (Criteria) this;
        }

        public Criteria andPayPlatformBetween(Integer value1, Integer value2) {
            addCriterion("pay_platform between", value1, value2, "payPlatform");
            return (Criteria) this;
        }

        public Criteria andPayPlatformNotBetween(Integer value1, Integer value2) {
            addCriterion("pay_platform not between", value1, value2, "payPlatform");
            return (Criteria) this;
        }

        public Criteria andPlatformNumberIsNull() {
            addCriterion("platform_number is null");
            return (Criteria) this;
        }

        public Criteria andPlatformNumberIsNotNull() {
            addCriterion("platform_number is not null");
            return (Criteria) this;
        }

        public Criteria andPlatformNumberEqualTo(String value) {
            addCriterion("platform_number =", value, "platformNumber");
            return (Criteria) this;
        }

        public Criteria andPlatformNumberNotEqualTo(String value) {
            addCriterion("platform_number <>", value, "platformNumber");
            return (Criteria) this;
        }

        public Criteria andPlatformNumberGreaterThan(String value) {
            addCriterion("platform_number >", value, "platformNumber");
            return (Criteria) this;
        }

        public Criteria andPlatformNumberGreaterThanOrEqualTo(String value) {
            addCriterion("platform_number >=", value, "platformNumber");
            return (Criteria) this;
        }

        public Criteria andPlatformNumberLessThan(String value) {
            addCriterion("platform_number <", value, "platformNumber");
            return (Criteria) this;
        }

        public Criteria andPlatformNumberLessThanOrEqualTo(String value) {
            addCriterion("platform_number <=", value, "platformNumber");
            return (Criteria) this;
        }

        public Criteria andPlatformNumberLike(String value) {
            addCriterion("platform_number like", value, "platformNumber");
            return (Criteria) this;
        }

        public Criteria andPlatformNumberNotLike(String value) {
            addCriterion("platform_number not like", value, "platformNumber");
            return (Criteria) this;
        }

        public Criteria andPlatformNumberIn(List<String> values) {
            addCriterion("platform_number in", values, "platformNumber");
            return (Criteria) this;
        }

        public Criteria andPlatformNumberNotIn(List<String> values) {
            addCriterion("platform_number not in", values, "platformNumber");
            return (Criteria) this;
        }

        public Criteria andPlatformNumberBetween(String value1, String value2) {
            addCriterion("platform_number between", value1, value2, "platformNumber");
            return (Criteria) this;
        }

        public Criteria andPlatformNumberNotBetween(String value1, String value2) {
            addCriterion("platform_number not between", value1, value2, "platformNumber");
            return (Criteria) this;
        }

        public Criteria andPlatformStatusIsNull() {
            addCriterion("platform_status is null");
            return (Criteria) this;
        }

        public Criteria andPlatformStatusIsNotNull() {
            addCriterion("platform_status is not null");
            return (Criteria) this;
        }

        public Criteria andPlatformStatusEqualTo(String value) {
            addCriterion("platform_status =", value, "platformStatus");
            return (Criteria) this;
        }

        public Criteria andPlatformStatusNotEqualTo(String value) {
            addCriterion("platform_status <>", value, "platformStatus");
            return (Criteria) this;
        }

        public Criteria andPlatformStatusGreaterThan(String value) {
            addCriterion("platform_status >", value, "platformStatus");
            return (Criteria) this;
        }

        public Criteria andPlatformStatusGreaterThanOrEqualTo(String value) {
            addCriterion("platform_status >=", value, "platformStatus");
            return (Criteria) this;
        }

        public Criteria andPlatformStatusLessThan(String value) {
            addCriterion("platform_status <", value, "platformStatus");
            return (Criteria) this;
        }

        public Criteria andPlatformStatusLessThanOrEqualTo(String value) {
            addCriterion("platform_status <=", value, "platformStatus");
            return (Criteria) this;
        }

        public Criteria andPlatformStatusLike(String value) {
            addCriterion("platform_status like", value, "platformStatus");
            return (Criteria) this;
        }

        public Criteria andPlatformStatusNotLike(String value) {
            addCriterion("platform_status not like", value, "platformStatus");
            return (Criteria) this;
        }

        public Criteria andPlatformStatusIn(List<String> values) {
            addCriterion("platform_status in", values, "platformStatus");
            return (Criteria) this;
        }

        public Criteria andPlatformStatusNotIn(List<String> values) {
            addCriterion("platform_status not in", values, "platformStatus");
            return (Criteria) this;
        }

        public Criteria andPlatformStatusBetween(String value1, String value2) {
            addCriterion("platform_status between", value1, value2, "platformStatus");
            return (Criteria) this;
        }

        public Criteria andPlatformStatusNotBetween(String value1, String value2) {
            addCriterion("platform_status not between", value1, value2, "platformStatus");
            return (Criteria) this;
        }

        public Criteria andCreatedateIsNull() {
            addCriterion("createdate is null");
            return (Criteria) this;
        }

        public Criteria andCreatedateIsNotNull() {
            addCriterion("createdate is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedateEqualTo(Date value) {
            addCriterion("createdate =", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateNotEqualTo(Date value) {
            addCriterion("createdate <>", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateGreaterThan(Date value) {
            addCriterion("createdate >", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateGreaterThanOrEqualTo(Date value) {
            addCriterion("createdate >=", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateLessThan(Date value) {
            addCriterion("createdate <", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateLessThanOrEqualTo(Date value) {
            addCriterion("createdate <=", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateIn(List<Date> values) {
            addCriterion("createdate in", values, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateNotIn(List<Date> values) {
            addCriterion("createdate not in", values, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateBetween(Date value1, Date value2) {
            addCriterion("createdate between", value1, value2, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateNotBetween(Date value1, Date value2) {
            addCriterion("createdate not between", value1, value2, "createdate");
            return (Criteria) this;
        }

        public Criteria andModifytimeIsNull() {
            addCriterion("modifytime is null");
            return (Criteria) this;
        }

        public Criteria andModifytimeIsNotNull() {
            addCriterion("modifytime is not null");
            return (Criteria) this;
        }

        public Criteria andModifytimeEqualTo(Date value) {
            addCriterion("modifytime =", value, "modifytime");
            return (Criteria) this;
        }

        public Criteria andModifytimeNotEqualTo(Date value) {
            addCriterion("modifytime <>", value, "modifytime");
            return (Criteria) this;
        }

        public Criteria andModifytimeGreaterThan(Date value) {
            addCriterion("modifytime >", value, "modifytime");
            return (Criteria) this;
        }

        public Criteria andModifytimeGreaterThanOrEqualTo(Date value) {
            addCriterion("modifytime >=", value, "modifytime");
            return (Criteria) this;
        }

        public Criteria andModifytimeLessThan(Date value) {
            addCriterion("modifytime <", value, "modifytime");
            return (Criteria) this;
        }

        public Criteria andModifytimeLessThanOrEqualTo(Date value) {
            addCriterion("modifytime <=", value, "modifytime");
            return (Criteria) this;
        }

        public Criteria andModifytimeIn(List<Date> values) {
            addCriterion("modifytime in", values, "modifytime");
            return (Criteria) this;
        }

        public Criteria andModifytimeNotIn(List<Date> values) {
            addCriterion("modifytime not in", values, "modifytime");
            return (Criteria) this;
        }

        public Criteria andModifytimeBetween(Date value1, Date value2) {
            addCriterion("modifytime between", value1, value2, "modifytime");
            return (Criteria) this;
        }

        public Criteria andModifytimeNotBetween(Date value1, Date value2) {
            addCriterion("modifytime not between", value1, value2, "modifytime");
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