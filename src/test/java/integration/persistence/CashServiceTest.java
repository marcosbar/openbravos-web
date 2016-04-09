package integration.persistence;

import com.mgb.domain.service.CashService;
import com.mgb.persistence.model.CashModel;
import com.mgb.persistence.model.PaymentDataModel;
import commons.DatabaseTest;
import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.Arrays;

import static junit.framework.Assert.assertEquals;

/**
 * Created by mgb on 26/03/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = {"classpath:model-config-test.xml"})
public class CashServiceTest extends DatabaseTest {

    @Autowired
    private CashService cashService;

    @Test
    public void getCurrentCash(){
        //GIVEN
        CashModel expected = new CashModel();
        expected.setId("248191f5-938b-4109-8b19-ab6008dd5d79");
        expected.setStart(new DateTime(1377552779000L));
        expected.setPaymentDetails(Arrays.asList(
                new PaymentDataModel("cash", new BigDecimal("192.39999999999998"), 21),
                new PaymentDataModel("magcard", new BigDecimal("70"),2))
        );

        //WHEN
        CashModel cashModel = cashService.getCurrentCash();

        //THEN
        assertEquals(cashModel.getId(), expected.getId());
        assertEquals(cashModel.getEnd(), expected.getEnd());
        assertEquals(cashModel.getStart(), expected.getStart());
        assertEquals(expected.getPaymentDetails(),cashModel.getPaymentDetails());
    }
}
