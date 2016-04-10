package com.mgb.domain.service;

import com.mgb.persistence.dao.CashDAO;
import com.mgb.persistence.dao.ReceiptDAO;
import com.mgb.persistence.model.CashModel;
import com.mgb.persistence.model.ReceiptModel;
import com.mgb.persistence.model.TicketLineModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by mgb on 23/03/2016.
 */
@Service
public class CashService {

    @Autowired
    private CashDAO cashDAO;

    @Autowired
    private ReceiptDAO receiptDAO;

    public CashModel getCurrentCash(){
        return cashDAO.getCurrentCash();
    }
    public CashModel getCashById(String id){
        return cashDAO.getCurrentCashById(id);
    }
    public List<ReceiptModel> getCurrentReceipts() {
        CashModel cashModel = cashDAO.getCurrentCash();
        return receiptDAO.getReceiptsByCashId(cashModel.getId());
    }

    public List<TicketLineModel> getTicketLinesByTicketId(String ticketId){
        return receiptDAO.getTicketLinesByTicketId(ticketId);
    }
}
