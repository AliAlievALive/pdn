package ru.asu.pdn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.asu.pdn.model.Violation;
import ru.asu.pdn.service.impl.ViolationServiceImpl;

import java.util.List;

@Controller
public class AppController {
    @Autowired
    private ViolationServiceImpl violationService;

    @RequestMapping("/")
    public String viewHomePage() {
        return "index";
    }
}
