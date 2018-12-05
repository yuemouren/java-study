package com.ujiuye.controller;

import com.ujiuye.bean.Attachment;
import com.ujiuye.service.AttachmentService;
import com.ujiuye.util.Message;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("attachment")
public class AttachmentController {

    @Resource
    private AttachmentService attachmentService;

    @RequestMapping("saveAttachment")
    public String saveAttachment(@RequestParam("uploadfile") MultipartFile[] uploadfile, Attachment attachment) {
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
                attachment.setPath(filename);
            }
        }
        boolean b = attachmentService.saveAttachment(attachment);
        if (b) {
            return "redirect:../project-file.jsp";
        } else {
            return "redirect:../error.jsp";
        }

    }

}
