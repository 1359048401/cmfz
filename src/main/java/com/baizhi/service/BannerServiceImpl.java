package com.baizhi.service;

import com.baizhi.entity.Banner;
import com.baizhi.entity.BannerDto;
import com.baizhi.mapper.BannerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BannerServiceImpl implements BannerService {

    @Autowired
    private BannerMapper bannerMapper;

    @Override
    public List<Banner> queryAllBanner() {
        List<Banner> list = bannerMapper.selectAll();
        return list;
    }

    @Override
    public void updateBanner(Banner banner) {
        bannerMapper.updateByPrimaryKey(banner);
    }

    @Override
    public void insertBanner(Banner banner) {
        bannerMapper.insert(banner);
    }

    @Override
    public void deleteBanner(Integer id) {
        bannerMapper.deleteByPrimaryKey(id);
    }

    @Override
    public BannerDto queryByPage(Integer curPage, Integer pageSize) {
        BannerDto dto = new BannerDto();
        dto.setTotal(bannerMapper.selectCount());
        dto.setRows(bannerMapper.selectByPage(curPage, pageSize));
        System.out.println(dto);
        return dto;
    }
}
