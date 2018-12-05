package com.ujiuye.mapper;

import com.ujiuye.bean.Usermannger;
import com.ujiuye.bean.UsermanngerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UsermanngerMapper {
    int countByExample(UsermanngerExample example);

    int deleteByExample(UsermanngerExample example);

    int deleteByPrimaryKey(Integer userid);

    int insert(Usermannger record);

    int insertSelective(Usermannger record);

    List<Usermannger> selectByExample(UsermanngerExample example);

    Usermannger selectByPrimaryKey(Integer userid);

    int updateByExampleSelective(@Param("record") Usermannger record, @Param("example") UsermanngerExample example);

    int updateByExample(@Param("record") Usermannger record, @Param("example") UsermanngerExample example);

    int updateByPrimaryKeySelective(Usermannger record);

    int updateByPrimaryKey(Usermannger record);
    
    Usermannger login(@Param("username") String username,@Param("password") String password);
}