package com.zjx.multiple.data.sources.annotation.service.db2.impl;

import com.zjx.multiple.data.sources.annotation.config.DataSource;
import com.zjx.multiple.data.sources.annotation.domain.db2.TrafficArea;
import com.zjx.multiple.data.sources.annotation.mapper.db2.TrafficAreaMapper;
import com.zjx.multiple.data.sources.annotation.service.db2.ITrafficAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zjx
 * @version 1.0
 * @date 2020/7/15 23:34
 */
@Service
public class TrafficAreaServiceImpl implements ITrafficAreaService {
    @Autowired
    private TrafficAreaMapper trafficAreaMapper;

    @DataSource("DB2")
    @Override
    public List<TrafficArea> findAll() {
        return trafficAreaMapper.findAll();
    }

    @DataSource("DB2")
    @Override
    public int insert(TrafficArea trafficArea) {
        return trafficAreaMapper.insert(trafficArea);
    }

}
