package com.zjx.multiple.data.sources.annotation.domain.db2;

import lombok.Data;

@Data
public class TrafficArea {
    private Integer id;

    private String area;

    private String lon;

    private String lat;

    private String type;

    private Integer ind;
}