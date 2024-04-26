package com.example.catsss;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CatController {

@Autowired
    private CatService catService;

@GetMapping("/")
    public String showForm() {
        return "catForm";
    }

@PostMapping("/getCats")
    public String getCats(@RequestParam("filename") String filename, Model model) {
        List<Cat> cats = catService.getCatsFromFile(filename);
        model.addAttribute("cats", cats);
        return "catList";
    }
}
