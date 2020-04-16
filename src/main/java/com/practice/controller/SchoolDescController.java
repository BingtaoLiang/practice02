package com.practice.controller;

import com.practice.service.ProfessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class SchoolDescController {
    @Autowired
    private ProfessionService professionService;

    @RequestMapping("/school_desc/{scid}")
    public String profession(@PathVariable("scid") int scid, Model model) {
        return "sch_pro";
    }
}
