package com.example.filrouge_cowork.Service;

import com.example.filrouge_cowork.Dto.CoworkingSpaceDTO;
import com.example.filrouge_cowork.Entity.CoworkingSpace;
import com.example.filrouge_cowork.Mapper.CoworkingSpaceMapper;
import com.example.filrouge_cowork.Repository.CoworkingSpaceRepository;
import com.example.filrouge_cowork.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class CoworkingSpaceImpl implements CoworkingSpaceService{


    private final CoworkingSpaceRepository coworkingSpaceRepository;
    private final CoworkingSpaceMapper coworkingSpaceMapper;
    private final UserRepository userRepository;


    @Autowired
    public CoworkingSpaceImpl(CoworkingSpaceRepository coworkingSpaceRepository, CoworkingSpaceMapper coworkingSpaceMapper, UserRepository userRepository) {
        this.coworkingSpaceRepository = coworkingSpaceRepository;
        this.coworkingSpaceMapper = coworkingSpaceMapper;
        this.userRepository = userRepository;
    }


    public CoworkingSpaceDTO createSpace(CoworkingSpaceDTO coworkingSpaceDTO){
        CoworkingSpace coworkingSpace= coworkingSpaceMapper.toEntity(coworkingSpaceDTO);
        CoworkingSpace saved= coworkingSpaceRepository.save(coworkingSpace);
        return coworkingSpaceMapper.toDTO(saved);
    }

    public CoworkingSpaceDTO getSpaceById(Long id){
        Optional<CoworkingSpace> coworkingSpace = coworkingSpaceRepository.findById(id);
        return coworkingSpace.map(coworkingSpaceMapper::toDTO).orElse(null);
    }

    public List<CoworkingSpaceDTO> getAllSpaces(){
        return coworkingSpaceRepository.findAll().stream().map(coworkingSpaceMapper::toDTO).collect(Collectors.toList());
    }

    public CoworkingSpaceDTO updateSpace(Long id,CoworkingSpaceDTO coworkingSpaceDTO){
        Optional<CoworkingSpace> existingSpace= coworkingSpaceRepository.findById(id);
        if(existingSpace.isPresent()){
            CoworkingSpace coworkingSpace=coworkingSpaceMapper.toEntity(coworkingSpaceDTO);

            coworkingSpace.setId(id);
            CoworkingSpace updatedSpace= coworkingSpaceRepository.save(coworkingSpace);
            return coworkingSpaceMapper.toDTO(updatedSpace);
        }
        return null;
    }

    public void deleteSpace(Long id) {
        CoworkingSpace space = coworkingSpaceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Space not found"));
        coworkingSpaceRepository.delete(space);
    }



//    public List<NombreReservation> CountReservation(){
//        return coworkingSpaceRepository.CountReservation();
//
//    }



}
