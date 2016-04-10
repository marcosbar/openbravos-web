package com.mgb.view.controller;

import com.mgb.domain.facade.CashFacade;
import com.mgb.view.model.ReceiptData;
import com.mgb.view.model.TicketLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by mgb on 21/03/2016.
 */
@Component
@RequestMapping(value = "/receipt")
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

    @RequestMapping(value = "/{ticketId}", method = RequestMethod.GET)
    @ResponseBody
    public List<TicketLine> getCurrentReceipts(@PathVariable String ticketId){
        return cashFacade.getTicketLinesByTicketId(ticketId);
    }

}
