package com.zjx.multiple.data.sources.atomikos.mapper.db2;

import com.zjx.multiple.data.sources.atomikos.commons.BaseMapper;
import com.zjx.multiple.data.sources.atomikos.domain.db2.TrafficArea;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author zjx
 * @version 1.0
 * @date 2020/5/18 19:48
 */
@Component
public interface TrafficAreaMapper extends BaseMapper<TrafficArea> {

    List<TrafficArea> findAll();
}