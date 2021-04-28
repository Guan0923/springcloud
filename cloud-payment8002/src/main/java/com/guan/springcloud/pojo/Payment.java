package com.guan.springcloud.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author 管威宇
 * @version 1.0
 * @since 2021/4/16 10:18
 */
@TableName("payment")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment implements Serializable {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String serial;
}
