package controller;

import repository.InMemoryRoomRepository;
import service.RoomService;

public class RoomController {

    RoomService roomService = new RoomService();


    public void serviceAffichierRooms(InMemoryRoomRepository roomRepo){
        roomService.repositoryAffichierRooms(roomRepo);
    }
    public void serviceAffichierRoomsAvailable(InMemoryRoomRepository roomRepo){
        roomService.setRoomsAvailableRepository(roomRepo);
    }

}
