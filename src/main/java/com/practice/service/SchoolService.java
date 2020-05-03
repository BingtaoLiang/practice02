package com.practice.service;

import com.practice.dto.PaginationDTO;
import com.practice.mapper.SchoolMapper;
import com.practice.model.School;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class SchoolService {


    @Autowired
    private SchoolMapper schoolMapper;

    public PaginationDTO list(Integer page, Integer size, String[] areaId, String type, Integer is985, Integer is211, Integer isdoublefirstclass) {
        PaginationDTO paginationDTO = new PaginationDTO();
        Integer totalPage;
        Integer totalCount = schoolMapper.count(areaId,type,is985,is211,isdoublefirstclass);    //计算出学校总数
        /* 计算总页数 */
        if (totalCount % size == 0) {
            totalPage = totalCount / size;
        } else {
            totalPage = totalCount / size + 1;
        }

        /* 容错处理*/
        if (page < 1) {
            page = 1;
        }
        if (page > totalPage) {
            page = totalPage;
        }
        if (page == 0) {
            page = 1;
        }
        paginationDTO.setPagination(totalPage, page);//setPagination方法来计算页面的展示逻辑
        Integer offset = size * (page - 1); //偏移量和页码的关系
//        PaginationDTO schools = schoolMapper.findAllSchool(offset, size, areaId, type, is985, is211, isdoublefirstclass);//获得问题列表
        List<School> schools = schoolMapper.findAllSchool(offset, size, areaId, type, is985, is211, isdoublefirstclass);//获得问题列表
        paginationDTO.setSchools(schools);

        return  paginationDTO;
    }

}
