package com.baizhi.service;

import com.baizhi.entity.Album;
import com.baizhi.mapper.AlbumMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AlbumServiceImpl implements AlbumService {

    @Autowired
    private AlbumMapper albumMapper;

    @Override
    public List<Album> queryAll() {
        List<Album> albums = albumMapper.queryAll();
        return albums;
    }

    @Override
    public Album queryById(Integer id) {
        Album t = new Album();
        t.setId(id);
        Album album = albumMapper.selectOne(t);
        System.out.println(album);
        return album;
    }

    @Override
    public void insert(Album album) {
        albumMapper.insert(album);
    }
}
