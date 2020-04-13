package ru.asu.pdn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.asu.pdn.model.Child;
import ru.asu.pdn.model.Violation;
import ru.asu.pdn.service.impl.ChildServiceImpl;
import ru.asu.pdn.service.impl.ViolationServiceImpl;

import java.util.List;

@Controller
public class AppController {
    @Autowired
    private ViolationServiceImpl violationService;

    @Autowired
    private ChildServiceImpl childService;

    @RequestMapping("/")
    public String viewHomePage(Model model) {
        List<Violation> listViolations = violationService.listAll();
        model.addAttribute("listViolations", listViolations);
        return "index";
    }

    @RequestMapping("/new_violation")
    public String showNewViolationFrom(Model model) {
        Violation violation = new Violation();
        model.addAttribute("violation", violation);

        Child child = new Child();
        model.addAttribute("child", child);
        return "new_violation";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveViolation(@ModelAttribute("violation") Violation violation) {
        violationService.save(violation);

        return "redirect:/new_violation";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditViolationForm(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("edit_violation");

        Violation violation = violationService.get(id);
        mav.addObject("violation", violation);
        Child child = new Child();
        mav.addObject("child", child);
        return mav;
    }

    @RequestMapping("/delete/{id}")
    public String deleteViolation(@PathVariable(name = "id") Long id) {
        violationService.delete(id);

        return "redirect:/";
    }
}
