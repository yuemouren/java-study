package com.ujiuye.springboot.bean;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
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
public class Student extends Model<Student> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "stuid", type = IdType.AUTO)
    private Integer stuid;
    private String stuname;
    @TableField(value = "mc_fk")
    private Integer mcFk;


    public Integer getStuid() {
        return stuid;
    }

    public void setStuid(Integer stuid) {
        this.stuid = stuid;
    }

    public String getStuname() {
        return stuname;
    }

    public void setStuname(String stuname) {
        this.stuname = stuname;
    }

    public Integer getMcFk() {
        return mcFk;
    }

    public void setMcFk(Integer mcFk) {
        this.mcFk = mcFk;
    }

    @Override
    protected Serializable pkVal() {
        return this.stuid;
    }

    @Override
    public String toString() {
        return "Student{" +
                ", stuid=" + stuid +
                ", stuname=" + stuname +
                ", mcFk=" + mcFk +
                "}";
    }
}
