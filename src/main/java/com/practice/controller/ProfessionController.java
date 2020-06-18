package com.practice.controller;

import com.practice.mapper.ProfessionMapper;
import com.practice.mapper.SchoolMapper;
import com.practice.model.Gaokao;
import com.practice.model.Profession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ProfessionController {
    @Autowired
    private ProfessionMapper professionMapper;
    @Autowired
    private SchoolMapper schoolMapper;

    /**
     *根据学校scid查找该学校开设的专业
     */

    @GetMapping("/profession/{scid}")
    public String profession(Model model,
                             @PathVariable(name = "scid") int scid){
        List<Profession> professionByScid = professionMapper.getProfessionByScid(scid);
        model.addAttribute("professions",professionByScid);
        return "";
    }


    /*
    * 查找所有的学科门类和门类下所包含的专业pid,专业名称，专业代码
    * 对应网站（“查专业”）
    */
    @GetMapping("/majors/Homepage")
    public String majors(Model model) {
        List<Profession> majors = professionMapper.selectDistinctMajor();
        model.addAttribute("majors",majors);
        return "zhaozhuanye";
    }

    /*
    * 根据输入的专业名称查找该专业的相关信息
    * 对应网站（“查专业”-->"输入关键词，搜索"）
    * */

    @RequestMapping("/majors")
    public String getProfession(HttpServletRequest request, Model model){
        String profession = request.getParameter("profession");
        List<Profession> professionByProname = professionMapper.getProfessionByProname(profession);
        model.addAttribute("majors", professionByProname);
        return "zhaozhuanye";
    }



    /*
    * 根据专业pid查找对应专业的具体信息，如专业描述，修业年限等信息
    * 对应“查专业”页面中点击专业操作
    * */
    @GetMapping("/profession_desc/{pid}")
    public String profession(Model model,
                             @PathVariable(name="pid") Integer pid){
        Profession profession = professionMapper.selectByPid(pid);
        List<Gaokao> schoolByPid = schoolMapper.getSchoolByPid(pid);
        model.addAttribute("profession",profession);
        model.addAttribute("schools",schoolByPid);
        return "profession_desc";
    }

    /*
    * 首页“找大学/查专业”----查专业
    * */
    @RequestMapping("/indexSearch/profession")
    public String getProfessions(HttpServletRequest request,Model model){
        String indexSearchInput = request.getParameter("indexSearchInput");
        List<Profession> professionByProname = professionMapper.getProfessionByProname(indexSearchInput);
        model.addAttribute("professions",professionByProname);
        return "indexsearch";
    }
}
