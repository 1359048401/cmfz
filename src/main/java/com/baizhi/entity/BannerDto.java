package com.baizhi.entity;

import lombok.Data;

import javax.persistence.Transient;
import java.io.Serializable;
import java.util.List;

@Data
public class BannerDto implements Serializable {
    @Transient
    private List<Banner> rows;
    @Transient
    private Integer total;
}
