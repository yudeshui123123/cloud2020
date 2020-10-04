package com.atguigu.cloudapicommons.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * TODO
 *
 * @author yds
 * @version 1.0
 * @date 2020/10/2 17:25
 * @description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
    private long id;
    private String serial;
}
