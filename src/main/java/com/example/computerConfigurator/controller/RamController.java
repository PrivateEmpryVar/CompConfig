package com.example.computerConfigurator.controller;

import com.example.computerConfigurator.blocks.Ram;
import com.example.computerConfigurator.repository.RamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ram")
public class RamController {
    private RamRepository ramRepository;

    @Autowired
    public RamController(RamRepository ramRepository) {this.ramRepository = ramRepository;}

    @GetMapping
    public String mainPage(Model model) {
        model.addAttribute("ramList", ramRepository.findAll());
        model.addAttribute("ram", ramRepository.findFirstByOrderByIdDesc().orElse(new Ram()));
        return "ram";
    }

    @PostMapping("add")
    public String postRam(@ModelAttribute Ram ram, Model model) {
        model.addAttribute("ram", ram);
        ramRepository.save(ram);
        return "redirect:/ram";
    }
}
