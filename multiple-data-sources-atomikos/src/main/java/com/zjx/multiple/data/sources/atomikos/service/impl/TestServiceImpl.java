package com.zjx.multiple.data.sources.atomikos.service.impl;

import com.zjx.multiple.data.sources.atomikos.domain.db1.Test;
import com.zjx.multiple.data.sources.atomikos.domain.db2.TrafficArea;
import com.zjx.multiple.data.sources.atomikos.mapper.db1.TestMapper;
import com.zjx.multiple.data.sources.atomikos.mapper.db2.TrafficAreaMapper;
import com.zjx.multiple.data.sources.atomikos.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author zjx
 * @version 1.0
 * @date 2020/6/21 21:40
 */
@Service
public class TestServiceImpl implements TestService {


    @Autowired
    private TestMapper testMapper;
    @Autowired
    private TrafficAreaMapper trafficAreaMapper;


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void test() {
        List<Test> testAll = testMapper.findTestAll();
        List<Test> tests = testMapper.selectAll();
        List<TrafficArea> all = trafficAreaMapper.findAll();

        Test test = new Test();
        test.setCk("2");
        test.setJd("2");
        test.setMyd("2");
        testMapper.insert(test);

        int i = 1 / 0;

        TrafficArea trafficArea = new TrafficArea();
        trafficArea.setId(3);
        trafficArea.setArea("dcesd");
        trafficAreaMapper.insert(trafficArea);



        System.out.println(1);


    }
}
