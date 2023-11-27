package com.syk25.finance.dto;

import com.syk25.finance.type.Store;

public class PaymentRequest {

    Store store;
    Integer requestedAmount;

    public PaymentRequest(Store store, Integer requestedAmount) {
        this.store = store;
        this.requestedAmount = requestedAmount;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Integer getAmount() {
        return requestedAmount;
    }

    public void setAmount(Integer requestedAmount) {
        this.requestedAmount = requestedAmount;
    }
}
