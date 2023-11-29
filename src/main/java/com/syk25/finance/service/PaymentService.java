package com.syk25.finance.service;

import com.syk25.finance.dto.CancelPaymentRequest;
import com.syk25.finance.dto.CancelPaymentResponse;
import com.syk25.finance.dto.PaymentRequest;
import com.syk25.finance.dto.PaymentResponse;
import com.syk25.finance.service.interfaces.DiscountInterface;
import com.syk25.finance.service.interfaces.PaymentInterface;
import com.syk25.finance.type.Authorization;
import com.syk25.finance.type.CancelledPaymentResult;
import com.syk25.finance.type.PayMethod;
import com.syk25.finance.type.PaymentResult;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Component
public class PaymentService {

    private final Map<PayMethod, PaymentInterface> paymentInterfaceMap = new HashMap<>();
    private final DiscountInterface discountInterface;

    public PaymentService(Set<PaymentInterface> paymentInterfaceSet, @Qualifier("discountByStore") DiscountInterface discountInterface) {
        paymentInterfaceSet.forEach(
                paymentInterface -> paymentInterfaceMap.put(
                        paymentInterface.getPayMethod(),
                        paymentInterface
                )
        );
        this.discountInterface = discountInterface;
    }

    public PaymentResponse pay(PaymentRequest paymentRequest) {
        PaymentInterface paymentInterface = paymentInterfaceMap.get(paymentRequest.getPayMethod());

        Integer discountedAmount = discountInterface.getDiscountAmount(paymentRequest);
        PaymentResult paymentResult = paymentInterface.payment(discountedAmount);

        if (paymentResult == PaymentResult.FAILED) {
            return new PaymentResponse(Authorization.DENIED, discountedAmount);
        }
        return new PaymentResponse(Authorization.AUTHORIZED, discountedAmount);
    }

    public CancelPaymentResponse cancelPay(CancelPaymentRequest cancelPaymentRequest) {
        PaymentInterface paymentInterface = paymentInterfaceMap.get(cancelPaymentRequest.getPayMethod());
        CancelledPaymentResult cancelledPaymentResult = paymentInterface.cancelPayment(cancelPaymentRequest.getCancellingAmount());

        if (cancelledPaymentResult == CancelledPaymentResult.FAILED) {
            return new CancelPaymentResponse(Authorization.DENIED, cancelPaymentRequest.getCancellingAmount());
        }
        return new CancelPaymentResponse(Authorization.AUTHORIZED, cancelPaymentRequest.getCancellingAmount());
    }
}
