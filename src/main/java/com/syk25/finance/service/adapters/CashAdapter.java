package com.syk25.finance.service.adapters;

import com.syk25.finance.service.interfaces.PaymentInterface;
import com.syk25.finance.type.*;
import org.springframework.stereotype.Component;

@Component
public class CashAdapter implements PaymentInterface {
    public CashPaymentResult payByCash(Integer amount) {
        System.out.println("Paid by cash : " + amount);
        if (amount > 1000_000) {
            return CashPaymentResult.FAILED;
        }
        return CashPaymentResult.SUCCEEDED;
    }

    public CancelledCashPaymentResult cancelPayByCash(Integer cancellingAmount) {
        System.out.println("Cancelling Cash amount : " + cancellingAmount);

        if (cancellingAmount < 100) {
            return CancelledCashPaymentResult.FAILED;
        }
        return CancelledCashPaymentResult.SUCCEEDED;
    }


    @Override
    public PayMethod getPayMethod() {
        return PayMethod.CASH;
    }

    @Override
    public PaymentResult payment(Integer amount) {
        CashPaymentResult cashPaymentResult = payByCash(amount);
        if (cashPaymentResult == CashPaymentResult.FAILED) {
            return PaymentResult.FAILED;
        }
        return PaymentResult.SUCCEEDED;
    }

    @Override
    public CancelledPaymentResult cancelPayment(Integer cancelledAmount) {
        CancelledCashPaymentResult cancelledCashPaymentResult = cancelPayByCash(cancelledAmount);
        if (cancelledCashPaymentResult == CancelledCashPaymentResult.FAILED) {
            return CancelledPaymentResult.FAILED;
        }
        return CancelledPaymentResult.SUCCEEDED;
    }
}
