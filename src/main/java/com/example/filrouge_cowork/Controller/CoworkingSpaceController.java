package com.example.filrouge_cowork.Controller;

import com.example.filrouge_cowork.Dto.CoworkingSpaceDTO;
import com.example.filrouge_cowork.Service.CoworkingSpaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;




@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/space")
public class CoworkingSpaceController {

    @Autowired
    private CoworkingSpaceService coworkingSpaceService;

    @PostMapping
    public CoworkingSpaceDTO addSpace(@RequestBody CoworkingSpaceDTO dto){
        return coworkingSpaceService.createSpace(dto);
    }

    @GetMapping
    public List<CoworkingSpaceDTO> getAll(){
        return coworkingSpaceService.getAllSpaces();
    }

    @PutMapping("/{id}")
    public CoworkingSpaceDTO update(@PathVariable Long id, @RequestBody CoworkingSpaceDTO dto){
        return coworkingSpaceService.updateSpace(id,dto);
    }

    @DeleteMapping("/{id}")
    public void delete (@PathVariable Long id){
        coworkingSpaceService.deleteSpace(id);
    }

    @GetMapping("/{id}")
    public CoworkingSpaceDTO getById(@PathVariable Long id){
        return coworkingSpaceService.getSpaceById(id);
    }




//    @GetMapping("/count")
//    public List<NombreReservation> CountReservation(){
//        return coworkingSpaceService.CountReservation();
//    }


}
