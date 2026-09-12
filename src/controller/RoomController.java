package controller;

import repository.InMemoryRoomRepository;
import service.RoomService;

public class RoomController {

    //RoomService roomService ;


    public void serviceAffichierRooms(InMemoryRoomRepository roomRepo,RoomService romService){

        romService.repositoryAffichierRooms(roomRepo);
    }
    public void serviceAffichierRoomsAvailable(InMemoryRoomRepository roomRepo,RoomService romService){
        romService.setRoomsAvailableRepository(roomRepo);
    }

}
