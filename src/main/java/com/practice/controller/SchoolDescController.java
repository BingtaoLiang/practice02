package com.practice.controller;

import com.practice.mapper.SchoolMapper;
import com.practice.model.Profession;
import com.practice.model.School;
import com.practice.service.ProfessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
public class SchoolDescController {
    @Autowired
    private SchoolMapper schoolMapper;


    /*
    * 根据学校id查询学校具体信息，如学校简介，学校层次等
    * */
    @RequestMapping("/school_desc_l/{scid}")
    public String profession(@PathVariable("scid") int scid, Model model) {
        School school = schoolMapper.findByScid(scid);
        List<Profession> proByScid = schoolMapper.getProByScid(scid);
        model.addAttribute("school",school);
        model.addAttribute("professions",proByScid);

        return "school_desc_l";
    }
}
