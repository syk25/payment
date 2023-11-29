package com.syk25.finance.service.discount_policy;

import com.syk25.finance.dto.PaymentRequest;
import com.syk25.finance.service.interfaces.DiscountInterface;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class DiscountByPayMethod implements DiscountInterface {
    @Override
    public Integer getDiscountAmount(PaymentRequest paymentRequest) {
        System.out.println("DiscountByPayMethod called.");
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
