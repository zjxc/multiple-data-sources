package com.zjx.multiple.data.sources.annotation.controller;

import com.zjx.multiple.data.sources.annotation.domain.db1.Test;
import com.zjx.multiple.data.sources.annotation.domain.db2.TrafficArea;
import com.zjx.multiple.data.sources.annotation.service.db1.ITestService;
import com.zjx.multiple.data.sources.annotation.service.db2.ITrafficAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zjx
 * @version 1.0
 * @date 2020/6/21 21:36
 */
@RestController
public class TestController {

    @Autowired
    private ITestService testService;
    @Autowired
    private ITrafficAreaService trafficAreaService;

    @RequestMapping("/list")
    public Object list() {
        List<Test> testAll = testService.findTestAll();
        List<Test> testAll2 = testService.selectAll();
        List<TrafficArea> all = trafficAreaService.findAll();

        Test test = new Test();
        test.setCk("2");
        test.setJd("2");
        test.setMyd("2");
        testService.insert(test);

        int i = 1 / 0;

        TrafficArea trafficArea = new TrafficArea();
        trafficArea.setId(3);
        trafficArea.setArea("dcesd");
        trafficAreaService.insert(trafficArea);

        System.out.println(1);

        return 1;
    }


}
