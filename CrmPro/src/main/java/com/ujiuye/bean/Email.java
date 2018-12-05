package com.ujiuye.bean;

import java.util.Date;

public class Email {
    private Integer id;

    private String title;

    private String ename;

    private Date sendtime;

    private String content;

    private Integer sendEmpFk;

    private String path;

    private Integer receiveEmpFk;

    private Integer lookState;

    private Integer returnState;

    private Employee employee;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename == null ? null : ename.trim();
    }

    public Date getSendtime() {
        return sendtime;
    }

    public void setSendtime(Date sendtime) {
        this.sendtime = sendtime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getSendEmpFk() {
        return sendEmpFk;
    }

    public void setSendEmpFk(Integer sendEmpFk) {
        this.sendEmpFk = sendEmpFk;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }

    public Integer getReceiveEmpFk() {
        return receiveEmpFk;
    }

    public void setReceiveEmpFk(Integer receiveEmpFk) {
        this.receiveEmpFk = receiveEmpFk;
    }

    public Integer getLookState() {
        return lookState;
    }

    public void setLookState(Integer lookState) {
        this.lookState = lookState;
    }

    public Integer getReturnState() {
        return returnState;
    }

    public void setReturnState(Integer returnState) {
        this.returnState = returnState;
    }
}