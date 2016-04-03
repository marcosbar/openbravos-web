package functional;

import com.fasterxml.jackson.core.JsonProcessingException;
import functional.model.CurrentCashTest;
import functional.model.PaymentDataTest;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.Jackson2ObjectMapperFactoryBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.web.context.WebApplicationContext;

import java.math.BigDecimal;
import java.util.Arrays;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = {
        "classpath:model-config-test.xml",
        "file:src/main/webapp/WEB-INF/dispatcher-servlet.xml" })
@WebAppConfiguration
public class CashControllerTest {

    @Autowired
    WebApplicationContext wac;

    MockMvc mockMvc = null;

    DateTimeFormatter dtf = DateTimeFormat.forPattern("dd/MM/YYYY HH:mm:ss");

    @Before
    public void before() {
        mockMvc = webAppContextSetup(wac).build();
    }

    //TODO: use test data from integration
    @Test
    public void shouldGetCurrentCash() throws Exception {

        //GIVEN
        BigDecimal total = new BigDecimal("192.40");
        CurrentCashTest expected = new CurrentCashTest(total, dtf.parseDateTime("26/08/2013 22:32:59"),21);
        PaymentDataTest paymentDataTest = new PaymentDataTest("cash",total);
        expected.setPaymentTypes(Arrays.asList(paymentDataTest));

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
        BigDecimal total = new BigDecimal("192.40");
        CurrentCashTest expected = new CurrentCashTest(total, dtf.parseDateTime("26/08/2013 22:32:59"),21);
        PaymentDataTest paymentDataTest = new PaymentDataTest("cash",total);
        expected.setPaymentTypes(Arrays.asList(paymentDataTest));

        //WHEN
        ResultActions result = mockMvc.perform(get("/cash/current/248191f5-938b-4109-8b19-ab6008dd5d79")
                .contentType("application/json"));

        //THEN
        result.andExpect(status().isOk())
                .andExpect(header().string("Access-Control-Allow-Origin","*"))
                .andExpect(content().string(getJson(expected)));
    }

    @Test
    public void shouldReturn404WhenCashIdNotFound() throws Exception{

        //WHEN
        ResultActions result = mockMvc.perform(get("/cash/current/not-found")
                .contentType("application/json"));

        //THEN
        result.andExpect(status().isNotFound())
                .andExpect(header().string("Access-Control-Allow-Origin","*"));
    }

    public String getJson(Object model) throws JsonProcessingException {
        Jackson2ObjectMapperFactoryBean objectMapper = wac.getBean(Jackson2ObjectMapperFactoryBean.class);
        return objectMapper.getObject().writeValueAsString(model);
    }
}