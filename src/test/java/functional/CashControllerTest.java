package functional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = {
        "classpath:model-config-test.xml",
        "file:src/main/webapp/WEB-INF/dispatcher-servlet.xml" })
@WebAppConfiguration
public class CashControllerTest {

    @Autowired
    WebApplicationContext wac;

    @Autowired
    ApplicationContext appContext;

    MockMvc mockMvc = null;

    @Before
    public void before() {
        mockMvc = webAppContextSetup(wac).build();
    }

    @Test
    public void addTodoWhenTitleAndDescriptionAreTooLong() throws Exception {

        mockMvc.perform(get("/cash/current")
                .contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(content().string("{\"cash\":192.40,\"created\":\"26/08/2013 22:32:59\",\"numberOfSales\":21}"));
    }
}