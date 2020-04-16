package com.practice.mapper;

import com.practice.model.Schoolscore;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ScoreLineMapper {

    List<Schoolscore> getScoresBySchoolName(String schoolName);

    int getRankByScore(@Param("score") int score, @Param("sort") int sort);
}
