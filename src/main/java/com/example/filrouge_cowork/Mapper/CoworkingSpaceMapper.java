package com.example.filrouge_cowork.Mapper;

import com.example.filrouge_cowork.Dto.CoworkingSpaceDTO;
import com.example.filrouge_cowork.Entity.CoworkingSpace;
import com.example.filrouge_cowork.Repository.UserRepository;

public class CoworkingSpaceMapper {
    private final UserRepository userRepository;

    public CoworkingSpaceMapper(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public CoworkingSpace toEntity(CoworkingSpaceDTO dto) {
        CoworkingSpace entity = new CoworkingSpace();
        entity.setName(dto.getName());
        entity.setAddress(dto.getAddress());
        entity.setDescription(dto.getDescription());
        entity.setImage(dto.getImage());
        if (dto.getAdminId() != null) {
            userRepository.findById(dto.getAdminId()).ifPresent(entity::setAdmin);
        }
        return entity;
    }

    public CoworkingSpaceDTO toDTO(CoworkingSpace entity) {
        CoworkingSpaceDTO dto = new CoworkingSpaceDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setAddress(entity.getAddress());
        dto.setDescription(entity.getDescription());
        dto.setImage(entity.getImage());
        if (entity.getAdmin() != null) {
            dto.setAdminId(entity.getAdmin().getId());
        }
        return dto;
    }

}
