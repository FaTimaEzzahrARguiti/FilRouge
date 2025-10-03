package com.example.filrouge_cowork.Service;

import com.example.filrouge_cowork.Dto.ReservationDTO;
import com.example.filrouge_cowork.Entity.Reservation;
import com.example.filrouge_cowork.Entity.Room;
import com.example.filrouge_cowork.Entity.User;
import com.example.filrouge_cowork.Mapper.ReservationMapper;
import com.example.filrouge_cowork.Repository.ReservationRepository;
import com.example.filrouge_cowork.Repository.RoomRepository;
import com.example.filrouge_cowork.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class ReservationImpl implements ReservationService{


    private final ReservationRepository reservationRepository;

    private final ReservationMapper reservationMapper;
    private final RoomRepository roomRepository;

    private final UserRepository userRepository;

    @Autowired
    public ReservationImpl(ReservationRepository reservationRepository, ReservationMapper reservationMapper,
                              RoomRepository roomRepository, UserRepository userRepository) {
        this.reservationRepository = reservationRepository;
        this.reservationMapper = reservationMapper;
        this.roomRepository = roomRepository;
        this.userRepository = userRepository;
    }


    public ReservationDTO addReservation(ReservationDTO reservationDTO) {
        User user = userRepository.findById(reservationDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("Utilisateur introuvable"));

        Room room = roomRepository.findById(reservationDTO.getRoomId())
                .orElseThrow(() -> new RuntimeException("Salle introuvable"));

        Reservation reservation = reservationMapper.toEntity(reservationDTO, user, room);
        Reservation savedReservation = reservationRepository.save(reservation);

        return reservationMapper.toDTO(savedReservation);
    }


    public List<ReservationDTO> GetReservations(){
        return reservationRepository.findAll()
                .stream().map(reservationMapper::toDTO).collect(Collectors.toList());
    }

    public ReservationDTO findReservationById(Long id){
        Reservation reservation = reservationRepository.findById(id).orElseThrow(()->new RuntimeException(("réservation introuvable")));
        return reservationMapper.toDTO(reservation);
    }



    public void deleteReservation(Long id){
        reservationRepository.deleteById(id);
    }


    public ReservationDTO updateReservation(Long id, ReservationDTO updatedReservationDTO) {
        Reservation existingReservation = reservationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Réservation introuvable"));

        existingReservation.setStartTime(updatedReservationDTO.getStartTime());
        existingReservation.setEndTime(updatedReservationDTO.getEndTime());
        existingReservation.setStatus(updatedReservationDTO.getStatus());
        existingReservation.setTotalPrice(updatedReservationDTO.getTotalPrice());

        Reservation savedReservation = reservationRepository.save(existingReservation);

        return reservationMapper.toDTO(savedReservation);
    }

    public List<ReservationDTO> getReservationsByCoworkingSpaceId(Long spaceId) {
        return reservationRepository.findByRoom_Space_Id(spaceId)
                .stream()
                .map(reservationMapper::toDTO)
                .collect(Collectors.toList());
    }



}
