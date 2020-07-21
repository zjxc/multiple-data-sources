package com.zjx.multiple.data.sources.seata.mapper;

import com.zjx.multiple.data.sources.seata.commons.BaseMapper;
import com.zjx.multiple.data.sources.seata.domain.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ProductMapper extends BaseMapper<Product> {

    /**
     * 获取库存
     *
     * @param productId 商品编号
     * @return 库存
     */
    Integer getStock(@Param("productId") Long productId);

    /**
     * 扣减库存
     *
     * @param productId 商品编号
     * @param amount    扣减数量
     * @return 影响记录行数
     */
    int reduceStock(@Param("productId") Long productId, @Param("amount") Integer amount);
}