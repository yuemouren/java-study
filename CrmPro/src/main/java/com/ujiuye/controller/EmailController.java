package com.ujiuye.controller;

import com.ujiuye.bean.ActiveEmployee;
import com.ujiuye.bean.Email;
import com.ujiuye.service.EmailService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;

@Controller
@RequestMapping("email")
public class EmailController {

    @Resource
    private EmailService emailService;

    @RequestMapping("saveEmail")
    public String saveEmail(@RequestParam("uploadfile") MultipartFile[] uploadfile, Email email, Integer eid, HttpSession session) {
        String path = "D:\\mypicture\\";
        for (MultipartFile mf : uploadfile) {
            if (mf.getSize() > 0) {
                String filename = mf.getOriginalFilename();
                File file = new File(path + filename);
                try {
                    mf.transferTo(file);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                email.setPath(filename);
            }
        }
        ActiveEmployee activeEmployee = (ActiveEmployee) session.getAttribute("activeEmployee");
        email.setSendEmpFk(activeEmployee.getEid());
        email.setSendtime(new Date());
        boolean b = emailService.saveEmail(email, eid);
        if (b) {
            return "redirect:../message.jsp";
        } else {
            return "redirect:../error.jsp";
        }
    }
}
