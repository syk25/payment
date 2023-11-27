package com.syk25.finance.dto;

import com.syk25.finance.type.Store;

public class CancelPaymentRequest {
    Store store;
    Integer cancellingAmount;

    public CancelPaymentRequest(Store store, Integer cancellingAmount) {
        this.store = store;
        this.cancellingAmount = cancellingAmount;
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
}
