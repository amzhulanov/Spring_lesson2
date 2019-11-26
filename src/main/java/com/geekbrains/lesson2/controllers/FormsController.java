package com.geekbrains.lesson2.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FormsController {
    @RequestMapping("/show_simple_form")
    public String showSimpleForm() {
        return "simple_form";
    }

    @RequestMapping(path = "/simple_form_processing", method = RequestMethod.GET)
    public String simpleProcessForm() {
        return "simple_form_result";
    }

    @RequestMapping("/show_mod_form")
    public String showModForm() {
        return "mod_form";
    }

    @RequestMapping(path = "/mod_form_processing", method = RequestMethod.GET)
    public String modProcessForm(@RequestParam("title") String title, Model model) {
        title = "Modified: " + title;
        model.addAttribute("title", title);
        return "mod_form_result";
    }
    @RequestMapping("/show")
    public String showCatalog(){return "all_products";}

    @RequestMapping("/show_search_form")
    public String showSearchForm(){return "product_search";}




}
