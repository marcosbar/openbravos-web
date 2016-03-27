package commons;

import com.mgb.persistence.model.CashModel;
import com.mgb.persistence.model.PaymentData;
import com.mgb.view.model.CurrentCash;
import org.joda.time.DateTime;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by mgb on 26/03/2016.
 */
public class CashTestHelper {

    public static String CASH_ID = UUID.randomUUID().toString();
    public static DateTime START_DATE = DateTime.now().minusDays(1);
    public static DateTime END_DATE = DateTime.now();
    public static BigDecimal TOTAL_AMOUNT = new BigDecimal(10);
    public static int NUMBER_OF_SALES = 10;
    public static String TYPE_CARD = "card";

    public static CashModel getCashModel(){
        CashModel cashModel = new CashModel();
        cashModel.setId(CASH_ID);
        cashModel.setStart(START_DATE);
        cashModel.setEnd(END_DATE);
        List<PaymentData> paymentData = new ArrayList<>();
        paymentData.add(new PaymentData(TYPE_CARD, TOTAL_AMOUNT, NUMBER_OF_SALES));
        cashModel.setPaymentDetails(paymentData);
        return cashModel;
    }

    public static CurrentCash getCurrentCash(){
        return new CurrentCash(TOTAL_AMOUNT,START_DATE,NUMBER_OF_SALES);
    }

}
