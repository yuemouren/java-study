package com.ujiuye.springboot.controller;

import com.ujiuye.springboot.bean.Mc;
import com.ujiuye.springboot.bean.School;
import com.ujiuye.springboot.bean.StuSch;
import com.ujiuye.springboot.bean.Student;
import com.ujiuye.springboot.service.McService;
import com.ujiuye.springboot.service.SchoolService;
import com.ujiuye.springboot.service.StuSchService;
import com.ujiuye.springboot.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class McController {

    @Resource
    private McService mcService;
    @Resource
    private SchoolService schoolService;
    @Resource
    private StudentService studentService;
    @Resource
    private StuSchService stuSchService;


    @RequestMapping("test")
    @ResponseBody
    public String test(){
       /* List<Mc> mcs = mcService.selectList(null);*/
        //List<School> schools = schoolService.selectList(null);
        List<Student> students = studentService.selectList(null);
        //List<StuSch> stuSches = stuSchService.selectList(null);
        System.out.println(students.size());
        return "aaa";
    }
}
