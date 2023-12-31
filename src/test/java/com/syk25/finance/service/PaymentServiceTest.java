package com.syk25.finance.service;

import com.syk25.finance.config.ApplicationConfig;
import com.syk25.finance.dto.PaymentRequest;
import com.syk25.finance.dto.PaymentResponse;
import com.syk25.finance.type.Authorization;
import com.syk25.finance.type.PayMethod;
import com.syk25.finance.type.Store;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

class PaymentServiceTest {
    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfig.class);
    PaymentService paymentService = applicationContext.getBean("paymentService", PaymentService.class);

    @Test
    public void pay_authorized() {
        // given
        PaymentRequest paymentRequest = new PaymentRequest(PayMethod.CASH, Store.GS25, 100);

        // when
        PaymentResponse paymentResponse = paymentService.pay(paymentRequest);

        // then
        assertEquals(Authorization.AUTHORIZED, paymentResponse.getAuthorization());
        assertEquals(100,paymentResponse.getRespondedAmount());
    }




}