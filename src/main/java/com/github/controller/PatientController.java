package com.github.controller;

import com.github.model.Patient;
import com.github.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PatientController {
    private PatientService patientService;

    @Autowired
    @Qualifier(value = "patientService")
    public void setPatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @RequestMapping(value = "patients", method = RequestMethod.GET)
    public String listPatients(Model model){
        model.addAttribute("patient", new Patient());
        model.addAttribute("listPatients", this.patientService.listPatients());

        return "medCases";
    }

}
