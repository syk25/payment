package com.syk25.finance.service;

import com.syk25.finance.type.CancelledCashPaymentResult;
import com.syk25.finance.type.CancelledPaymentResult;
import com.syk25.finance.type.CashPaymentResult;
import com.syk25.finance.type.PaymentResult;

public class CashAdapter implements PaymentInterface {
    public CashPaymentResult payByCash(Integer amount){
        System.out.println("Paid by cash : " + amount);
        if(amount > 1000_000){
            return CashPaymentResult.FAILED;
        }
        return CashPaymentResult.SUCCEEDED;
    }

    public CancelledCashPaymentResult cancelPayByCash(Integer cancellingAmount){
        System.out.println("Cancelling Cash amount : " + cancellingAmount);

        if(cancellingAmount < 100){
            return CancelledCashPaymentResult.FAILED;
        }
        return CancelledCashPaymentResult.SUCCEEDED;
    }


    @Override
    public PaymentResult payment(Integer amount) {
        CashPaymentResult cashPaymentResult = payByCash(amount);
        if(cashPaymentResult == CashPaymentResult.FAILED){
            return PaymentResult.FAILED;
        }
        return PaymentResult.SUCCEEDED;
    }

    @Override
    public CancelledPaymentResult cancelPayment(Integer cancelledAmount) {
        CancelledCashPaymentResult cancelledCashPaymentResult = cancelPayByCash(cancelledAmount);
        if(cancelledCashPaymentResult == CancelledCashPaymentResult.FAILED){
            return CancelledPaymentResult.FAILED;
        }
        return CancelledPaymentResult.SUCCEEDED;
    }
}
