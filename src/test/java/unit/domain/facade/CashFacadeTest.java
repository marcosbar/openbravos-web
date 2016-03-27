package unit.domain.facade;

import com.mgb.domain.facade.CashFacade;
import com.mgb.domain.service.CashService;
import com.mgb.persistence.model.CashModel;
import com.mgb.persistence.model.PaymentData;
import com.mgb.view.model.CurrentCash;
import junit.framework.Assert;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static commons.CashTestHelper.*;
/**
 * Created by mgb on 26/03/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = {"classpath:model-config-test.xml"})
public class CashFacadeTest {

    private CashFacade cashFacade = new CashFacade();

    private CashService cashService = Mockito.mock(CashService.class);


    @Before
    public void setUp(){
        cashFacade.setCashService(cashService);
    }

    @Test
    public void shouldReturnCashModel(){
        //GIVEN
        Mockito.when(cashService.getCurrentCash()).thenReturn(getCashModel());

        //WHEN
        CurrentCash currentCash = cashFacade.getCurrentCash();

        //THEN
        Assert.assertEquals(currentCash,getCurrentCash());
    }

    @Test
    public void shouldReturnCashModelWhenNoPaymentData(){

        //GIVEN
        CashModel cashModel = new CashModel();
        cashModel.setStart(START_DATE);
        Mockito.when(cashService.getCurrentCash()).thenReturn(cashModel);

        //WHEN
        CurrentCash currentCash = cashFacade.getCurrentCash();

        //THEN
        //Assert.assertTrue(currentCash.equals(new CurrentCash(BigDecimal.ZERO,START_DATE,0)));
        Assert.assertEquals(currentCash, new CurrentCash(BigDecimal.ZERO,START_DATE,0));
    }

    @Test
    public void shouldReturnCashModelWhenNotUsedFieldsNull(){

        //GIVEN
        CashModel cashModel = new CashModel();
        cashModel.setStart(START_DATE);
        cashModel.setPaymentDetails(Stream.of(new PaymentData(TYPE_CARD,TOTAL_AMOUNT,NUMBER_OF_SALES)).collect(Collectors.toList()));
        Mockito.when(cashService.getCurrentCash()).thenReturn(cashModel);

        //WHEN
        CurrentCash currentCash = cashFacade.getCurrentCash();

        //THEN
        Assert.assertEquals(currentCash, getCurrentCash());
    }
}
