package com.example.computerConfigurator.controller;

import com.example.computerConfigurator.blocks.Hdd;
import com.example.computerConfigurator.repository.HddRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/hdd")
public class HddController {
    private HddRepository hddRepository;

    @Autowired
    public HddController(HddRepository hddRepository) {this.hddRepository = hddRepository;}

    @GetMapping
    public String mainPage(Model model) {
        model.addAttribute("hddList", hddRepository.findAll());
        model.addAttribute("hdd", hddRepository.findFirstByOrderByIdDesc().orElse(new Hdd()));
        return "hdd";
    }

    @GetMapping("delhdd")
    public String delHdd(@RequestParam int id) {
        Hdd hdd = hddRepository.findById(id).get();
        hddRepository.delete(hdd);
        return "redirect:/addcomponents#hdd";
    }

    @PostMapping("addhdd")
    public String postHdd(@ModelAttribute Hdd hdd, Model model) {
        model.addAttribute("hdd", hdd);
        hddRepository.save(hdd);
        return "redirect:/hdd";
    }
}
