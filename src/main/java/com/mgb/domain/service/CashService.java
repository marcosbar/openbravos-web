package com.mgb.domain.service;

import com.mgb.persistence.dao.CashDAO;
import com.mgb.persistence.model.CashModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by mgb on 23/03/2016.
 */
@Service
public class CashService {

    @Autowired
    private CashDAO cashDAO;

    public CashModel getCurrentCash(){
        return cashDAO.getCurrentCash();
    }
    public CashModel getCashById(String id){
        return cashDAO.getCurrentCashById(id);
    }
}
