package com.syk25.finance.service.discount_policy;

import com.syk25.finance.dto.PaymentRequest;
import com.syk25.finance.type.PayMethod;
import com.syk25.finance.type.Store;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiscountByPayMethodTest {
    DiscountByPayMethod discountByPayMethod = new DiscountByPayMethod();

    @Test // exclude discount by store policy
    public void discount_byPayMethod_success() {
        // given
        PaymentRequest paymentRequest_CARD = new PaymentRequest(PayMethod.CARD, Store.GS25, 1000);
        PaymentRequest paymentRequest_CASH = new PaymentRequest(PayMethod.CASH, Store.GS25, 1000);
        // when
        Integer discountedAmount_CARD = discountByPayMethod.getDiscountAmount(paymentRequest_CARD);
        Integer discountedAmount_CASH = discountByPayMethod.getDiscountAmount(paymentRequest_CASH);
        // then
        assertEquals(600,discountedAmount_CASH);
        assertEquals(1000,discountedAmount_CARD);
    }

}