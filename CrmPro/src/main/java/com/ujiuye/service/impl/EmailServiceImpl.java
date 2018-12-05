package com.ujiuye.service.impl;

import com.ujiuye.bean.Email;
import com.ujiuye.mapper.EmailMapper;
import com.ujiuye.service.EmailService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class EmailServiceImpl implements EmailService {

    @Resource
    private EmailMapper emailMapper;

    @Override
    @Transactional
    public boolean saveEmail(Email email, Integer eid) {
        int i = 0;
        if (eid != null) {
            Email newe = new Email();
            newe.setId(eid);
            newe.setLookState(1);
            newe.setReturnState(1);
            i = emailMapper.updateByPrimaryKeySelective(newe);
            email.setLookState(0);
            email.setReturnState(0);
        } else {
            i = 1;
        }
        int insert = emailMapper.insertSelective(email);
        if (insert + i > 1) {
            return true;
        }
        return false;
    }
}
