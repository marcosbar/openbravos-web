package com.mgb.persistence.dao.impl;

import com.mgb.persistence.common.JdbcTemplateDAO;
import com.mgb.persistence.dao.CashDAO;
import com.mgb.persistence.model.CashModel;
import com.mgb.persistence.model.PaymentDataModel;
import com.mgb.persistence.model.ReceiptModel;
import org.joda.time.DateTime;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by mgb on 23/03/2016.
 */
@Service
public class CashJDBCTemplate extends JdbcTemplateDAO implements CashDAO {

    private RowMapper<CashModel> cashModelMapper = new CashModelMapper();
    private RowMapper<PaymentDataModel> paymentMapper = new PaymentDataMapper();
    private RowMapper<ReceiptModel> receiptMapper = new ReceiptModelMapper();

    public CashModel getCurrentCash() {

        CashModel cashModel = getLastCash();

        cashModel.setPaymentDetails(getPayments(cashModel.getId()));

        return cashModel;
    }

    private CashModel getLastCash() {
        String sql = "SELECT MONEY as ID, DATESTART as START, DATEEND as END FROM CLOSEDCASH WHERE DATEEND IS NULL";

        return getOneResult(
                sql, new Object[0], cashModelMapper);
    }

    public List<ReceiptModel> getCurrentReceipts(){
        CashModel cashModel = getLastCash();
        return getReceipts(cashModel.getId());
    }

    private List<PaymentDataModel> getPayments(String id){
        String sql = "SELECT PAYMENTS.PAYMENT as TYPE, SUM(PAYMENTS.TOTAL) as TOTAL, COUNT(PAYMENTS.ID) as COUNT FROM PAYMENTS JOIN RECEIPTS ON PAYMENTS.RECEIPT = RECEIPTS.ID WHERE RECEIPTS.MONEY = ? GROUP BY PAYMENTS.PAYMENT";

        List<PaymentDataModel> paymentDataModels = getJdbcTemplate().query(sql,new Object[]{id},paymentMapper);

        return paymentDataModels;
    }

    private List<ReceiptModel> getReceipts(String id){
        String sql = "SELECT RECEIPTS.ID as ID, RECEIPTS.DATENEW as DATE, PAYMENTS.PAYMENT as TYPE, PAYMENTS.TOTAL as TOTAL FROM PAYMENTS JOIN RECEIPTS ON PAYMENTS.RECEIPT = RECEIPTS.ID WHERE RECEIPTS.MONEY = ? ORDER BY RECEIPTS.DATENEW";

        List<ReceiptModel> receiptModelList = getJdbcTemplate().query(sql,new Object[]{id},receiptMapper);

        return receiptModelList;
    }

    public CashModel getCurrentCashById(String cashId) {
        String sql = "SELECT MONEY as ID, DATESTART as START, DATEEND as END FROM CLOSEDCASH WHERE MONEY=?";

        CashModel cashModel = getOneResult(
                sql, new Object[]{cashId}, cashModelMapper);

        cashModel.setPaymentDetails(getPayments(cashModel.getId()));

        return cashModel;
    }

    private class CashModelMapper implements RowMapper<CashModel> {
        public CashModel mapRow(ResultSet rs, int rowNum) throws SQLException {
            CashModel cash = new CashModel();
            cash.setId(rs.getString("id"));
            cash.setStart(getDateTime(rs.getTimestamp("start")));
            cash.setEnd(getDateTime(rs.getTimestamp("end")));
            return cash;
        }
    }

    private DateTime getDateTime(Timestamp timestamp){
        if(timestamp!=null){
            return new DateTime(timestamp.getTime());
        }
        return null;
    }

    private class PaymentDataMapper implements RowMapper<PaymentDataModel> {
        public PaymentDataModel mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new PaymentDataModel(rs.getString("TYPE"),
                    rs.getBigDecimal("TOTAL"),
                    rs.getInt("COUNT"));
        }
    }

    private class ReceiptModelMapper implements RowMapper<ReceiptModel> {
        public ReceiptModel mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new ReceiptModel(rs.getString("ID"),
                    getDateTime(rs.getTimestamp("DATE")),
                    rs.getString("TYPE"),
                    rs.getBigDecimal("TOTAL"));
        }
    }

}
