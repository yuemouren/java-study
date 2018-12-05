package com.ujiuye.service.impl;

import com.ujiuye.bean.Position;
import com.ujiuye.mapper.PositionMapper;
import com.ujiuye.service.PositionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PositionServiceImpl implements PositionService {

    @Resource
    private PositionMapper positionMapper;

    @Override
    public List<Position> getAllPosition() {
        return positionMapper.selectByExample(null);
    }
}
