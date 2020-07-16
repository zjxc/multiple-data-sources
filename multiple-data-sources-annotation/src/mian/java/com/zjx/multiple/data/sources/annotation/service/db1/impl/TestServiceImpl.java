package com.zjx.multiple.data.sources.annotation.service.db1.impl;

import com.zjx.multiple.data.sources.annotation.domain.db1.Test;
import com.zjx.multiple.data.sources.annotation.mapper.db1.TestMapper;
import com.zjx.multiple.data.sources.annotation.mapper.db2.TrafficAreaMapper;
import com.zjx.multiple.data.sources.annotation.service.db1.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zjx
 * @version 1.0
 * @date 2020/6/21 21:40
 */
@Service
public class TestServiceImpl implements ITestService {


    @Autowired
    private TestMapper testMapper;

    @Override
    public List<Test> findTestAll() {
        return testMapper.findTestAll();
    }

    @Override
    public List<Test> selectAll() {
        return testMapper.selectAll();
    }

    @Override
    public int insert(Test test) {
        return testMapper.insert(test);
    }
}
