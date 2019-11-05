package com.github.controller;

import com.github.model.MedCase;
import com.github.service.MedCaseService;
import com.github.service.MedCaseServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

public class MedCaseController {

    private MedCaseService medCaseService = new MedCaseServiceImpl();

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView back() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping(value = "/medCases", method = RequestMethod.GET)
    public ModelAndView allMedCases() {
        List<MedCase> medCases = medCaseService.allMedCases();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("medCases");
        modelAndView.addObject("medCasesList", medCases);
        return modelAndView;
    }

    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public ModelAndView allCases() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("dashboard");
        return modelAndView;
    }
}
