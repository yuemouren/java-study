package com.ujiuye.bean;

public class Role {
    private Integer roleid;

    private String rolename;

    private String roledescription;

    private Integer avlibal;

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename == null ? null : rolename.trim();
    }

    public String getRoledescription() {
        return roledescription;
    }

    public void setRoledescription(String roledescription) {
        this.roledescription = roledescription == null ? null : roledescription.trim();
    }

    public Integer getAvlibal() {
        return avlibal;
    }

    public void setAvlibal(Integer avlibal) {
        this.avlibal = avlibal;
    }
}