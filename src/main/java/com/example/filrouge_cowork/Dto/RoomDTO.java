package com.example.filrouge_cowork.Dto;


import com.example.filrouge_cowork.Enum.Type;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomDTO {

    private Long id;
    private String name;
    private Type type;
    private String description;
    private String capacity;
    private String image;
    private Double price;
    private Long coworkingSpaceId;
    private boolean isAvailable;
}
