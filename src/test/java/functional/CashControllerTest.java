package functional;

import commons.FunctionalTest;
import functional.model.CurrentCashTest;
import functional.model.PaymentDataTest;
import org.junit.Test;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.web.servlet.ResultActions;

import java.math.BigDecimal;
import java.util.Arrays;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:data/before.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:data/cashData.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:data/after.sql")
})
public class CashControllerTest extends FunctionalTest {

    @Test
    public void shouldGetCurrentCash() throws Exception {

        //GIVEN
        BigDecimal total = new BigDecimal("262.40");
        CurrentCashTest expected = new CurrentCashTest(total, dtf.parseDateTime("26/08/2013 22:32:59"),23);
        PaymentDataTest paymentDataTest = new PaymentDataTest("cash",new BigDecimal("192.40"));
        PaymentDataTest paymentDataTestCard = new PaymentDataTest("magcard", new BigDecimal("70"));
        expected.setPaymentTypes(Arrays.asList(paymentDataTest, paymentDataTestCard));

        //WHEN
        ResultActions result = mockMvc.perform(get("/cash/current")
                .contentType("application/json"));

        //THEN
        result.andExpect(status().isOk())
                .andExpect(header().string("Access-Control-Allow-Origin","*"))
                .andExpect(content().string(getJson(expected)));
    }

    @Test
    public void shouldGetCurrentCashForCashId() throws Exception{
        //GIVEN
        BigDecimal total = new BigDecimal("262.40");
        CurrentCashTest expected = new CurrentCashTest(total, dtf.parseDateTime("26/08/2013 22:32:59"),23);
        PaymentDataTest paymentDataTest = new PaymentDataTest("cash",new BigDecimal("192.40"));
        PaymentDataTest paymentDataTestCard = new PaymentDataTest("magcard", new BigDecimal("70"));
        expected.setPaymentTypes(Arrays.asList(paymentDataTest, paymentDataTestCard));

        //WHEN
        ResultActions result = mockMvc.perform(get("/cash/248191f5-938b-4109-8b19-ab6008dd5d79")
                .contentType("application/json"));

        //THEN
        result.andExpect(status().isOk())
                .andExpect(header().string("Access-Control-Allow-Origin","*"))
                .andExpect(content().string(getJson(expected)));
    }

    @Test
    public void shouldReturn404WhenCashIdNotFound() throws Exception{

        //WHEN
        ResultActions result = mockMvc.perform(get("/cash/not-found")
                .contentType("application/json"));

        //THEN
        result.andExpect(status().isNotFound())
                .andExpect(header().string("Access-Control-Allow-Origin","*"));
    }
}