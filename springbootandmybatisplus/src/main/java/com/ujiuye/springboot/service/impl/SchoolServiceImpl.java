package com.ujiuye.springboot.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ujiuye.springboot.bean.School;
import com.ujiuye.springboot.mapper.SchoolMapper;
import com.ujiuye.springboot.service.SchoolService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author wangyue
 * @since 2018-11-22
 */
@Service
public class SchoolServiceImpl extends ServiceImpl<SchoolMapper, School> implements SchoolService {

}
