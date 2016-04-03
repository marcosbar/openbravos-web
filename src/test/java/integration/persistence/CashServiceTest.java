package integration.persistence;

import com.mgb.domain.service.CashService;
import com.mgb.persistence.model.CashModel;
import com.mgb.persistence.model.PaymentDataModel;
import junit.framework.Assert;
import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 * Created by mgb on 26/03/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = {"classpath:model-config-test.xml"})
public class CashServiceTest {

    //TODO: create test data
    @Autowired
    private CashService cashService;

    @Test
    public void getCurrentCash(){
        //GIVEN
        CashModel expected = new CashModel();
        expected.setId("248191f5-938b-4109-8b19-ab6008dd5d79");
        expected.setStart(new DateTime(1377552779000L));
        expected.setPaymentDetails(Arrays.asList(new PaymentDataModel("cash", new BigDecimal("192.40"), 21)));

        //WHEN
        CashModel cashModel = cashService.getCurrentCash();

        //THEN
        Assert.assertEquals(cashModel.getId(), expected.getId());
        Assert.assertEquals(cashModel.getEnd(), expected.getEnd());
        Assert.assertEquals(cashModel.getStart(), expected.getStart());
        //TODO: check how to verify both objects
        //Assert.assertEquals(cashModel.getPaymentDetails().get(0), expected.getPaymentDetails().get(0));
    }
}
