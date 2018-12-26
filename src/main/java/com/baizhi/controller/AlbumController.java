package com.baizhi.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.baizhi.entity.Album;
import com.baizhi.entity.Chapter;
import com.baizhi.service.AlbumService;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileOutputStream;
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

    @RequestMapping("exportAlbum")
    public void exportAlbum(HttpSession session) {
        ServletContext ctx = session.getServletContext();
        String realPath = ctx.getRealPath("");
        System.out.println(realPath);
        List<Album> albums = albumService.queryAll();
        for (Album album : albums) {
            for (Chapter chapter : album.getChildren()) {
                String cPath = chapter.getUrl().replaceFirst("/", "");
                String chapterPath = cPath.replace("/", "\\");
                chapter.setUrl(realPath + "" + chapterPath);
                System.out.println(chapter);
            }
            String aPath = album.getCover_img().replaceFirst("/", "");
            String albumPath = aPath.replace("/", "\\");
            album.setCover_img(realPath + "" + albumPath);
            System.out.println(album);
        }
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("专辑详情", "专辑信息"), Album.class, albums);
        try {
            workbook.write(new FileOutputStream(new File("D:/album.xlsx")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
