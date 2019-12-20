package com.github.controller;

import com.github.model.CaseEntity;
import com.github.model.PatientEntity;
import com.github.service.CasePagingService;
import com.github.service.CaseService;
import com.github.util.ResultOfPagingCalculations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class CaseController {
    private final CaseService caseService;
    private CasePagingService casePagingService;

    @Autowired
    public CaseController(CaseService caseService, CasePagingService casePagingService) {
        this.caseService = caseService;
        this.casePagingService = casePagingService;
    }

    @PostMapping(value = "/patientData")
    public String addMedCase(@ModelAttribute("medCase") CaseEntity medCase, @ModelAttribute("patient") PatientEntity patient) {

        caseService.addCase(medCase, patient.getId());
        return "redirect:/patientData/${patient.id}";
    }

    @PostMapping(value = "/updateStatus/{caseId}")
    public String takeToWork(@PathVariable("caseId") String caseId, String targetStatus) {

        caseService.takeToWork(caseId, targetStatus);

        return "redirect:/caseData/${medCase.id}";
    }


    @GetMapping(value = "medCases")
    public ModelAndView listCases(@RequestParam(required = false) Integer page) {
        ModelAndView modelAndView = new ModelAndView("medCases");

        ResultOfPagingCalculations result = casePagingService.findPage(page);

        modelAndView.addObject("maxPages", result.getCountPage());
        modelAndView.addObject("page", page);
        modelAndView.addObject("listCases", result.getListCases());

        modelAndView.addObject("medCase", new CaseEntity());

        return modelAndView;
    }

    @GetMapping(value = "medCasesByPatient")
    public String listCasesByPatientId(Model model, PatientEntity patient) {
        model.addAttribute("medCase");
        model.addAttribute("listCasesByPatientId", this.caseService.listCasesByPatientId(patient));

        return "patientData";
    }

    @DeleteMapping("/remove/{id}")
    public String removeMedCase(@PathVariable("id") String id) {
        this.caseService.removeCase(id);

        return "redirect:/medCases";
    }

    @PostMapping("/editCase/{id}")
    public String editMedCase(@PathVariable("id") String id, Model model) {
        model.addAttribute("medCase", this.caseService.getCaseById(id));
        model.addAttribute("listCases", this.caseService.listCases());

        return "medCases";
    }

    @GetMapping("/caseData/{id}")
    public String caseData(@PathVariable("id") String id, Model model) {
        model.addAttribute("medCase", this.caseService.getCaseById(id));

        return "caseData";
    }

}
