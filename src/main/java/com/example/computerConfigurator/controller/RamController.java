package com.example.computerConfigurator.controller;

import com.example.computerConfigurator.blocks.Cpu;
import com.example.computerConfigurator.blocks.Ram;
import com.example.computerConfigurator.repository.RamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("delram")
    public String delRam(@RequestParam int id) {
        Ram ram = ramRepository.findById(id).get();
        ramRepository.delete(ram);
        return "redirect:/addcomponents#ram";
    }

    @PostMapping("add")
    public String postRam(@ModelAttribute Ram ram, Model model) {
        model.addAttribute("ram", ram);
        ramRepository.save(ram);
        return "redirect:/ram";
    }
}
