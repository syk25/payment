package com.syk25.finance.service.interfaces;

import com.syk25.finance.type.CancelledPaymentResult;
import com.syk25.finance.type.PaymentResult;

public interface PaymentInterface {
    PaymentResult payment(Integer amount);
    CancelledPaymentResult cancelPayment(Integer cancelledAmount);
}
