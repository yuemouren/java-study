package com.ujiuye.springboot.bean;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author wangyue
 * @since 2018-11-22
 */
public class School extends Model<School> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "schid", type = IdType.AUTO)
    private Integer schid;
    private String schname;


    public Integer getSchid() {
        return schid;
    }

    public void setSchid(Integer schid) {
        this.schid = schid;
    }

    public String getSchname() {
        return schname;
    }

    public void setSchname(String schname) {
        this.schname = schname;
    }

    @Override
    protected Serializable pkVal() {
        return this.schid;
    }

    @Override
    public String toString() {
        return "School{" +
                ", schid=" + schid +
                ", schname=" + schname +
                "}";
    }
}
