package com.zjx.multiple.data.sources.atomikos.mapper.db1;

import com.zjx.multiple.data.sources.atomikos.commons.BaseMapper;
import com.zjx.multiple.data.sources.atomikos.domain.db1.Test;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TestMapper extends BaseMapper<Test> {

    List<Test> findTestAll();


}