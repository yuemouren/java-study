package com.ujiuye.controller;

import com.ujiuye.bean.Analysis;
import com.ujiuye.service.AnalysisService;
import com.ujiuye.util.Message;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("analysis")
public class AnalysisController {

    @Resource
    private AnalysisService analysisService;

    @RequestMapping("saveAnalysis")
    public @ResponseBody
    Message saveAnalysis(Analysis analysis) {
        boolean b = analysisService.saveAnalysis(analysis);
        Message m = new Message();
        if (b) {
            m.setFlag(true);
            m.setMessage("添加成功");
        } else {
            m.setFlag(false);
            m.setMessage("添加失败");
        }
        return m;
    }

    @RequestMapping("getAnalAndMod")
    public @ResponseBody
    Analysis getAnalAndMod(int pid) {
        Analysis analAndMod = analysisService.getAnalAndMod(pid);
        if (analAndMod != null) {
            return analAndMod;
        }
        return null;
    }

}
