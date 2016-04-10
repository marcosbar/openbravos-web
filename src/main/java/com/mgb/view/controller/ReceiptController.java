package com.mgb.view.controller;

import com.mgb.domain.facade.CashFacade;
import com.mgb.view.model.ReceiptData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by mgb on 21/03/2016.
 */
@Component
@RequestMapping(value = "/receipts")
public class ReceiptController {

    @Autowired
    private CashFacade cashFacade;

    @ModelAttribute
    public void setAccessOrigin(HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
    }

    @RequestMapping(value = "/current", method = RequestMethod.GET)
    @ResponseBody
    public List<ReceiptData> getCurrentReceipts(){
        return cashFacade.getCurrentReceipts();
    }


}
