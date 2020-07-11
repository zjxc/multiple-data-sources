package com.zjx.multiple.data.sources.atomikos.commons;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author zjx
 * @version 1.0
 * @date 2020/6/1 15:44
 */
public interface BaseMapper<T> extends Mapper<T>, MySqlMapper<T> {

}
