package com.mgb.view.controller;

import com.mgb.domain.facade.CashFacade;
import com.mgb.view.model.CurrentCash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by mgb on 21/03/2016.
 */
@Component
@RequestMapping(value = "/cash")
public class CashController {

    @Autowired
    private CashFacade cashFacade;

    @RequestMapping(value = "/current", method = RequestMethod.GET)
    @ResponseBody
    public CurrentCash getCurrent(){
        return cashFacade.getCurrentCash();
    }
}
