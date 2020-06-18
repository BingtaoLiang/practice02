package com.practice.mapper;

import com.practice.model.Profession;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProfessionMapper {

    List<Profession> getProfessionByScid(@Param("scid") int scid);

    List<Profession> selectDistinctMajor();

    Profession selectByPid(Integer code);

    List<Profession> getProfessionByProname(String profession);
}
