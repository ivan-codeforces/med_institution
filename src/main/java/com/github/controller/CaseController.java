package com.github.controller;

import com.github.model.CaseEntity;
import com.github.model.PatientEntity;
import com.github.service.CaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CaseController {
    private CaseService caseService;

    @Autowired
    public CaseController(CaseService caseService) {
        this.caseService = caseService;
    }

    @PostMapping(value = "medCase")
    public String addMedCase(@ModelAttribute("medCase") CaseEntity medCase, @ModelAttribute("patient") PatientEntity patient) {

        caseService.addCase(medCase, patient.getId());
        return "redirect:/patientData/${patient.id}";
    }

    @GetMapping(value = "medCases")
    public String listCases(Model model) {
        model.addAttribute("medCase");
        model.addAttribute("listCases", this.caseService.listCases());

        return "medCases";
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
