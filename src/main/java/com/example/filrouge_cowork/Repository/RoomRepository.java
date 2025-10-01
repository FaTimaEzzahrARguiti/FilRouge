package com.example.filrouge_cowork.Repository;

import com.example.filrouge_cowork.Entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room,Long> {
    List<Room> findBySpaceId(Long spaceId);
}
