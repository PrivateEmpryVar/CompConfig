package com.example.computerConfigurator.controller;

import com.example.computerConfigurator.blocks.Cpu;
import com.example.computerConfigurator.repository.ManufacturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.computerConfigurator.repository.CpuRepository;

@Controller
public class CpuController {
    private CpuRepository cpuRepository;
    private ManufacturerRepository manufacturerRepository;

    @Autowired
    public CpuController(CpuRepository cpuRepository, ManufacturerRepository manufacturerRepository) {
        this.cpuRepository = cpuRepository;
        this.manufacturerRepository = manufacturerRepository;
    }

    @GetMapping("cpu")
    public String mainPage(Model model) {
        model.addAttribute("cpuList", cpuRepository.findAll());
        model.addAttribute("cpu", new Cpu());
        return "cpu";
    }

    @GetMapping("/cpu/delcpu")
    public String delCpu(@RequestParam int id) {
        cpuRepository.delete(cpuRepository.findById(id).get());
        return "redirect:/cpu";
    }

    @PostMapping("cpu")
    public String postCpu(@ModelAttribute Cpu cpu, Model model) {
        model.addAttribute("cpu", cpu);
        manufacturerRepository.save(cpu.getManufacturer());
        cpuRepository.save(cpu);
        return "redirect:/cpu";
    }
}
