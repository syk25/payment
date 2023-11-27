package com.syk25.finance.dto;

import com.syk25.finance.type.Authorization;

public class PaymentResponse {
    Authorization authorization;
    Integer respondedAmount;

    public PaymentResponse(Authorization authorization, Integer respondedAmount) {
        this.authorization = authorization;
        this.respondedAmount = respondedAmount;
    }

    public Authorization getAuthorization() {
        return authorization;
    }

    public void setAuthorization(Authorization authorization) {
        this.authorization = authorization;
    }

    public Integer getRespondedAmount() {
        return respondedAmount;
    }

    public void setRespondedAmount(Integer respondedAmount) {
        this.respondedAmount = respondedAmount;
    }
}
