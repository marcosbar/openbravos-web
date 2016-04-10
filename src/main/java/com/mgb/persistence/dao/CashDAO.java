package com.mgb.persistence.dao;

import com.mgb.persistence.model.CashModel;

/**
 * Created by mgb on 23/03/2016.
 */
public interface CashDAO {
    CashModel getCurrentCash();
    CashModel getCurrentCashById(String id);
}
