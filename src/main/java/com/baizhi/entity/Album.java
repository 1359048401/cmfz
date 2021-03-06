package com.baizhi.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelCollection;
import cn.afterturn.easypoi.excel.annotation.ExcelIgnore;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "album")
@ExcelTarget("album")
public class Album implements Serializable {
    @Id
    @KeySql(useGeneratedKeys = true)
    @ExcelIgnore
    private Integer id;
    @Excel(name = "标题", needMerge = true)
    private String title;
    @ExcelIgnore
    private Integer count;
    @Excel(name = "封面", type = 2, needMerge = true, mergeVertical = true)
    private String cover_img;
    @ExcelIgnore
    private Integer score;
    @ExcelIgnore
    private String author;
    @ExcelIgnore
    private String broadcast;
    @ExcelIgnore
    private String brief;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JSONField(format = "yyyy-MM-dd")
    @ExcelIgnore
    private Date pub_date;
    @ExcelCollection(name = "章节")
    @Transient
    private List<Chapter> children;
}
