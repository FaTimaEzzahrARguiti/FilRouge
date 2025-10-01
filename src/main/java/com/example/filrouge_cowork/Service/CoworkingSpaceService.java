package com.example.filrouge_cowork.Service;


import com.example.filrouge_cowork.Dto.CoworkingSpaceDTO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CoworkingSpaceService {

    CoworkingSpaceDTO createSpace(CoworkingSpaceDTO coworkingSpaceDTO);
    CoworkingSpaceDTO getSpaceById(Long id);
    List<CoworkingSpaceDTO> getAllSpaces();
    CoworkingSpaceDTO updateSpace(Long id,CoworkingSpaceDTO coworkingSpaceDTO);
    void deleteSpace(Long id);
}
