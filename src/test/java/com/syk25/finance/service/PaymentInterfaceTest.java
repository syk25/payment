package com.syk25.finance.service;

import com.syk25.finance.dto.PaymentRequest;
import com.syk25.finance.service.adapters.CardAdapter;
import com.syk25.finance.service.interfaces.PaymentInterface;
import com.syk25.finance.type.PayMethod;
import com.syk25.finance.type.PaymentResult;
import com.syk25.finance.type.Store;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PaymentInterfaceTest {
    PaymentInterface paymentInterface;
    // 카드 결제 확인
    @Test
    public void pay_byCard_success() {
        // given
        paymentInterface = new CardAdapter();
        PayMethod payMethod = PayMethod.CARD;
        Store store = Store.GS25;
        Integer amount = 99;
        // when
        PaymentRequest paymentRequest = new PaymentRequest(payMethod,store,amount);
        PaymentResult paymentResult = paymentInterface.payment(paymentRequest.getAmount());
        // then
        assertEquals(paymentResult, PaymentResult.SUCCEEDED);
    }
}