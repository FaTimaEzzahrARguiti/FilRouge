package com.example.filrouge_cowork.Service;


import com.example.filrouge_cowork.Dto.ReservationDTO;

import java.util.List;

public interface ReservationService {

    ReservationDTO addReservation(ReservationDTO reservationDTO);

    List<ReservationDTO> GetReservations();


    ReservationDTO findReservationById(Long id);

    void deleteReservation(Long id);

    ReservationDTO updateReservation(Long id, ReservationDTO updatedReservationDTO);

    List<ReservationDTO> getReservationsByCoworkingSpaceId(Long spaceId);

}
