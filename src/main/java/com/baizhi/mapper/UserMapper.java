package com.baizhi.mapper;

import com.baizhi.entity.Province;
import com.baizhi.entity.User;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;


public interface UserMapper extends Mapper<User> {
    //活跃用户
    public Integer queryPersonByActive(Integer days);

    //按照省份查询
    //查询所在省份的人数
    public List<Province> countUserProvince();

    //
    public Integer queryPersonByProvince();
}
