package com.syk25.finance.config;

import com.syk25.finance.service.PaymentService;
import com.syk25.finance.service.adapters.CardAdapter;
import com.syk25.finance.service.adapters.CashAdapter;
import com.syk25.finance.service.discount_policy.DiscountByPayMethod;
import com.syk25.finance.service.discount_policy.DiscountByStore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.HashSet;

@Configuration
public class ApplicationConfig {

    // 서비스 객체 외부에서 객체의 의존성을 결정할 수 있음
    @Bean
    public PaymentService paymentService() {
        return new PaymentService(
                new HashSet<>(
                        Arrays.asList(cashAdapter(), cardAdapter())
                ),
                discountByPayMethod()
        );
    }

    @Bean
    public CardAdapter cardAdapter() {
        return new CardAdapter();
    }

    @Bean
    public CashAdapter cashAdapter() {
        return new CashAdapter();
    }

    @Bean
    public DiscountByStore discountByStore() {
        return new DiscountByStore();
    }

    @Bean
    public DiscountByPayMethod discountByPayMethod(){
        return new DiscountByPayMethod();
    }

    @Bean
    public PaymentService paymentService2() {
        return new PaymentService(
                new HashSet<>(
                        Arrays.asList(cashAdapter(), cardAdapter())
                ),
                new DiscountByStore()
        );
    }


}
