package com.practice.dto;

import com.practice.model.Profession;
import lombok.Data;

@Data
public class School_ProDTO {
    private int id;
    private int pid;
    private int score;
    private Profession profession;
}
