package com.github.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

public class CaseController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView allCases() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("cases");
        return modelAndView;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView editCase() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editCase");
        return modelAndView;
    }
}
