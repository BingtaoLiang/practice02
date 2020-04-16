package com.practice.service;

import org.springframework.stereotype.Service;

@Service
public class ProfessionService {

//    @Autowired
//    private School_ProMapper school_proMapper;
//    @Autowired
//    private ProfessionMapper professionMapper;
//
//    public List<School_ProDTO> selectProById(int id) {
//        List<School_Pro> school_proList = school_proMapper.selectPidById(id);        //通过id在School_Pro表中找到对应的pid
//        List<School_ProDTO> school_proDTOList = new ArrayList<>();                   //新建一个列表，用来存放School_ProDTO对象
//        for (School_Pro school_pro : school_proList) {                              //对上一步查询得到的pid列表，遍历这些pid在“专业”表中找到对应的专业名称
//            Profession profession = professionMapper.selectProByPid(school_pro.getPid());//查询对应pid的profession
//            School_ProDTO school_proDTO = new School_ProDTO();                         //实例化一个School_ProDTO对象，接下来为这个对象中的属性进行赋值
//            BeanUtils.copyProperties(school_pro, school_proDTO);                 //将School_pro中的id,pid赋值给school_proDTO
//            school_proDTO.setProfession(profession);                          //将查询到的profession属性放到school_proDTO中
//            school_proDTOList.add(school_proDTO);                             //到此，一个school_proDTO对象的所有属性赋值完成
//
//        }
//        return school_proDTOList;       //将查询到的school_proDTOList返回到Controller中
//    }
}
