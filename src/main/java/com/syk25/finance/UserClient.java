package com.syk25.finance;

import com.syk25.finance.dto.CancelPaymentRequest;
import com.syk25.finance.dto.CancelPaymentResponse;
import com.syk25.finance.dto.PaymentRequest;
import com.syk25.finance.dto.PaymentResponse;
import com.syk25.finance.service.PaymentService;
import static com.syk25.finance.type.Store.GS25;

public class UserClient {
    public static void main(String[] args) {
        PaymentService paymentService = new PaymentService();

        // GS25, 1000원 결제
        PaymentResponse paymentResponse = paymentService.pay(new PaymentRequest(GS25, 1000));
        System.out.println(paymentResponse.toString());

        // GS25, 500원 취소 결제
        CancelPaymentResponse cancelPaymentResponse = paymentService.cancelPay(new CancelPaymentRequest(GS25, 500));
        System.out.println(cancelPaymentResponse.toString());

    }
}
