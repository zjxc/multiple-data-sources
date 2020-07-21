package com.zjx.multiple.data.sources.seata.mapper;

import com.zjx.multiple.data.sources.seata.commons.BaseMapper;
import com.zjx.multiple.data.sources.seata.domain.Orders;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface OrdersMapper extends BaseMapper<Orders> {

    /**
     * 插入订单记录
     *
     * @param order 订单
     * @return 影响记录数量
     */
    int saveOrder(Orders order);
}