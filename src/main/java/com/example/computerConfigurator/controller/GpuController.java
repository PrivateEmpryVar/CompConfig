package com.example.computerConfigurator.controller;

import com.example.computerConfigurator.blocks.VideoCard;
import com.example.computerConfigurator.repository.GpuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/gpu")
public class GpuController {
    private GpuRepository gpuRepository;

    @Autowired
    public GpuController(GpuRepository gpuRepository) {this.gpuRepository = gpuRepository;}

    @GetMapping
    public String mainPage(Model model) {
        model.addAttribute("gpuList", gpuRepository.findAll());
        model.addAttribute("gpu", gpuRepository.findFirstByOrderByIdDesc().orElse(new VideoCard()));
        return "gpu";
    }

    @GetMapping("delhdd")
    public String delHdd(@RequestParam int id) {
        VideoCard videoCard = gpuRepository.findById(id).get();
        gpuRepository.delete(videoCard);
        return "redirect:/addcomponents#gpu";
    }

    @PostMapping("addhdd")
    public String postHdd(@ModelAttribute VideoCard videoCard, Model model) {
        model.addAttribute("gpu", videoCard);
        gpuRepository.save(videoCard);
        return "redirect:/gpu";
    }
}
