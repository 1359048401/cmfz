package com.baizhi.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelIgnore;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "chapter")
public class Chapter implements Serializable {
    @Id
    @Excel(name = "编号")
    @ExcelIgnore
    private String id;
    @Excel(name = "标题", width = 15)
    private String title;
    @Excel(name = "文件大小")
    private String size;
    @Excel(name = "时长")
    private String duration;
    @Excel(name = "路径", width = 30)
    private String url;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JSONField(format = "yyyy-MM-dd")
    @Excel(name = "上传日期", format = "yyyy年MM月dd日", width = 20)
    private Date upload_date;
    @ExcelIgnore
    private Integer a_id;
}
