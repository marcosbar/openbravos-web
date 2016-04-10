package com.mgb.persistence.dao;

import com.mgb.persistence.model.ReceiptModel;
import com.mgb.persistence.model.TicketLineModel;

import java.util.List;

/**
 * Created by mgb on 10/04/2016.
 */
public interface ReceiptDAO {


    List<ReceiptModel> getReceiptsByCashId(String cashId);
    List<TicketLineModel> getTicketLinesByTicketId(String ticketId);
}
