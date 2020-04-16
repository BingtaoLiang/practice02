package com.practice.controller;


import com.practice.mapper.AreaMapper;
import com.practice.model.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class AreaController {
    @Autowired
    private AreaMapper areaMapper;

    /*
    /根据地区、省份查找学校
    1.查找所有地区（华北地区，华中地区，西北地区...）
     */
    @RequestMapping("/area")
    public String area(Model model) {
        List<School> regionList = areaMapper.regionList();
//        List<School> areaList = areaMapper.list();
//        model.addAttribute("areas", areaList);
        model.addAttribute("regions", regionList);
        return "region";
    }


    /*
    /根据地区、省份查找学校
    2.根据地区reid查找该地区所有省份
     */
    @RequestMapping("/area/{reid}")
    public String schoolList(@PathVariable(name="reid") Integer reid, Model model){
        List<School> areaByReid = areaMapper.getAreaByReid(reid);
        model.addAttribute("areas",areaByReid);
        return "area";
    }
}
