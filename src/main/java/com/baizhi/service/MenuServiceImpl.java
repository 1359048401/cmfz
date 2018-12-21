package com.baizhi.service;

import com.baizhi.entity.Menu;
import com.baizhi.mapper.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public List<Menu> queryAll() {
        List<Menu> list = menuMapper.selectAll();
        return list;
    }

    @Override
    public List<Menu> queryByParentId(Integer parent_id) {
        Menu menu1 = new Menu();
        menu1.setParent_id(parent_id);
        List<Menu> menus = menuMapper.select(menu1);
        return menus;
    }
}
