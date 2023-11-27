package com.syk25.finance.service;

import com.syk25.finance.type.CancelledPaidByCashResult;
import com.syk25.finance.type.PaidByCashResult;

public class CashAdapter {
    public PaidByCashResult payByCash(Integer amount){
        System.out.println("Paid by cash : " + amount);
        if(amount > 1000_000){
            return PaidByCashResult.FAILED;
        }
        return PaidByCashResult.AUTHORIZED;
    }

    public CancelledPaidByCashResult cancelPayByCash(Integer cancellingAmount){
        System.out.println("Cancelling Cash amount : " + cancellingAmount);

        if(cancellingAmount < 100){
            return CancelledPaidByCashResult.DENIED;
        }
        return CancelledPaidByCashResult.AUTHORIZED;
    }

}
