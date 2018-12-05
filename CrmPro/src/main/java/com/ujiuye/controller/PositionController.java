package com.ujiuye.controller;

import com.ujiuye.bean.Position;
import com.ujiuye.service.PositionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("position")
public class PositionController {

    @Resource
    private PositionService positionService;

    @RequestMapping("getAllPosition")
    public @ResponseBody
    List<Position> getAllPosition() {
        List<Position> list = positionService.getAllPosition();

        if (list != null) {
            return list;
        }
        return null;
    }
}
