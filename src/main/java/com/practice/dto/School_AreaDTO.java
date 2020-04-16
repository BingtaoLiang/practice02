package com.practice.dto;

import com.practice.model.School;
import lombok.Data;

@Data
public class School_AreaDTO {
    private int aid;
    private String aname;
    private School school;
}
