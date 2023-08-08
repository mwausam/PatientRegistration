package hosp.patientreg;


import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/")
@Slf4j
public class HomeController {

    private final PatientRepository patientRepository;

    public HomeController(PatientRepository patientRepository){
        this.patientRepository=patientRepository;
    }

    @ModelAttribute(name = "patient")
    public Patient patient() {
        return new Patient();
    }

    @GetMapping
    public String home(){
        return "home";
    }

    @PostMapping
    public String processOrder(@Valid Patient patient,Errors errors, SessionStatus sessionStatus){

        if(errors.hasErrors())
            return "home";

        log.info("Patient info "+patient.toString());

        patientRepository.save(patient);
        
        return "redirect:/";
    }

}
