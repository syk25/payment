package com.syk25.finance.service;

import com.syk25.finance.dto.CancelPaymentRequest;
import com.syk25.finance.dto.CancelPaymentResponse;
import com.syk25.finance.dto.PaymentRequest;
import com.syk25.finance.dto.PaymentResponse;
import com.syk25.finance.service.adapters.CardAdapter;
import com.syk25.finance.service.adapters.CashAdapter;
import com.syk25.finance.service.discount_policy.DiscountByStore;
import com.syk25.finance.service.interfaces.DiscountInterface;
import com.syk25.finance.service.interfaces.PaymentInterface;
import com.syk25.finance.type.*;

public class PaymentService {
    CashAdapter cashAdapter = new CashAdapter();
    CardAdapter cardAdapter = new CardAdapter();
    PaymentInterface paymentInterface;
    private final DiscountInterface discountInterface = new DiscountByStore();


    public PaymentResponse pay(PaymentRequest paymentRequest){
        if(paymentRequest.getPayMethod() == PayMethod.CARD){
            paymentInterface = cardAdapter;
        } else {
            paymentInterface = cashAdapter;
        }

        Integer discountedAmount = discountInterface.getDiscountAmount(paymentRequest);
        PaymentResult paymentResult = paymentInterface.payment(discountedAmount);

        if(paymentResult == PaymentResult.SUCCEEDED){
            return new PaymentResponse(Authorization.AUTHORIZED, discountedAmount);
        } else {
            return new PaymentResponse(Authorization.DENIED, discountedAmount);
        }
    }

    public CancelPaymentResponse cancelPay(CancelPaymentRequest cancelPaymentRequest){
        if(cancelPaymentRequest.getPayMethod() == PayMethod.CARD){
            paymentInterface = cardAdapter;
        } else {
            paymentInterface = cashAdapter;
        }

        CancelledPaymentResult cancelledPaymentResult = paymentInterface.cancelPayment(cancelPaymentRequest.getCancellingAmount());

        if(cancelledPaymentResult == CancelledPaymentResult.FAILED){
            return new CancelPaymentResponse(Authorization.DENIED, cancelPaymentRequest.getCancellingAmount());
        } else {
            return new CancelPaymentResponse(Authorization.AUTHORIZED, cancelPaymentRequest.getCancellingAmount());
        }
    }
}
