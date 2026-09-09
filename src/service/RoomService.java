package service;

import repository.InMemoryRoomRepository;

public class RoomService {

    InMemoryRoomRepository roomRepository = new InMemoryRoomRepository();

    public void repositoryAffichierRooms(){
        roomRepository.afichierRooms();
    }

    public void setRoomsAvailableRepository(){
        roomRepository.afichierRoomsAvailable();
    }
}
