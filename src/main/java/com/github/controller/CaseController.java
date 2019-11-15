package com.github.controller;

import com.github.model.Case;
import com.github.service.CaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CaseController {
    private CaseService caseService;

    @Autowired(required = true)
    @Qualifier(value = "caseService")
    public void setCaseService(CaseService caseService) {
        this.caseService = caseService;
    }

    @RequestMapping(value = "/medCase/add", method = RequestMethod.POST)
    public String addMedCase(@ModelAttribute("medCase") Case medCase){
        caseService.handleCase(medCase);

        return "redirect:/medCases";
    }

    @RequestMapping(value = "medCases", method = RequestMethod.GET)
    public String listCases(Model model){
        model.addAttribute("medCase", new Case());
        model.addAttribute("listCases", this.caseService.listCases());

        return "medCases";
    }

    @RequestMapping("/remove/{id}")
    public String removeMedCase(@PathVariable("id") int id){
        this.caseService.removeCase(id);

        return "redirect:/medCases";
    }

    @RequestMapping("/editCase/{id}")
    public String editMedCase(@PathVariable("id") int id, Model model){
        model.addAttribute("medCase", this.caseService.getCaseById(id));
        model.addAttribute("listCases", this.caseService.listCases());

        return "medCases";
    }

    @RequestMapping("/caseData/{id}")
    public String caseData(@PathVariable("id") int id, Model model){
        model.addAttribute("medCase", this.caseService.getCaseById(id));

        return "caseData";
    }

}
