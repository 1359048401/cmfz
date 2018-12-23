package com.baizhi.service;

import com.baizhi.entity.Album;

import java.util.List;

public interface AlbumService {
    public List<Album> queryAll();

    public Album queryById(Integer id);

    public void insert(Album album);
}
