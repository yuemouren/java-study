package com.ujiuye.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ujiuye.bean.ProCatExample;
import com.ujiuye.bean.ProCatKey;


public interface ProCatMapper {
    int countByExample(ProCatExample example);

    int deleteByExample(ProCatExample example);

    int deleteByPrimaryKey(ProCatKey key);

    int insert(ProCatKey record);

    int insertSelective(ProCatKey record);

    List<ProCatKey> selectByExample(ProCatExample example);

    int updateByExampleSelective(@Param("record") ProCatKey record, @Param("example") ProCatExample example);

    int updateByExample(@Param("record") ProCatKey record, @Param("example") ProCatExample example);

  
}