package com.zjx.multiple.data.sources.annotation.service.db1;

import com.zjx.multiple.data.sources.annotation.domain.db1.Test;

import java.util.List;

/**
 * @author zjx
 * @version 1.0
 * @date 2020/6/21 21:39
 */
public interface ITestService {
    List<Test> findTestAll();

    List<Test> selectAll();


    int insert(Test test);
}
