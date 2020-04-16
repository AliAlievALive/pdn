package ru.asu.pdn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.asu.pdn.model.Violation;
import ru.asu.pdn.service.impl.ViolationServiceImpl;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ViolationController {
    private final ViolationServiceImpl violationService;

    @Autowired
    public ViolationController(ViolationServiceImpl violationService) {
        this.violationService = violationService;
    }

    @GetMapping("/violations")
    public String viewViolations(Model model) {
        List<Violation> listViolations = violationService.findAll();
        model.addAttribute("listViolations", listViolations);
        return "violations";
    }

    @GetMapping("/new_violation")
    public String showNewViolationForm(Model model) {
        Violation violation = new Violation();
        model.addAttribute("violation", violation);

        return "new_violation";
    }

    @PostMapping(value = "/new_violation")
    public String saveViolation(
            @Valid @ModelAttribute("violation") Violation violation,
            BindingResult bindingResult
    ) {
        System.out.println(violation);
        if (!bindingResult.hasErrors()) {
            violationService.save(violation);

        }
        return "/new_violation";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditViolationForm(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("edit_violation");

        Violation violation = violationService.get(id);
        mav.addObject("violation", violation);

        return mav;
    }

    @GetMapping("/delete/{id}")
    public String deleteViolation(@PathVariable(name = "id") Long id) {
        violationService.delete(id);

        return "redirect:/violations";
    }
}
