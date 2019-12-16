package com.github.controller;

import com.github.bo.CaseBo;
import com.github.model.CaseEntity;
import com.github.model.PatientEntity;
import com.github.service.CaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CaseController {
    private final CaseService caseService;

    @Autowired
    public CaseController(CaseService caseService) {
        this.caseService = caseService;
    }

    @PostMapping(value = "/patientData")
    public String addMedCase(@ModelAttribute("medCase") CaseEntity medCase, @ModelAttribute("patient") PatientEntity patient) {

        caseService.addCase(medCase, patient.getId());
        return "redirect:/patientData/${patient.id}";
    }

    @PostMapping(value = "/updateStatus/caseId/{caseId}/targetStatus/{targetStatus}")
    public String getInWork(@PathVariable("caseId") String caseId, @PathVariable("targetStatus") String targetStatus){

        caseService.takeToWork(caseId, targetStatus);

        return "redirect:/caseData/${medCase.id}";
    }

//    @GetMapping(value = "medCases")
//    public String listCases(Model model) {
//        model.addAttribute("medCase");
//        model.addAttribute("listCases", this.caseService.listCases());
//
//        return "medCases";
//    }

    @GetMapping(value = "medCases")
    public ModelAndView listCases(@RequestParam(required = false) Integer page) {
        ModelAndView modelAndView = new ModelAndView("medCases");

        List<CaseBo> medCases = caseService.listCases();
        PagedListHolder<CaseBo> pagedListHolder = new PagedListHolder<CaseBo>(medCases);
        pagedListHolder.setPageSize(10);

        modelAndView.addObject("maxPages", pagedListHolder.getPageCount());

        if(page==null || page < 1 || page > pagedListHolder.getPageCount())
            page=1;

        modelAndView.addObject("page", page);

        if(page > pagedListHolder.getPageCount()){
            pagedListHolder.setPage(0);
            modelAndView.addObject("listCases", pagedListHolder.getPageList());
        }
        else if(page <= pagedListHolder.getPageCount()) {
            pagedListHolder.setPage(page-1);
            modelAndView.addObject("listCases", pagedListHolder.getPageList());
        }

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
