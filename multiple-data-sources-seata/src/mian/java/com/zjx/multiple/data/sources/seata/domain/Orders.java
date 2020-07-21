package com.zjx.multiple.data.sources.seata.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Table(name = "orders")
public class Orders implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "pay_amount")
    private Integer payAmount;

    @Column(name = "add_time")
    private Date addTime;

    @Column(name = "last_update_time")
    private Date lastUpdateTime;

    private static final long serialVersionUID = 1L;
}