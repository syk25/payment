package com.syk25.finance.service;

import com.syk25.finance.type.CancelledPaidByCashResult;
import com.syk25.finance.type.PaidByCashResult;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CashAdapterTest {
    CashAdapter cashAdapter = new CashAdapter();

    @Test
    public void payByCash_authorized_test() {
        // given
        Integer amount = 1000_000;
        // when
        PaidByCashResult paidByCashResult = cashAdapter.payByCash(amount);
        // then
        assertEquals(PaidByCashResult.AUTHORIZED, paidByCashResult);
    }

    @Test
    public void payByCash_failed_test() {
        // given
        Integer amount = 1000_001;
        // when
        PaidByCashResult paidByCashResult = cashAdapter.payByCash(amount);
        // then
        assertEquals(PaidByCashResult.FAILED,paidByCashResult);
    }

    @Test
    public void cancel_cash_pay_authorized() {
        // given
        Integer cancellingAmount = 101;
        // when
        CancelledPaidByCashResult cancelledPaidByCashResult = cashAdapter.cancelPayByCash(cancellingAmount);
        // then
        assertEquals(CancelledPaidByCashResult.AUTHORIZED, cancelledPaidByCashResult);
    }

    @Test
    public void cancel_cash_pay_denied() {
        // given
        Integer cancellingAmount = 99;
        // when
        CancelledPaidByCashResult cancelledPaidByCashResult = cashAdapter.cancelPayByCash(cancellingAmount);
        // then
        assertEquals(CancelledPaidByCashResult.DENIED, cancelledPaidByCashResult);
    }

}