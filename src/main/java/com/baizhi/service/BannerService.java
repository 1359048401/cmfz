package com.baizhi.service;

import com.baizhi.entity.Banner;
import com.baizhi.entity.BannerDto;

import java.util.List;

public interface BannerService {
    public List<Banner> queryAllBanner();

    public void updateBanner(Banner banner);

    public void insertBanner(Banner banner);

    public void deleteBanner(Integer id);

    public BannerDto queryByPage(Integer curPage, Integer pageSize);
}
