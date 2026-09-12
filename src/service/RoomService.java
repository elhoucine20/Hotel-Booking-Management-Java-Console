package service;

import domain.Room;
import enums.RoomStatus;
import repository.InMemoryRoomRepository;

import java.time.LocalDate;
import java.util.Map;
import java.util.UUID;

public class RoomService {


    public void repositoryAffichierRooms(InMemoryRoomRepository roomRepository){
        roomRepository.afichierRooms();
    }

    public void setRoomsAvailableRepository(InMemoryRoomRepository roomRepository){
        roomRepository.afichierRoomsAvailable();
    }


}
