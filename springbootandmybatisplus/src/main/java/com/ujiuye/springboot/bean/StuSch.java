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
public class StuSch extends Model<StuSch> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private Integer stuFk;
    private Integer schFk;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStuFk() {
        return stuFk;
    }

    public void setStuFk(Integer stuFk) {
        this.stuFk = stuFk;
    }

    public Integer getSchFk() {
        return schFk;
    }

    public void setSchFk(Integer schFk) {
        this.schFk = schFk;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "StuSch{" +
                ", id=" + id +
                ", stuFk=" + stuFk +
                ", schFk=" + schFk +
                "}";
    }
}
