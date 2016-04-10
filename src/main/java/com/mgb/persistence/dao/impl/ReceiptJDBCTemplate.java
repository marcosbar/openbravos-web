package com.mgb.persistence.dao.impl;

import com.mgb.persistence.common.JdbcTemplateDAO;
import com.mgb.persistence.dao.ReceiptDAO;
import com.mgb.persistence.model.ReceiptModel;
import com.mgb.persistence.model.TicketLineModel;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by mgb on 23/03/2016.
 */
@Service
public class ReceiptJDBCTemplate extends JdbcTemplateDAO implements ReceiptDAO {

    private RowMapper<ReceiptModel> receiptMapper = new ReceiptModelMapper();
    private RowMapper<TicketLineModel> ticketLineModelRowMapper = new TicketLineModelMapper();


    public List<ReceiptModel> getReceiptsByCashId(String cashId){
        String sql = "SELECT RECEIPTS.ID as ID, RECEIPTS.DATENEW as DATE, PAYMENTS.PAYMENT as TYPE, PAYMENTS.TOTAL as TOTAL FROM PAYMENTS JOIN RECEIPTS ON PAYMENTS.RECEIPT = RECEIPTS.ID WHERE RECEIPTS.MONEY = ? ORDER BY RECEIPTS.DATENEW";

        return getJdbcTemplate().query(sql,new Object[]{cashId},receiptMapper);

    }

    public List<TicketLineModel> getTicketLinesByTicketId(String ticketId){
        String sql = "SELECT PRODUCTS.NAME AS NAME, PRODUCTS.CODE AS CODE, TICKETLINES.LINE AS LINE, TICKETLINES.UNITS AS UNITS, TICKETLINES.PRICE AS PRICE FROM TICKETLINES JOIN PRODUCTS ON TICKETLINES.PRODUCT=PRODUCTS.ID WHERE TICKETLINES.TICKET = ? ORDER BY TICKETLINES.LINE";

        return getJdbcTemplate().query(sql,new Object[]{ticketId},ticketLineModelRowMapper);
    }

    private class ReceiptModelMapper implements RowMapper<ReceiptModel> {
        public ReceiptModel mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new ReceiptModel(rs.getString("ID"),
                    getDateTime(rs.getTimestamp("DATE")),
                    rs.getString("TYPE"),
                    rs.getBigDecimal("TOTAL"));
        }
    }

    private class TicketLineModelMapper implements RowMapper<TicketLineModel> {
        public TicketLineModel mapRow(ResultSet rs, int rowNum) throws SQLException{
            return new TicketLineModel(rs.getString("NAME"),
                    rs.getString("CODE"),
                    rs.getInt("LINE"),
                    rs.getInt("UNITS"),
                    rs.getBigDecimal("PRICE"));
        }
    }

}
