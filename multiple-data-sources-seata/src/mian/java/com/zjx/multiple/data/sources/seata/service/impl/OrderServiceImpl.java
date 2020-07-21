package com.zjx.multiple.data.sources.seata.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.zjx.multiple.data.sources.seata.domain.Orders;
import com.zjx.multiple.data.sources.seata.mapper.OrdersMapper;
import com.zjx.multiple.data.sources.seata.service.AccountService;
import com.zjx.multiple.data.sources.seata.service.OrderService;
import com.zjx.multiple.data.sources.seata.service.ProductService;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private OrdersMapper orderMapper;

    @Autowired
    private AccountService accountService;

    @Autowired
    private ProductService productService;

    @Override
    @DS(value = "order-ds")
    @GlobalTransactional
    public Integer createOrder(Long userId, Long productId, Integer price) throws Exception {
        Integer amount = 1;

        logger.info("[createOrder] 当前 XID: {}", RootContext.getXID());

        // 扣减库存
        productService.reduceStock(productId, amount);

        // 扣减余额
        accountService.reduceBalance(userId, price);

        // 保存订单
        Orders order = new Orders(null, userId, productId, amount * price, null, null);
        orderMapper.saveOrder(order);
        logger.info("[createOrder] 保存订单: {}", order.getId());

        // 返回订单编号
        return order.getId();
    }

}
