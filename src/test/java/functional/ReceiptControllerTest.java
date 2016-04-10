package functional;

import commons.FunctionalTest;
import functional.model.ReceiptDetailsTest;
import org.junit.Test;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.web.servlet.ResultActions;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:data/before.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:data/cashData.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:data/after.sql")
})
public class ReceiptControllerTest extends FunctionalTest {

    @Test
    public void shouldReturnListReceipts() throws Exception{
        //WHEN
        ResultActions result = mockMvc.perform(get("/receipts/current")
                .contentType("application/json"));

        //THEN
        result.andExpect(status().isOk())
                .andExpect(header().string("Access-Control-Allow-Origin","*"));
    }

    @Test
    public void shouldReturnOkIfEmptyListOfReceipts(){

    }

    @Test
    public void shouldReturnDetailsForReceipt() throws Exception{
        List<ReceiptDetailsTest> receipts = Arrays.asList(
                new ReceiptDetailsTest("Product 1", "P1", 1, new BigDecimal(10), new BigDecimal(10)),
                new ReceiptDetailsTest("Product 2", "P2", 2, new BigDecimal(5), new BigDecimal(10))
        );

        //WHEN
        ResultActions result = mockMvc.perform(get("/receipts/id")
                .contentType("application/json"));

        //THEN
        result.andExpect(status().isOk())
                .andExpect(header().string("Access-Control-Allow-Origin","*"))
                .andExpect(content().string(getJson(receipts)));
    }

    @Test
    public void shouldReturn404WhenReceiptIdNotFound() throws Exception{

        //WHEN
        ResultActions result = mockMvc.perform(get("/receipt/not-found")
                .contentType("application/json"));

        //THEN
        result.andExpect(status().isNotFound())
                .andExpect(header().string("Access-Control-Allow-Origin","*"));
    }
}