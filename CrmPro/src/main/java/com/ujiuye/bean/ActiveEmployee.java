package com.ujiuye.bean;

import java.util.List;

public class ActiveEmployee {

    private int eid;
    private String name;
    private List<Auth> parents;
    private List<Auth> childs;

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Auth> getParents() {
        return parents;
    }

    public void setParents(List<Auth> parents) {
        this.parents = parents;
    }

    public List<Auth> getChilds() {
        return childs;
    }

    public void setChilds(List<Auth> childs) {
        this.childs = childs;
    }
}
