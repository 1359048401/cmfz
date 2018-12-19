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
@Table(name = "task")
public class Task implements Serializable {
    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer id;
    private String title;
    private String mark;
    private Date date;
    private Integer user_id;
}
