package com.ujiuye.springboot.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ujiuye.springboot.bean.Mc;
import com.ujiuye.springboot.mapper.McMapper;
import com.ujiuye.springboot.service.McService;
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
public class McServiceImpl extends ServiceImpl<McMapper, Mc> implements McService {

}
