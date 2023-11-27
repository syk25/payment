package com.syk25.finance.dto;

import com.syk25.finance.type.Authorization;

public class CancelPaymentResponse {
    Authorization authorization;
    Integer respondedCancelledAmount;

    public CancelPaymentResponse(Authorization authorization, Integer respondedCancelledAmount) {
        this.authorization = authorization;
        this.respondedCancelledAmount = respondedCancelledAmount;
    }

    public Authorization getAuthorization() {
        return authorization;
    }

    public void setAuthorization(Authorization authorization) {
        this.authorization = authorization;
    }

    public Integer getRespondedCancelledAmount() {
        return respondedCancelledAmount;
    }

    public void setRespondedCancelledAmount(Integer respondedCancelledAmount) {
        this.respondedCancelledAmount = respondedCancelledAmount;
    }

    @Override
    public String toString() {
        return "CancelPaymentResponse{" +
                "authorization=" + authorization +
                ", respondedCancelledAmount=" + respondedCancelledAmount +
                '}';
    }
}
