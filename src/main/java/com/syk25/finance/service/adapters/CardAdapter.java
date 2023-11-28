package com.syk25.finance.service.adapters;

import com.syk25.finance.service.interfaces.PaymentInterface;
import com.syk25.finance.type.*;

public class CardAdapter implements PaymentInterface {
    // 1. 인증
    public void authorization(){
        System.out.println("Authorization success.");
    }

    // 2. 승인
    public void approval(){
        System.out.println("Approval success");
    }

    // 3. 매입
    public CardPaymentResult capture(Integer payAmount){
        if(payAmount > 100){
            return CardPaymentResult.FAILED;
        }
        return CardPaymentResult.SUCCEEDED;
    }

    // 4. 매입 취소
    public CancelledCardPaymentResult cancelCapture(Integer cancelledAmount){
        if(cancelledAmount < 1000){
            return CancelledCardPaymentResult.FAILED;
        }
        return CancelledCardPaymentResult.SUCCEEDED;
    }

    @Override
    public PayMethod getPayMethod() {
        return PayMethod.CARD;
    }

    @Override
    public PaymentResult payment(Integer amount) {
        authorization();
        approval();
        CardPaymentResult cardPaymentResult = capture(amount);
        if(cardPaymentResult == CardPaymentResult.FAILED){
            return PaymentResult.FAILED;
        }
        return  PaymentResult.SUCCEEDED;
    }

    @Override
    public CancelledPaymentResult cancelPayment(Integer cancelledAmount) {
        CancelledCardPaymentResult cancelledCardPaymentResult = cancelCapture(cancelledAmount);
        if(cancelledCardPaymentResult == CancelledCardPaymentResult.FAILED){
            return CancelledPaymentResult.FAILED;
        }
        return CancelledPaymentResult.SUCCEEDED;
    }
}
