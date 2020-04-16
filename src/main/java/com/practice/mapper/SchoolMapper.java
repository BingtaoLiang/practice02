package com.practice.mapper;

import com.practice.model.School;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SchoolMapper {


//    @Select("select * from school")
//    List<School> schoolList();

//    @Select("select * from school where id =#{id}")
//    School selectNameById(@Param("id") int id);

//    @Select("select * from school where area = #{aname}")
//    List<School> selectNameByAname(@Param("aname") String aname);

//    @Select("select * from school where areaid = #{aid}")
    List<School> selectNameByAreaid(@Param("areaid") int areaid);

    List<School> getSchoolByPro(String proname);

    List<School> getSchoolByName(String name);

//    List<School> findAllSchool(@Param("areaId")  Integer areaId ,@Param("type") String type,@Param("is985") Integer is985,@Param("is211") Integer is211,@Param("isdoublefirstclass") Integer isdoublefirstclass);

    List<School> findAllSchool(@Param("areaId") String[] areaId, @Param("type") String type, @Param("is985") Integer is985, @Param("is211") Integer is211, @Param("isdoublefirstclass") Integer isdoublefirstclass);

    School findSchool(@Param("schoolname") String schoolname);

}
