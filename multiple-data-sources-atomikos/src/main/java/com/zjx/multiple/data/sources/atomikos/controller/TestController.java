package com.zjx.multiple.data.sources.atomikos.controller;

import com.zjx.multiple.data.sources.atomikos.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zjx
 * @version 1.0
 * @date 2020/6/21 21:36
 */
@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @RequestMapping("/list")
    public Object list() {

        testService.test();

        return 1;
    }


}
