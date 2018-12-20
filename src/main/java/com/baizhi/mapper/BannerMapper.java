package com.baizhi.mapper;

import com.baizhi.entity.Banner;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;


public interface BannerMapper extends Mapper<Banner> {
    //分页查询
    //查询总数据行数
    //  public Integer selectCount();

    //查询当前页的数据的总数--curPage：当前页数--pageSize：当前页查询到的数据行数
    public List<Banner> selectByPage(@Param("curPage") Integer curPage, @Param("pageSize") Integer pageSize);
}
