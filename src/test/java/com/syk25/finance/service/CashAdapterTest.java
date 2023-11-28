package com.syk25.finance.service;

import com.syk25.finance.type.CancelledCashPaymentResult;
import com.syk25.finance.type.CashPaymentResult;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CashAdapterTest {
    CashAdapter cashAdapter = new CashAdapter();

    @Test
    public void payByCash_authorized_test() {
        // given
        Integer amount = 1000_000;
        // when
        CashPaymentResult cashPaymentResult = cashAdapter.payByCash(amount);
        // then
        assertEquals(CashPaymentResult.SUCCEEDED, cashPaymentResult);
    }

    @Test
    public void payByCash_failed_test() {
        // given
        Integer amount = 1000_001;
        // when
        CashPaymentResult cashPaymentResult = cashAdapter.payByCash(amount);
        // then
        assertEquals(CashPaymentResult.FAILED, cashPaymentResult);
    }

    @Test
    public void cancel_cash_pay_authorized() {
        // given
        Integer cancellingAmount = 101;
        // when
        CancelledCashPaymentResult cancelledCashPaymentResult = cashAdapter.cancelPayByCash(cancellingAmount);
        // then
        assertEquals(CancelledCashPaymentResult.SUCCEEDED, cancelledCashPaymentResult);
    }

    @Test
    public void cancel_cash_pay_denied() {
        // given
        Integer cancellingAmount = 99;
        // when
        CancelledCashPaymentResult cancelledCashPaymentResult = cashAdapter.cancelPayByCash(cancellingAmount);
        // then
        assertEquals(CancelledCashPaymentResult.FAILED, cancelledCashPaymentResult);
    }

}