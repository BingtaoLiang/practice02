package com.practice.controller;


import com.practice.mapper.SchoolMapper;
import com.practice.model.School;
import com.practice.service.SchoolService;
import org.apache.log4j.Logger;
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
public class SchoolController {

    Logger logger = Logger.getLogger(SchoolController.class);


    @Autowired
    private SchoolService schoolService;

    @Autowired
    private SchoolMapper schoolMapper;

    /*
     * 根据省份areaid查找对应省份的学校
     * */
    @GetMapping("/school/{areaid}")
    public String school(Model model, @PathVariable(name = "areaid") int areaid) {
        List<School> schoolList = schoolService.selectSchByAreaid(areaid);
        model.addAttribute("schools", schoolList);
        return "schList";
    }

    /**
     * @Description 在找大学页面展示所有大学按地区排序
     * @Param 无
     * @Return school类
     * @Author Mr.Liang
     * @Date 2020/4/4
     * @Time 9:36
     */
    @RequestMapping("/schoolHomepage")
    public String findAllSchool(Model model,
                                HttpServletRequest request,
//                                @RequestParam(name = "areaId", required = false) String[] areaId,
                                @RequestParam(name = "type", required = false) String type,
                                @RequestParam(name = "is985", required = false) Integer is985,
                                @RequestParam(name = "is211", required = false) Integer is211,
                                @RequestParam(name = "isdoublefirstclass", required = false) Integer isdoublefirstclass) {

//        if (areaId != null) {
//            String[] split = areaId.split("_");
//            List<School> allSchool = schoolMapper.findAllSchool(split, type, is985, is211,isdoublefirstclass);
////            List<School> allSchool = schoolMapper.findAllSchool(areaId, type, is985, is211,isdoublefirstclass);
//            model.addAttribute("allschool", allSchool);
//            return "zhaodaxue";
//        }
//        else {
//            String[] split=null;
//            List<School> allSchool = schoolMapper.findAllSchool(split, type, is985, is211,isdoublefirstclass);
////            List<School> allSchool = schoolMapper.findAllSchool(areaId, type, is985, is211,isdoublefirstclass);
//            model.addAttribute("allschool", allSchool);
//            return "zhaodaxue";
//        }

//        List<School> allSchool = schoolMapper.findAllSchool(areaId, type, is985, is211, isdoublefirstclass);
//        model.addAttribute("allschool",allSchool);


        String[] areaId = request.getParameterValues("areaId");
        List<School> allSchool = schoolMapper.findAllSchool(areaId, type, is985, is211, isdoublefirstclass);
        model.addAttribute("allschool", allSchool);
        return "zhaodaxue";

    }

    /*
     * 输入学校名称查询相应的学校
     * */
    @RequestMapping("/schoolsearch")
    public String getSchoolByName(HttpServletRequest request, Model model) {
        String schoolname = request.getParameter("schoolname");
        School school = schoolMapper.findSchool(schoolname);
        model.addAttribute("school", school);
        return "";
    }

    /*
     * 根据学校名称查找相应学校的专业
     * 对应网站上（根据大学选专业）
     * */
    @RequestMapping("/school/subject")
    public String getSchoolBySname(HttpServletRequest request, Model model) {
        String schoolName = request.getParameter("schoolName");
        List<School> schoolProByName = schoolMapper.getSchoolByName(schoolName);
        model.addAttribute("schoolPros", schoolProByName);
        return "chaxun";
    }

    /*
     * 根据专业名称查找开设该专业的学校
     * */
    @RequestMapping("/school/major/{proname}")
    public String getSchoolByPro(Model model, @PathVariable(name = "proname") String proname) {
        List<School> schoolByPro = schoolMapper.getSchoolByPro(proname);
        model.addAttribute("schoolList", schoolByPro);
        return "";
    }

}
