package com.ujiuye.springboot.mapper;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.ujiuye.springboot.bean.Mc;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author wangyue
 * @since 2018-11-22
 */
@Mapper
public interface McMapper extends BaseMapper<Mc> {

}
