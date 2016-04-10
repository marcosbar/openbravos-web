package functional;

import commons.FunctionalTest;
import functional.model.ReceiptDataTest;
import functional.model.ReceiptDetailsTest;
import org.junit.Test;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.web.servlet.ResultActions;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:data/before.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:data/receiptData.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:data/after.sql")
})
public class ReceiptControllerTest extends FunctionalTest {

    @Test
    public void shouldReturnListReceipts() throws Exception{
        //GIVEN
        List<ReceiptDataTest> receiptDataTests = Arrays.asList(
                new ReceiptDataTest("e25582ce-a233-4fa3-812b-92eae39bc848",dtf.parseDateTime("27/08/2013 11:45:01"),"cash",new BigDecimal("2.2")),
                new ReceiptDataTest("c4f06470-554e-4599-91d0-612e44c2e4bf",dtf.parseDateTime("27/08/2013 11:46:01"),"magcard",new BigDecimal("24")),
                new ReceiptDataTest("305d1d30-efa3-4c67-8197-5ffbf03da28a",dtf.parseDateTime("27/08/2013 11:47:01"),"magcard",new BigDecimal("46"))
        );

        //WHEN
        ResultActions result = mockMvc.perform(get("/receipt/current")
                .contentType("application/json"));

        //THEN
        result.andExpect(status().isOk())
                .andExpect(header().string("Access-Control-Allow-Origin","*"))
                .andExpect(content().string(getJson(receiptDataTests)));
    }

    @Test
    public void shouldReturnDetailsForReceipt() throws Exception{
        List<ReceiptDetailsTest> receipts = Arrays.asList(
                new ReceiptDetailsTest("P4", "CV012CO", 1, new BigDecimal(46), new BigDecimal(46))
        );

        //WHEN
        ResultActions result = mockMvc.perform(get("/receipt/305d1d30-efa3-4c67-8197-5ffbf03da28a")
                .contentType("application/json"));

        //THEN
        result.andExpect(status().isOk())
                .andExpect(header().string("Access-Control-Allow-Origin","*"))
                .andExpect(content().string(getJson(receipts)));
    }

    @Test
    public void shouldReturnEmptyWhenReceiptIdNotFound() throws Exception{
        //GIVEN
        List<ReceiptDetailsTest> receipts = new ArrayList<>();

        //WHEN
        ResultActions result = mockMvc.perform(get("/receipt/not-found")
                .contentType("application/json"));

        //THEN
        result.andExpect(status().isOk())
                .andExpect(header().string("Access-Control-Allow-Origin","*"))
                .andExpect(content().string(getJson(receipts)));
    }
}