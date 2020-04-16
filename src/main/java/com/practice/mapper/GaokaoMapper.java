package com.practice.mapper;

import com.practice.model.Gaokao;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GaokaoMapper {

    List<Gaokao> getProAndCalendarData(String schoolName);

    List<Gaokao> selectSch(String province, String type);
}
