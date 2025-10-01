package com.example.filrouge_cowork.Dto;


import lombok.Data;

@Data
public class CoworkingSpaceDTO {

    private Long id;
    private String name;
    private String address;
    private String description;
    private String image;
    private Long adminId;
}
