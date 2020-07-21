package com.zjx.multiple.data.sources.seata.mapper;

import com.zjx.multiple.data.sources.seata.commons.BaseMapper;
import com.zjx.multiple.data.sources.seata.domain.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface AccountMapper extends BaseMapper<Account> {


    /**
     * 获取账户余额
     *
     * @param userId 用户 ID
     * @return 账户余额
     */
    Integer getBalance(@Param("userId") Long userId);

    /**
     * 扣减余额
     *
     * @param price 需要扣减的数目
     * @return 影响记录行数
     */
    int reduceBalance(@Param("price") Integer price);


}