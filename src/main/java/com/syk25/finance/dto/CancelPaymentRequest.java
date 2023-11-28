package com.syk25.finance.dto;

import com.syk25.finance.type.PayMethod;
import com.syk25.finance.type.Store;

public class CancelPaymentRequest {
    Store store;
    Integer cancellingAmount;
    PayMethod payMethod;

    public CancelPaymentRequest(PayMethod payMethod, Store store, Integer cancellingAmount) {
        this.store = store;
        this.cancellingAmount = cancellingAmount;
        this.payMethod = payMethod;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Integer getCancellingAmount() {
        return cancellingAmount;
    }

    public void setCancellingAmount(Integer cancellingAmount) {
        this.cancellingAmount = cancellingAmount;
    }

    public PayMethod getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(PayMethod payMethod) {
        this.payMethod = payMethod;
    }
}
