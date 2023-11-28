package com.syk25.finance.service.discount_policy;

import com.syk25.finance.dto.PaymentRequest;
import com.syk25.finance.service.interfaces.DiscountInterface;
import com.syk25.finance.type.PayMethod;
import com.syk25.finance.type.Store;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiscountByStoreTest {
    DiscountByStore discountByStore = new DiscountByStore();
    @Test
    public void discount_test() {
        // given
        PaymentRequest paymentRequest_GS25 = new PaymentRequest(PayMethod.CARD, Store.GS25, 1000);
        PaymentRequest paymentRequest_CU = new PaymentRequest(PayMethod.CARD, Store.CU, 1000);
        PaymentRequest paymentRequest_SEVEN_ELEVEN = new PaymentRequest(PayMethod.CARD, Store.SEVEN_ELEVEN, 1000);
        // when
        Integer discountedAmount_GS25 = discountByStore.getDiscountAmount(paymentRequest_GS25);
        Integer discountedAmount_CU = discountByStore.getDiscountAmount(paymentRequest_CU);
        Integer discountedAmount_SEVEN_ELEVEN = discountByStore.getDiscountAmount(paymentRequest_SEVEN_ELEVEN);
        // then

        assertEquals(800, discountedAmount_CU);
        assertEquals(900, discountedAmount_SEVEN_ELEVEN);
        assertEquals(1000, discountedAmount_GS25);
    }

}