package com.baizhi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "article")
public class Article implements Serializable {
    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer id;
    private String title;
    private String insert_img;
    private String content;
    private Date pub_date;
}
