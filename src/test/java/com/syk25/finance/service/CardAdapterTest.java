package com.syk25.finance.service;

import com.syk25.finance.service.adapters.CardAdapter;
import com.syk25.finance.type.CancelledCardPaymentResult;
import com.syk25.finance.type.CardPaymentResult;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CardAdapterTest {
    private CardAdapter cardAdapter = new CardAdapter();

    @Test
    public void card_payment_success() {
        // given
        Integer amount = 99;
        // when
        CardPaymentResult cardPaymentResult = cardAdapter.capture(amount);
        // then
        assertEquals(CardPaymentResult.SUCCEEDED, cardPaymentResult);
    }

    @Test
    public void card_payment_failed() {
        // given
        Integer amount = 101;
        // when
        CardPaymentResult cardPaymentResult = cardAdapter.capture(amount);
        // then
        assertEquals(CardPaymentResult.FAILED, cardPaymentResult);
    }

    @Test
    public void cancel_card_payment_success() {
        // given
        Integer cancelledAmount = 1000;
        // when
        CancelledCardPaymentResult cancelledCardPaymentResult = cardAdapter.cancelCapture(cancelledAmount);
        // then
        assertEquals(CancelledCardPaymentResult.SUCCEEDED, cancelledCardPaymentResult);
    }

    @Test
    public void cancel_card_payment_failed() {
        // given
        Integer cancelledAmount = 999;
        // when
        CancelledCardPaymentResult cancelledCardPaymentResult = cardAdapter.cancelCapture(cancelledAmount);
        // then
        assertEquals(CancelledCardPaymentResult.FAILED, cancelledCardPaymentResult);
    }

}