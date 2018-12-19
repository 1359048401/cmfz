package com.baizhi.service;

import com.baizhi.entity.Admin;

public interface AdminService {
    public Admin queryByName(String name, String password);
}
