package com.ujiuye.bean;

import java.io.Serializable;

public class Customer implements Serializable {
    private Integer id;

    private String comname;

    private String companyperson;

    private String comaddress;

    private String comphone;

    private String camera;

    private String present;

    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getComname() {
        return comname;
    }

    public void setComname(String comname) {
        this.comname = comname == null ? null : comname.trim();
    }

    public String getCompanyperson() {
        return companyperson;
    }

    public void setCompanyperson(String companyperson) {
        this.companyperson = companyperson == null ? null : companyperson.trim();
    }

    public String getComaddress() {
        return comaddress;
    }

    public void setComaddress(String comaddress) {
        this.comaddress = comaddress == null ? null : comaddress.trim();
    }

    public String getComphone() {
        return comphone;
    }

    public void setComphone(String comphone) {
        this.comphone = comphone == null ? null : comphone.trim();
    }

    public String getCamera() {
        return camera;
    }

    public void setCamera(String camera) {
        this.camera = camera == null ? null : camera.trim();
    }

    public String getPresent() {
        return present;
    }

    public void setPresent(String present) {
        this.present = present == null ? null : present.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}