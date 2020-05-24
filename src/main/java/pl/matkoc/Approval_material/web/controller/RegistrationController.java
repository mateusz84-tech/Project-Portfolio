package pl.matkoc.Approval_material.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.matkoc.Approval_material.service.RegistrationService;
import pl.matkoc.Approval_material.service.registration.RegistrationData;

import javax.validation.Valid;

@Controller
@RequestMapping("/register") @Slf4j
public class RegistrationController {

    private final RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @GetMapping
    public String prepareRegistrationPage(Model model){
        model.addAttribute("registrationData", new RegistrationData());
                return "registration/form";
    }

    @PostMapping
    public String procesRegistrationData(@Valid RegistrationData registrationData, BindingResult errors){
        log.debug("Dane do rejestracji: {}", registrationData);
        if(errors.hasErrors()){
            log.debug("Dane do rejestracji: {}",errors);
            return "registration/form";
        }
        registrationService.register(registrationData);
        log.debug("Poprawne zarejestrowanie: {}", registrationData);
        return "registration/success";
    }
}
