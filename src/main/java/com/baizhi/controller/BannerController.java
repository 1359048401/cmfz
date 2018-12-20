package com.baizhi.controller;

import com.baizhi.entity.Banner;
import com.baizhi.service.BannerService;
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
@RequestMapping("banner")
public class BannerController {

    @Autowired
    private BannerService bannerService;

    @RequestMapping("queryAll")
    public List<Banner> queryAllBanner() {
        return bannerService.queryAllBanner();
    }

    @RequestMapping("update")
    public void updateBanner(Banner banner) {
        bannerService.updateBanner(banner);
    }

    @RequestMapping("insert")
    public void insertBanner(Banner banner, MultipartFile file1, HttpSession session) throws IOException {
        ServletContext ctx = session.getServletContext();
        String realPath = ctx.getRealPath("/banner_img");
        //目标文件
        File descFile = new File(realPath + "/" + file1.getOriginalFilename());
        //上传文件
        file1.transferTo(descFile);

        banner.setImg_path("/banner_img/" + file1.getOriginalFilename());
        System.out.println(banner);
        bannerService.insertBanner(banner);
    }

    @RequestMapping("delete")
    public void deleteBanner(Integer id) {
        bannerService.deleteBanner(id);
    }
}
