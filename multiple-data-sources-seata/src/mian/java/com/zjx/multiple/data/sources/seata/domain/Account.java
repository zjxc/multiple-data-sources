package com.zjx.multiple.data.sources.seata.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Data
@Table(name = "account")
public class Account implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    @Column(name = "balance")
    private Double balance;

    @Column(name = "last_update_time")
    private Date lastUpdateTime;

    private static final long serialVersionUID = 1L;
}