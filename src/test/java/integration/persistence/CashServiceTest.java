package integration.persistence;

import com.mgb.domain.service.CashService;
import com.mgb.persistence.model.CashModel;
import junit.framework.Assert;
import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
        expected.setStart(DateTime.parse("2016-03-27T12:29:41.319+01:00"));

        //WHEN
        CashModel cashModel = cashService.getCurrentCash();

        //THEN
        Assert.assertEquals(cashModel.getId(), expected.getId());
        Assert.assertEquals(cashModel.getEnd(), expected.getEnd());
        Assert.assertEquals(cashModel.getStart(), expected.getStart());
        Assert.assertEquals(cashModel.getPaymentDetails(), expected.getPaymentDetails());
    }
}
