package com.practice.controller;


import com.practice.mapper.GaokaoMapper;
import com.practice.mapper.ScoreLineMapper;
import com.practice.model.Gaokao;
import com.practice.model.Schoolscore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ScoreLineController {
    @Autowired
    private ScoreLineMapper scoreMapper;

    @Autowired
    private GaokaoMapper gaokaoMapper;


    /*
     * 根据学校名称查找该学校历年分数线及最低位次
     * 对应“智能填报”-->“分数线”
     * */
    @RequestMapping("/scorelines")
    public String schoolScoreLine(HttpServletRequest request, Model model,
                                  @RequestParam(name="schoolName") String schoolName) {
//        String schoolName = request.getParameter("schoolName");
        List<Schoolscore> scoresBySchoolName = scoreMapper.getScoresBySchoolName(schoolName);//查询院校分数线
        List<Gaokao> proAndCalendarData = gaokaoMapper.getProAndCalendarData(schoolName);//查询专业招生计划和历年数据
        model.addAttribute("scorelines", scoresBySchoolName);
        model.addAttribute("proAndCalData", proAndCalendarData);
        return "fenshuxian";
    }


    /*
     * 根据预估分数，查询位次及建议位次区间
     * rankByScoreLow 为预估分数分数的最低位次
     * rankByScoreHigh 为比该预估分数分数多1分的最低位次，这个位次减1（rankByScoreHigh-1）就是预估分数的最高位次
     * 所以推荐位次范围是（rankByScoreLow,rankByScoreHigh-1）
     * */
    @RequestMapping("/rankSearch")
    public String rankSearch(HttpServletRequest request,
//                             @RequestParam(name="score") int score,
//                             @RequestParam(name="sort") int sort,
                             Model model) {
        int score =Integer.parseInt(request.getParameter("score")) ;
        int sort =Integer.parseInt(request.getParameter("sort")) ;

        int rankByScoreLow = scoreMapper.getRankByScore(score,sort);
        score++;
        int rankByScoreHigh = scoreMapper.getRankByScore(score,sort);
        rankByScoreHigh++;
        model.addAttribute("rankLow", rankByScoreLow);
        model.addAttribute("rankHigh", rankByScoreHigh);
        model.addAttribute("score", score-1);
        model.addAttribute("sort", sort);

        return "weici";
    }
}
