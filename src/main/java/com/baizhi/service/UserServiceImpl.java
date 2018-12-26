package com.baizhi.service;

import com.baizhi.entity.Province;
import com.baizhi.entity.User;
import com.baizhi.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> queryAll() {
        List<User> list = userMapper.selectAll();
        return list;
    }

    @Override
    public List<Integer> queryActiveUser() {
        List<Integer> list = new ArrayList<>();
        list.add(userMapper.queryPersonByActive(7));
        list.add(userMapper.queryPersonByActive(14));
        list.add(userMapper.queryPersonByActive(21));
        return list;
    }

    @Override
    public List<Province> queryUserProvince() {
        List<Province> list = userMapper.countUserProvince();
        return list;
    }
}
