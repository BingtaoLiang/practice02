package com.practice.controller;

import com.practice.mapper.GaokaoMapper;
import com.practice.model.Gaokao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class FillinController {

    @Autowired
    private GaokaoMapper gaokaoMapper;


    /*
    * 根据院校所在省份，院校类型，考生所在省份，考生成绩，考生位次,批次查询填报学校及专业
    * */
    @RequestMapping("/onekeyFillin")
    public String onekeyFillin(@RequestParam(name="province",required = false)String province,
                               @RequestParam(name="type",required = false)String type,
                               HttpServletRequest request,
                               Model model){

        request.getSession().getAttribute("user"); //通过session获取用户所在省份，用户分数等个人信息

        List<Gaokao> gaokaos = gaokaoMapper.selectSch(province, type);
        model.addAttribute("gaokaos",gaokaos);
        return "";
    }
}
