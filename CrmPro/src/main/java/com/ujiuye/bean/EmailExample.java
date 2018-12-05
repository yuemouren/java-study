package com.ujiuye.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class EmailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EmailExample() {
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

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andEnameIsNull() {
            addCriterion("ename is null");
            return (Criteria) this;
        }

        public Criteria andEnameIsNotNull() {
            addCriterion("ename is not null");
            return (Criteria) this;
        }

        public Criteria andEnameEqualTo(String value) {
            addCriterion("ename =", value, "ename");
            return (Criteria) this;
        }

        public Criteria andEnameNotEqualTo(String value) {
            addCriterion("ename <>", value, "ename");
            return (Criteria) this;
        }

        public Criteria andEnameGreaterThan(String value) {
            addCriterion("ename >", value, "ename");
            return (Criteria) this;
        }

        public Criteria andEnameGreaterThanOrEqualTo(String value) {
            addCriterion("ename >=", value, "ename");
            return (Criteria) this;
        }

        public Criteria andEnameLessThan(String value) {
            addCriterion("ename <", value, "ename");
            return (Criteria) this;
        }

        public Criteria andEnameLessThanOrEqualTo(String value) {
            addCriterion("ename <=", value, "ename");
            return (Criteria) this;
        }

        public Criteria andEnameLike(String value) {
            addCriterion("ename like", value, "ename");
            return (Criteria) this;
        }

        public Criteria andEnameNotLike(String value) {
            addCriterion("ename not like", value, "ename");
            return (Criteria) this;
        }

        public Criteria andEnameIn(List<String> values) {
            addCriterion("ename in", values, "ename");
            return (Criteria) this;
        }

        public Criteria andEnameNotIn(List<String> values) {
            addCriterion("ename not in", values, "ename");
            return (Criteria) this;
        }

        public Criteria andEnameBetween(String value1, String value2) {
            addCriterion("ename between", value1, value2, "ename");
            return (Criteria) this;
        }

        public Criteria andEnameNotBetween(String value1, String value2) {
            addCriterion("ename not between", value1, value2, "ename");
            return (Criteria) this;
        }

        public Criteria andSendtimeIsNull() {
            addCriterion("sendtime is null");
            return (Criteria) this;
        }

        public Criteria andSendtimeIsNotNull() {
            addCriterion("sendtime is not null");
            return (Criteria) this;
        }

        public Criteria andSendtimeEqualTo(Date value) {
            addCriterionForJDBCDate("sendtime =", value, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("sendtime <>", value, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeGreaterThan(Date value) {
            addCriterionForJDBCDate("sendtime >", value, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("sendtime >=", value, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeLessThan(Date value) {
            addCriterionForJDBCDate("sendtime <", value, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("sendtime <=", value, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeIn(List<Date> values) {
            addCriterionForJDBCDate("sendtime in", values, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("sendtime not in", values, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("sendtime between", value1, value2, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("sendtime not between", value1, value2, "sendtime");
            return (Criteria) this;
        }

        public Criteria andContentIsNull() {
            addCriterion("content is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("content is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("content =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("content <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("content >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("content >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("content <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("content <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("content like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("content not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("content in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("content not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("content between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("content not between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andSendEmpFkIsNull() {
            addCriterion("send_emp_fk is null");
            return (Criteria) this;
        }

        public Criteria andSendEmpFkIsNotNull() {
            addCriterion("send_emp_fk is not null");
            return (Criteria) this;
        }

        public Criteria andSendEmpFkEqualTo(Integer value) {
            addCriterion("send_emp_fk =", value, "sendEmpFk");
            return (Criteria) this;
        }

        public Criteria andSendEmpFkNotEqualTo(Integer value) {
            addCriterion("send_emp_fk <>", value, "sendEmpFk");
            return (Criteria) this;
        }

        public Criteria andSendEmpFkGreaterThan(Integer value) {
            addCriterion("send_emp_fk >", value, "sendEmpFk");
            return (Criteria) this;
        }

        public Criteria andSendEmpFkGreaterThanOrEqualTo(Integer value) {
            addCriterion("send_emp_fk >=", value, "sendEmpFk");
            return (Criteria) this;
        }

        public Criteria andSendEmpFkLessThan(Integer value) {
            addCriterion("send_emp_fk <", value, "sendEmpFk");
            return (Criteria) this;
        }

        public Criteria andSendEmpFkLessThanOrEqualTo(Integer value) {
            addCriterion("send_emp_fk <=", value, "sendEmpFk");
            return (Criteria) this;
        }

        public Criteria andSendEmpFkIn(List<Integer> values) {
            addCriterion("send_emp_fk in", values, "sendEmpFk");
            return (Criteria) this;
        }

        public Criteria andSendEmpFkNotIn(List<Integer> values) {
            addCriterion("send_emp_fk not in", values, "sendEmpFk");
            return (Criteria) this;
        }

        public Criteria andSendEmpFkBetween(Integer value1, Integer value2) {
            addCriterion("send_emp_fk between", value1, value2, "sendEmpFk");
            return (Criteria) this;
        }

        public Criteria andSendEmpFkNotBetween(Integer value1, Integer value2) {
            addCriterion("send_emp_fk not between", value1, value2, "sendEmpFk");
            return (Criteria) this;
        }

        public Criteria andPathIsNull() {
            addCriterion("path is null");
            return (Criteria) this;
        }

        public Criteria andPathIsNotNull() {
            addCriterion("path is not null");
            return (Criteria) this;
        }

        public Criteria andPathEqualTo(String value) {
            addCriterion("path =", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathNotEqualTo(String value) {
            addCriterion("path <>", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathGreaterThan(String value) {
            addCriterion("path >", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathGreaterThanOrEqualTo(String value) {
            addCriterion("path >=", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathLessThan(String value) {
            addCriterion("path <", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathLessThanOrEqualTo(String value) {
            addCriterion("path <=", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathLike(String value) {
            addCriterion("path like", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathNotLike(String value) {
            addCriterion("path not like", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathIn(List<String> values) {
            addCriterion("path in", values, "path");
            return (Criteria) this;
        }

        public Criteria andPathNotIn(List<String> values) {
            addCriterion("path not in", values, "path");
            return (Criteria) this;
        }

        public Criteria andPathBetween(String value1, String value2) {
            addCriterion("path between", value1, value2, "path");
            return (Criteria) this;
        }

        public Criteria andPathNotBetween(String value1, String value2) {
            addCriterion("path not between", value1, value2, "path");
            return (Criteria) this;
        }

        public Criteria andReceiveEmpFkIsNull() {
            addCriterion("receive_emp_fk is null");
            return (Criteria) this;
        }

        public Criteria andReceiveEmpFkIsNotNull() {
            addCriterion("receive_emp_fk is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveEmpFkEqualTo(Integer value) {
            addCriterion("receive_emp_fk =", value, "receiveEmpFk");
            return (Criteria) this;
        }

        public Criteria andReceiveEmpFkNotEqualTo(Integer value) {
            addCriterion("receive_emp_fk <>", value, "receiveEmpFk");
            return (Criteria) this;
        }

        public Criteria andReceiveEmpFkGreaterThan(Integer value) {
            addCriterion("receive_emp_fk >", value, "receiveEmpFk");
            return (Criteria) this;
        }

        public Criteria andReceiveEmpFkGreaterThanOrEqualTo(Integer value) {
            addCriterion("receive_emp_fk >=", value, "receiveEmpFk");
            return (Criteria) this;
        }

        public Criteria andReceiveEmpFkLessThan(Integer value) {
            addCriterion("receive_emp_fk <", value, "receiveEmpFk");
            return (Criteria) this;
        }

        public Criteria andReceiveEmpFkLessThanOrEqualTo(Integer value) {
            addCriterion("receive_emp_fk <=", value, "receiveEmpFk");
            return (Criteria) this;
        }

        public Criteria andReceiveEmpFkIn(List<Integer> values) {
            addCriterion("receive_emp_fk in", values, "receiveEmpFk");
            return (Criteria) this;
        }

        public Criteria andReceiveEmpFkNotIn(List<Integer> values) {
            addCriterion("receive_emp_fk not in", values, "receiveEmpFk");
            return (Criteria) this;
        }

        public Criteria andReceiveEmpFkBetween(Integer value1, Integer value2) {
            addCriterion("receive_emp_fk between", value1, value2, "receiveEmpFk");
            return (Criteria) this;
        }

        public Criteria andReceiveEmpFkNotBetween(Integer value1, Integer value2) {
            addCriterion("receive_emp_fk not between", value1, value2, "receiveEmpFk");
            return (Criteria) this;
        }

        public Criteria andLookStateIsNull() {
            addCriterion("look_state is null");
            return (Criteria) this;
        }

        public Criteria andLookStateIsNotNull() {
            addCriterion("look_state is not null");
            return (Criteria) this;
        }

        public Criteria andLookStateEqualTo(Integer value) {
            addCriterion("look_state =", value, "lookState");
            return (Criteria) this;
        }

        public Criteria andLookStateNotEqualTo(Integer value) {
            addCriterion("look_state <>", value, "lookState");
            return (Criteria) this;
        }

        public Criteria andLookStateGreaterThan(Integer value) {
            addCriterion("look_state >", value, "lookState");
            return (Criteria) this;
        }

        public Criteria andLookStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("look_state >=", value, "lookState");
            return (Criteria) this;
        }

        public Criteria andLookStateLessThan(Integer value) {
            addCriterion("look_state <", value, "lookState");
            return (Criteria) this;
        }

        public Criteria andLookStateLessThanOrEqualTo(Integer value) {
            addCriterion("look_state <=", value, "lookState");
            return (Criteria) this;
        }

        public Criteria andLookStateIn(List<Integer> values) {
            addCriterion("look_state in", values, "lookState");
            return (Criteria) this;
        }

        public Criteria andLookStateNotIn(List<Integer> values) {
            addCriterion("look_state not in", values, "lookState");
            return (Criteria) this;
        }

        public Criteria andLookStateBetween(Integer value1, Integer value2) {
            addCriterion("look_state between", value1, value2, "lookState");
            return (Criteria) this;
        }

        public Criteria andLookStateNotBetween(Integer value1, Integer value2) {
            addCriterion("look_state not between", value1, value2, "lookState");
            return (Criteria) this;
        }

        public Criteria andReturnStateIsNull() {
            addCriterion("return_state is null");
            return (Criteria) this;
        }

        public Criteria andReturnStateIsNotNull() {
            addCriterion("return_state is not null");
            return (Criteria) this;
        }

        public Criteria andReturnStateEqualTo(Integer value) {
            addCriterion("return_state =", value, "returnState");
            return (Criteria) this;
        }

        public Criteria andReturnStateNotEqualTo(Integer value) {
            addCriterion("return_state <>", value, "returnState");
            return (Criteria) this;
        }

        public Criteria andReturnStateGreaterThan(Integer value) {
            addCriterion("return_state >", value, "returnState");
            return (Criteria) this;
        }

        public Criteria andReturnStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("return_state >=", value, "returnState");
            return (Criteria) this;
        }

        public Criteria andReturnStateLessThan(Integer value) {
            addCriterion("return_state <", value, "returnState");
            return (Criteria) this;
        }

        public Criteria andReturnStateLessThanOrEqualTo(Integer value) {
            addCriterion("return_state <=", value, "returnState");
            return (Criteria) this;
        }

        public Criteria andReturnStateIn(List<Integer> values) {
            addCriterion("return_state in", values, "returnState");
            return (Criteria) this;
        }

        public Criteria andReturnStateNotIn(List<Integer> values) {
            addCriterion("return_state not in", values, "returnState");
            return (Criteria) this;
        }

        public Criteria andReturnStateBetween(Integer value1, Integer value2) {
            addCriterion("return_state between", value1, value2, "returnState");
            return (Criteria) this;
        }

        public Criteria andReturnStateNotBetween(Integer value1, Integer value2) {
            addCriterion("return_state not between", value1, value2, "returnState");
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