package com.mgb.persistence.dao.impl;

import com.mgb.persistence.dao.CashDAO;
import com.mgb.persistence.model.CashModel;
import com.mgb.persistence.model.PaymentData;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by mgb on 23/03/2016.
 */
@Service
public class CashJDBCTemplate extends JdbcDaoSupport implements CashDAO {

    @Autowired
    private DataSource dataSource;

    private CashModelMapper cashModelMapper = new CashModelMapper();
    private PaymentDataMapper paymentMapper = new PaymentDataMapper();

    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
    }

    public CashModel getCurrentCash() {
        String sql = "SELECT MONEY as ID, DATESTART as START, DATEEND as END FROM CLOSEDCASH WHERE DATEEND IS NULL";

        CashModel cashModel = getJdbcTemplate().queryForObject(
                sql, new Object[0], cashModelMapper);

        cashModel.setPaymentDetails(getPayments(cashModel.getId()));

        return cashModel;
    }

    private List<PaymentData> getPayments(String id){
        String sql = "SELECT PAYMENTS.PAYMENT as TYPE, SUM(PAYMENTS.TOTAL) as TOTAL, COUNT(PAYMENTS.ID) as COUNT FROM PAYMENTS JOIN RECEIPTS ON PAYMENTS.RECEIPT = RECEIPTS.ID WHERE RECEIPTS.MONEY = ? GROUP BY PAYMENTS.PAYMENT";

        List<PaymentData> paymentDatas = getJdbcTemplate().query(sql,new Object[]{id},paymentMapper);

        return paymentDatas;
    }

    public CashModel getCurrentCashById(String id) {
        return null;
    }

    private class CashModelMapper implements RowMapper<CashModel> {
        public CashModel mapRow(ResultSet rs, int rowNum) throws SQLException {
            CashModel cash = new CashModel();
            cash.setId(rs.getString("id"));
            cash.setStart(new DateTime(rs.getTimestamp("start")));
            cash.setStart(new DateTime(rs.getTimestamp("end")));
            return cash;
        }
    }

    private class PaymentDataMapper implements RowMapper<PaymentData> {
        public PaymentData mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new PaymentData(rs.getString("TYPE"),
                    rs.getBigDecimal("TOTAL"),
                    rs.getInt("COUNT"));
        }
    }

}
