package com.ujiuye.springboot.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ujiuye.springboot.bean.Student;
import com.ujiuye.springboot.mapper.StudentMapper;
import com.ujiuye.springboot.service.StudentService;
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
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {

}
