package com.zjx.multiple.data.sources.seata.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import lombok.Data;

@Data
@Table(name = "product")
public class Product implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    @Column(name = "stock")
    private Integer stock;

    @Column(name = "last_update_time")
    private Date lastUpdateTime;

    private static final long serialVersionUID = 1L;
}