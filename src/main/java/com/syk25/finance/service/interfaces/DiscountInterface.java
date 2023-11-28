package com.syk25.finance.service.interfaces;

import com.syk25.finance.dto.PaymentRequest;

public interface DiscountInterface {
    Integer getDiscountAmount(PaymentRequest paymentRequest);
}
