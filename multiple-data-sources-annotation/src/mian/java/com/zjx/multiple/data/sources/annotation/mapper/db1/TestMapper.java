package com.zjx.multiple.data.sources.annotation.mapper.db1;

import com.zjx.multiple.data.sources.annotation.commons.BaseMapper;
import com.zjx.multiple.data.sources.annotation.config.DataSource;
import com.zjx.multiple.data.sources.annotation.domain.db1.Test;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TestMapper extends BaseMapper<Test> {


    List<Test> findTestAll();

}