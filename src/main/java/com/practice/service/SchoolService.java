package com.practice.service;

import com.practice.mapper.SchoolMapper;
import com.practice.model.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolService {


    @Autowired
    private SchoolMapper schoolMapper;


    public List<School> selectSchByAreaid(int areaid) {
//        List<Area> areaList = areaMapper.selectAnameByAid(aid);
//        List<School_AreaDTO> school_areaDTOList = new ArrayList<>();
//        for (Area area : areaList) {
//            List<School> schoolList = (List<School>) schoolMapper.selectNameByAname(area.getAname());
//            School_AreaDTO school_areaDTO = new School_AreaDTO();
//            BeanUtils.copyProperties(area, school_areaDTO);
//            school_areaDTO.setSchool(sch);
//            school_areaDTOList.add(school_areaDTO);
//        }
//        return school_areaDTOList;
//        Area area = areaMapper.selectAnameByAid(aid);
//        List<School> schoolList = schoolMapper.selectNameByAname(area.getAname());

        List<School> schoolList=schoolMapper.selectNameByAreaid(areaid);
        return schoolList;
    }
}
