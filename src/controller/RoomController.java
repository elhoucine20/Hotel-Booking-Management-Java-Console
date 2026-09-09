package controller;

import service.RoomService;

public class RoomController {

    RoomService roomService = new RoomService();


    public void serviceAffichierRooms(){
        roomService.repositoryAffichierRooms();
    }
    public void serviceAffichierRoomsAvailable(){
        roomService.setRoomsAvailableRepository();
    }

}
