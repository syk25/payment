package com.syk25.finance.service.discount_policy;

import com.syk25.finance.dto.PaymentRequest;
import com.syk25.finance.service.interfaces.DiscountInterface;
import org.springframework.stereotype.Component;

@Component
public class DiscountByPayMethod implements DiscountInterface {
    @Override
    public Integer getDiscountAmount(PaymentRequest paymentRequest) {
        switch (paymentRequest.getPayMethod()) {
            case CARD -> {
                return paymentRequest.getAmount();
            }
            case CASH -> {
                return paymentRequest.getAmount() * 6 / 10;
            }
        }
        return paymentRequest.getAmount();
    }
}
