package com.likelion.deploy;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
public class HomeController {

    @GetMapping(value = {"/", "/{name}"})
    public String home(@PathVariable Optional<String> name, Model model) {
        model.addAttribute("name", name.orElse("아기사자"));
        return "index";
    }

    @GetMapping(value = "/photos")
    public String photoPage() {
        return "photo";
    }
}
