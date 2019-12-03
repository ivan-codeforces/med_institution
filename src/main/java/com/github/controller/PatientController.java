package com.github.controller;

import com.github.bo.CaseBo;
import com.github.bo.PatientBo;
import com.github.model.PatientEntity;
import com.github.service.CaseService;
import com.github.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PatientController {
    private PatientService patientService;
    private CaseService caseService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }


    public PatientController(CaseService caseService) {
        this.caseService = caseService;
    }

    @PostMapping(value = "patients")
    public String addPatient(@ModelAttribute("patient") PatientEntity patient) {
        patientService.addPatient(patient);
        return "redirect:/patients";
    }

    @GetMapping(value = "patients")
    public String listPatients(Model model) {
        model.addAttribute("patient", new PatientEntity());
        model.addAttribute("listPatients", this.patientService.listPatients());

        return "patients";
    }

    @GetMapping("patientData/{id}")
    public String patientData(@PathVariable("id") int id, Model model) {
        PatientBo patientById = this.patientService.getPatientById(id);
        model.addAttribute("patient", patientById);
        List<CaseBo> attributeValue = this.caseService.listCasesByPatientId(id);
        model.addAttribute("listCasesByPatientId", attributeValue);

        return "patientData";
    }

}
