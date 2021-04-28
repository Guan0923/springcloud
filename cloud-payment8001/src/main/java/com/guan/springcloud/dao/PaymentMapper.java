package com.guan.springcloud.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.guan.springcloud.pojo.Payment;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 管威宇
 * @version 1.0
 * @since 2021/4/16 10:18
 */
@Mapper
public interface PaymentMapper extends BaseMapper<Payment> {
}
