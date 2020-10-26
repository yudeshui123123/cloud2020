package com.atguigu.service.fegin;

import org.springframework.stereotype.Component;

/**
 * TODO
 *
 * @author yds
 * @version 1.0
 * @date 2020/10/19 9:24
 * @description:
 */
@Component
public class PaymentFallBack8001 implements Payment8001Service{
    @Override
    public String getPayment(Integer id) {
        return "getPayment -- FallBack";
    }

    @Override
    public String getTimeOut() {
        return "getTimeOut -- FallBack";
    }
}
