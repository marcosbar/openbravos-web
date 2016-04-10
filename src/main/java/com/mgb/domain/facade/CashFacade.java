package com.mgb.domain.facade;

import com.mgb.domain.facade.mapper.CashMapper;
import com.mgb.domain.service.CashService;
import com.mgb.persistence.model.CashModel;
import com.mgb.view.model.Cash;
import com.mgb.view.model.PaymentData;
import com.mgb.view.model.ReceiptData;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by mgb on 23/03/2016.
 */
@Service
public class CashFacade {

    @Autowired
    private CashService cashService;

    public Cash getCurrentCash(){
        CashModel cashModel = cashService.getCurrentCash();
        return toCash(cashModel);
    }

    public Cash getCashById(String cashId){
        CashModel cashModel = cashService.getCashById(cashId);
        return toCash(cashModel);
    }

    public List<ReceiptData> getCurrentReceipts(){
        return cashService.getCurrentReceipts().stream().map(CashMapper::toReceiptData).collect(Collectors.toList());
    }

    public CashService getCashService() {
        return cashService;
    }

    public void setCashService(CashService cashService) {
        this.cashService = cashService;
    }

    private Cash toCash(CashModel cashModel){
        if(CollectionUtils.isEmpty(cashModel.getPaymentDetails())){
            return new Cash(BigDecimal.ZERO,cashModel.getStart(),0);
        }
        Stream<BigDecimal> total = cashModel.getPaymentDetails().stream().map(p -> p.getTotal());
        BigDecimal result = total.reduce((a,b) -> a.add(b)).get();
        Cash currentCash = new Cash(result,cashModel.getStart(),cashModel.getPaymentDetails().stream().mapToInt(p -> p.getCount()).sum());
        List<PaymentData> paymentDataList = cashModel.getPaymentDetails().stream().map(CashMapper::toPaymentData).collect(Collectors.toList());
        currentCash.setPaymentTypes(paymentDataList);
        return currentCash;
    }
}
