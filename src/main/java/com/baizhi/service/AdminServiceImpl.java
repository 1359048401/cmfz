package com.baizhi.service;

import com.baizhi.entity.Admin;
import com.baizhi.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Admin queryByName(String name, String password) {
        Admin ad = new Admin();
        ad.setName(name);
        Admin admin = adminMapper.selectOne(ad);
        if (admin == null) {
            throw new RuntimeException("账户不存在！");
        } else if (!password.equals(admin.getPassword())) {
            throw new RuntimeException("密码错误！");
        }
        return admin;
    }
}
