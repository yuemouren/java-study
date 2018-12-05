package com.ujiuye.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ujiuye.bean.Orderitem;
import com.ujiuye.bean.OrderitemExample;
import com.ujiuye.bean.OrderitemVo;

public interface OrderitemMapper {
    int countByExample(OrderitemExample example);

    int deleteByExample(OrderitemExample example);

    int deleteByPrimaryKey(Integer itemid);

    int insert(Orderitem record);

    int insertSelective(Orderitem record);

    List<Orderitem> selectByExample(OrderitemExample example);

    Orderitem selectByPrimaryKey(Integer itemid);

    int updateByExampleSelective(@Param("record") Orderitem record, @Param("example") OrderitemExample example);

    int updateByExample(@Param("record") Orderitem record, @Param("example") OrderitemExample example);

    int updateByPrimaryKeySelective(Orderitem record);

    int updateByPrimaryKey(Orderitem record);
    
    List<Orderitem> getOrderitemByOid(@Param("oid") int oid);
    
    List<OrderitemVo> getOrderitemVo();
}