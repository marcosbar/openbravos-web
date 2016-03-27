package com.mgb.domain.facade;

import com.mgb.domain.service.CashService;
import com.mgb.persistence.model.CashModel;
import com.mgb.view.model.CurrentCash;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.stream.Stream;

/**
 * Created by mgb on 23/03/2016.
 */
@Service
public class CashFacade {

    @Autowired
    private CashService cashService;

    public CurrentCash getCurrentCash(){
        CashModel cashModel = cashService.getCurrentCash();
        if(CollectionUtils.isEmpty(cashModel.getPaymentDetails())){
            return new CurrentCash(BigDecimal.ZERO,cashModel.getStart(),0);
        }
        Stream<BigDecimal> total = cashModel.getPaymentDetails().stream().map(payment -> payment.getTotal());
        BigDecimal result = total.reduce((a,b) -> a.add(b)).get();
        return new CurrentCash(result,cashModel.getStart(),cashModel.getPaymentDetails().stream().mapToInt(p -> p.getCount()).sum());
    }

    public CashService getCashService() {
        return cashService;
    }

    public void setCashService(CashService cashService) {
        this.cashService = cashService;
    }
}
