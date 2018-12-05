package com.ujiuye.service.impl;

import com.ujiuye.bean.Attachment;
import com.ujiuye.mapper.AttachmentMapper;
import com.ujiuye.service.AttachmentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AttachmentServiceImpl implements AttachmentService {

    @Resource
    private AttachmentMapper attachmentMapper;

    @Override
    public boolean saveAttachment(Attachment attachment) {
        int insert = attachmentMapper.insert(attachment);
        if (insert > 0) {
            return true;
        }
        return false;
    }
}
