package com.mgb.view.controller;

import com.mgb.domain.facade.CashFacade;
import com.mgb.view.model.CurrentCash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by mgb on 21/03/2016.
 */
@Component
@RequestMapping(value = "/cash")
public class CashController {

    @Autowired
    private CashFacade cashFacade;

    @ModelAttribute
    public void setAccessOrigin(HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
    }

    @CrossOrigin//TODO make this tag work, use org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping
    @RequestMapping(value = "/current", method = RequestMethod.GET)
    @ResponseBody
    public CurrentCash getCurrent(){
        return cashFacade.getCurrentCash();
    }
}
