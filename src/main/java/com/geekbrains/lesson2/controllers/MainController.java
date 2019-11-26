package com.geekbrains.lesson2.controllers;

import com.geekbrains.lesson2.entities.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@Controller
public class MainController {
    // GET http://localhost:8189/app/
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showHomePage() {
        return "index";
    }

    // GET http://localhost:8189/app/redirectMe
    @RequestMapping(value = "/redirectMeHomePlease", method = RequestMethod.GET)
    public String redirectMeHomePlease() {
        return "redirect:/";
    }

    // GET http://localhost:8189/app/path/20/java/100
    @GetMapping("/path/{id}/{text}/100")
    @ResponseBody
    public String pathTest(@PathVariable(value = "id") Long id, @PathVariable(value = "text") String text) {
        return text + ": " + id;
    }

    // GET http://localhost:8189/app/path?data=20
    @GetMapping("/param")
    @ResponseBody
    public String pathTest(@RequestParam(value = "data", required = false) Integer data) {
        if(data != null) {
            return "Your param 'data': " + data;
        }
        return "Your param 'data' is empty";
    }

    // GET http://localhost:8189/app/info?msg=hello
    @GetMapping("/info")
    public String showInfoPage(Model model, @RequestParam(name = "msg", required = false) String msg) {
        model.addAttribute("message", msg);
        model.addAttribute("product", new Product(1L, "rice", new BigDecimal(67.0)));
        return "info";
    }
}
