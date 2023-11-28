package com.syk25.finance.service.interfaces;

import com.syk25.finance.type.CancelledPaymentResult;
import com.syk25.finance.type.PayMethod;
import com.syk25.finance.type.PaymentResult;

public interface PaymentInterface {
    PayMethod getPayMethod();
    PaymentResult payment(Integer amount);
    CancelledPaymentResult cancelPayment(Integer cancelledAmount);

}
