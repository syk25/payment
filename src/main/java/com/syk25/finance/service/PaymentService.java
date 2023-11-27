package com.syk25.finance.service;

import com.syk25.finance.dto.CancelPaymentRequest;
import com.syk25.finance.dto.CancelPaymentResponse;
import com.syk25.finance.dto.PaymentRequest;
import com.syk25.finance.dto.PaymentResponse;
import com.syk25.finance.type.Authorization;
import com.syk25.finance.type.CancelledPaidByCashResult;
import com.syk25.finance.type.PaidByCashResult;

public class PaymentService {
    CashAdapter cashAdapter = new CashAdapter();

    public PaymentResponse pay(PaymentRequest paymentRequest){
        PaidByCashResult paidByCashResult = cashAdapter.payByCash(paymentRequest.getAmount());


        if(paidByCashResult == PaidByCashResult.AUTHORIZED){
            return new PaymentResponse(Authorization.AUTHORIZED, paymentRequest.getAmount());
        } else {
            return new PaymentResponse(Authorization.DENIED, 100);
        }
    }

    public CancelPaymentResponse cancelPay(CancelPaymentRequest cancelPaymentRequest){
        CancelledPaidByCashResult cancelledPaidByCashResult = cashAdapter.cancelPayByCash(cancelPaymentRequest.getCancellingAmount());

        if(cancelledPaidByCashResult == CancelledPaidByCashResult.AUTHORIZED){
            return new CancelPaymentResponse(Authorization.AUTHORIZED, cancelPaymentRequest.getCancellingAmount());
        } else {
            return new CancelPaymentResponse(Authorization.DENIED, cancelPaymentRequest.getCancellingAmount());
        }
    }
}
