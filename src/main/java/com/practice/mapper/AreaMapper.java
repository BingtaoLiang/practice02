package com.practice.mapper;

import com.practice.model.School;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AreaMapper {

    List<School> regionList();

    List<School> getAreaByReid(Integer reid);
}
