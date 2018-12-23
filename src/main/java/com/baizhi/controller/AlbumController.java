package com.baizhi.controller;

import com.baizhi.entity.Album;
import com.baizhi.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("album")
public class AlbumController {

    @Autowired
    private AlbumService albumService;

    @RequestMapping("queryAll")
    public List<Album> queryAll() {
        return albumService.queryAll();
    }

    @RequestMapping("queryById")
    public Album queryById(Integer id) {
        return albumService.queryById(id);
    }

    @RequestMapping("insert")
    public void insert(Album album, MultipartFile file2, HttpSession session) throws IOException {
        ServletContext ctx = session.getServletContext();
        String realPath = ctx.getRealPath("/album");
        //目标文件
        File descFile = new File(realPath + "/" + file2.getOriginalFilename());
        //上传文件
        file2.transferTo(descFile);

        album.setCover_img("/album/" + file2.getOriginalFilename());
        System.out.println(album);
        albumService.insert(album);
    }

}
