package com.zjx.multiple.data.sources.annotation.service.db2;

import com.zjx.multiple.data.sources.annotation.domain.db2.TrafficArea;

import java.util.List;

/**
 * @author zjx
 * @version 1.0
 * @date 2020/6/21 21:39
 */
public interface ITrafficAreaService {
    List<TrafficArea> findAll();

    int insert(TrafficArea trafficArea);
}
