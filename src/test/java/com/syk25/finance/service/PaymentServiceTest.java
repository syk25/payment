package com.syk25.finance.service;

import com.syk25.finance.dto.PaymentRequest;
import com.syk25.finance.dto.PaymentResponse;
import com.syk25.finance.type.Authorization;
import com.syk25.finance.type.Store;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PaymentServiceTest {
    PaymentService paymentService = new PaymentService();

    @Test
    public void name() {
        // given
        PaymentRequest paymentRequest = new PaymentRequest(Store.GS25, 100);

        // when
        PaymentResponse paymentResponse = paymentService.pay(paymentRequest);

        // then
        assertEquals(Authorization.AUTHORIZED, paymentResponse.getAuthorization());
        assertEquals(100,paymentResponse.getRespondedAmount());
    }


}