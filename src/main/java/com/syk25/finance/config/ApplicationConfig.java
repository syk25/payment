package com.syk25.finance.config;

import com.syk25.finance.service.PaymentService;
import com.syk25.finance.service.adapters.CardAdapter;
import com.syk25.finance.service.adapters.CashAdapter;
import com.syk25.finance.service.discount_policy.DiscountByPayMethod;
import com.syk25.finance.service.discount_policy.DiscountByStore;

import java.util.Arrays;
import java.util.HashSet;

public class ApplicationConfig {

    // 서비스 객체 외부에서 객체의 의존성을 결정할 수 있음
    public PaymentService paymentServiceFollowingDiscountByPayMethod(){
        return new PaymentService(
                new HashSet<>(
                        Arrays.asList(new CashAdapter(), new CardAdapter())
                ),
                new DiscountByPayMethod()
        );
    }

    public PaymentService paymentServiceFollowingDiscountByStore(){
        return new PaymentService(
                new HashSet<>(
                        Arrays.asList(new CashAdapter(), new CardAdapter())
                ),
                new DiscountByStore()
        );
    }


}
