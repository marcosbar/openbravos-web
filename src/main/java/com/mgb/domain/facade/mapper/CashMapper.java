package com.mgb.domain.facade.mapper;

import com.mgb.persistence.model.PaymentDataModel;
import com.mgb.persistence.model.ReceiptModel;
import com.mgb.view.model.PaymentData;
import com.mgb.view.model.ReceiptData;

/**
 * Created by mgb on 10/04/2016.
 */
public class CashMapper{
    public static PaymentData toPaymentData(PaymentDataModel model){
        return new PaymentData(model.getType(),model.getTotal());
    }

    public static ReceiptData toReceiptData(ReceiptModel model){
        return new ReceiptData(model.getId(),model.getDate(),model.getType(),model.getTotal());
    }
}
