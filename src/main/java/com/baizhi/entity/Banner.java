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
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "banner")
public class Banner implements Serializable {
    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer id;
    private String title;
    private String img_path;
    private Date pub_date;
    private String description;
    private String status;
}
