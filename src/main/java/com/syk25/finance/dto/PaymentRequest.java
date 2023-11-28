package com.syk25.finance.dto;

import com.syk25.finance.type.PayMethod;
import com.syk25.finance.type.Store;

public class PaymentRequest {
    PayMethod payMethod;
    Store store;
    Integer requestedAmount;

    public PaymentRequest(PayMethod payMethod, Store store, Integer requestedAmount) {
        this.payMethod = payMethod;
        this.store = store;
        this.requestedAmount = requestedAmount;
    }

    public PayMethod getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(PayMethod payMethod) {
        this.payMethod = payMethod;
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
