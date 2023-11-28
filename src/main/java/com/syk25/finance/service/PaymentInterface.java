package com.syk25.finance.service;

import com.syk25.finance.type.CancelledPaymentResult;
import com.syk25.finance.type.PaymentResult;

public interface PaymentInterface {
    PaymentResult payment(Integer amount);
    CancelledPaymentResult cancelPayment(Integer cancelledAmount);
}
