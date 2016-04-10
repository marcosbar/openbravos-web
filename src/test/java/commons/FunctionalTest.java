package commons;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.Jackson2ObjectMapperFactoryBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

/**
 * Created by mgb on 10/04/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = {
        "classpath:model-config-test.xml",
        "file:src/main/webapp/WEB-INF/dispatcher-servlet.xml" })
@WebAppConfiguration
public abstract class FunctionalTest{

    @Autowired
    protected WebApplicationContext wac;

    protected MockMvc mockMvc = null;

    protected  DateTimeFormatter dtf = DateTimeFormat.forPattern("dd/MM/YYYY HH:mm:ss");

    @Before
    public void before() {
        mockMvc = webAppContextSetup(wac).build();
    }

    public String getJson(Object model) throws JsonProcessingException {
        Jackson2ObjectMapperFactoryBean objectMapper = wac.getBean(Jackson2ObjectMapperFactoryBean.class);
        return objectMapper.getObject().writeValueAsString(model);
    }
}
