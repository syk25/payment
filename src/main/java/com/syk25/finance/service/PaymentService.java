package com.syk25.finance.service;

import com.syk25.finance.dto.PaymentRequest;
import com.syk25.finance.dto.PaymentResponse;
import com.syk25.finance.type.Authorization;

public class PaymentService {
    public PaymentResponse pay(PaymentRequest paymentRequest){
        return new PaymentResponse(Authorization.AUTHORIZED, 100);
    }

    public void cancelPay(){

    }
}
