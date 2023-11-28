package com.syk25.finance.service.discount_policy;

import com.syk25.finance.dto.PaymentRequest;
import com.syk25.finance.service.interfaces.DiscountInterface;

public class DiscountByStore implements DiscountInterface {
    @Override
    public Integer getDiscountAmount(PaymentRequest paymentRequest) {
        switch (paymentRequest.getStore()) {
            case CU -> {
                return paymentRequest.getAmount() * 8 / 10;
            }
            case SEVEN_ELEVEN -> {
                return paymentRequest.getAmount() * 9 / 10;
            }
            case GS25 -> {
                return paymentRequest.getAmount();
            }
        }
        return paymentRequest.getAmount();
    }
}
