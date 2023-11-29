package com.syk25.finance;

import com.syk25.finance.config.ApplicationConfig;
import com.syk25.finance.dto.CancelPaymentRequest;
import com.syk25.finance.dto.CancelPaymentResponse;
import com.syk25.finance.dto.PaymentRequest;
import com.syk25.finance.dto.PaymentResponse;
import com.syk25.finance.service.PaymentService;
import com.syk25.finance.type.PayMethod;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static com.syk25.finance.type.Store.GS25;


public class UserClient {
    public static void main(String[] args) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        System.out.println("==============================");
        PaymentService paymentService = applicationContext.getBean("paymentService", PaymentService.class);
        PaymentService paymentService1 = applicationContext.getBean("paymentService", PaymentService.class);
        PaymentService paymentService2 = applicationContext.getBean("paymentService", PaymentService.class);
        PaymentService paymentService3 = applicationContext.getBean("paymentService", PaymentService.class);

        System.out.println(paymentService);
        System.out.println(paymentService1);
        System.out.println(paymentService2);
        System.out.println(paymentService3);

        System.out.println("===============================");

        // GS25, 1000원 카드결제
        PaymentResponse paymentResponse = paymentService.pay(new PaymentRequest(PayMethod.CARD, GS25, 1000));
        System.out.println(paymentResponse.toString());

        // GS25, 500원 카드 결제 취소
        CancelPaymentResponse cancelPaymentResponse = paymentService.cancelPay(new CancelPaymentRequest(PayMethod.CARD, GS25, 500));
        System.out.println(cancelPaymentResponse.toString());
    }
}
