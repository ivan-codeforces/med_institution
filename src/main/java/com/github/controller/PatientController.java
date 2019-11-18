package com.github.controller;

import com.github.model.Patient;
import com.github.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PatientController {
    private PatientService patientService;

    @Autowired(required = true)
    @Qualifier(value = "patientService")
    public void setPatientService(PatientService patientService) {
        this.patientService = patientService;
    }

    @RequestMapping(value = "patients", method = RequestMethod.POST)
    public String addPatient(@ModelAttribute("patient") Patient patient) {
        patientService.addPatient(patient);
        return "redirect:/patients";
    }

    @RequestMapping(value = "patients", method = RequestMethod.POST)
    public String updatePatient(@ModelAttribute("patient") Patient patient) {
        patientService.updatePatient(patient);
        return "redirect:/patients";
    }

    @RequestMapping(value = "patients", method = RequestMethod.GET)
    public String listPatients(Model model) {
        model.addAttribute("patient", new Patient());
        model.addAttribute("listPatients", this.patientService.listPatients());

        return "patients";
    }

    @RequestMapping("patientData/{id}")
    public String patientData(@PathVariable("id") int id, Model model) {
        model.addAttribute("patient", this.patientService.getPatientById(id));

        return "patientData";
    }

}
