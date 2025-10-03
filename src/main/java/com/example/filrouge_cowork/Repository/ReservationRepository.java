package com.example.filrouge_cowork.Repository;

import com.example.filrouge_cowork.Entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    List<Reservation> findByRoom_Space_Id(Long id);

}
