package com.syk25.finance.service;

import com.syk25.finance.dto.CancelPaymentRequest;
import com.syk25.finance.dto.CancelPaymentResponse;
import com.syk25.finance.dto.PaymentRequest;
import com.syk25.finance.dto.PaymentResponse;
import com.syk25.finance.type.*;

public class PaymentService {
    CashAdapter cashAdapter = new CashAdapter();
    CardAdapter cardAdapter = new CardAdapter();
    PaymentInterface paymentInterface;


    public PaymentResponse pay(PaymentRequest paymentRequest){
        if(paymentRequest.getPayMethod() == PayMethod.CARD){
            paymentInterface = cardAdapter;
        } else {
            paymentInterface = cashAdapter;
        }

        PaymentResult paymentResult = paymentInterface.payment(paymentRequest.getAmount());

        if(paymentResult == PaymentResult.SUCCEEDED){
            return new PaymentResponse(Authorization.AUTHORIZED, paymentRequest.getAmount());
        } else {
            return new PaymentResponse(Authorization.DENIED, paymentRequest.getAmount());
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
