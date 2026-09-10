package controller;

import domain.User;
import enums.ReservationStatus;
import repository.InMemoryRoomRepository;
import repository.impl.RoomRepository;
import service.ReservationService;
import util.InputUtils;
import util.Menus;

import java.security.spec.ECField;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ReservationController {
    ReservationService reservationService = new ReservationService();


    public void reservationServiceAffichier(User user){
        reservationService.myReservationsService(user);
    }

    public void createReservationController(Scanner scanner , User user, InMemoryRoomRepository roomRepository){

try {
    String reservationCode  = InputUtils.lireString(scanner,"Saisir code de Reservation :");
    String roomNumber  = InputUtils.lireString(scanner,"Saisir Room Number :");
    int numberOfGuests  = InputUtils.lireInt(scanner,"Saisir Number Of Guests :");
    //long numberOfNighits  = InputUtils.lireLong(scanner,"Saisir Number Of Nights :");
    String dateDebut = InputUtils.lireString(scanner,"saisie la date de checkIn (slvp sous form 'YYYY,MM,DD')");
    String dateFin =InputUtils.lireString(scanner,"saisie la date de checkOut (slvp sous form 'YYYY,MMM,DD')");
    reservationService.createReservationService(roomRepository,user,reservationCode,roomNumber,numberOfGuests,dateDebut,dateFin);

}catch (Exception e){
    System.out.println(e.getMessage());
}

    }

    public void cancelReservationController(Scanner scanner,User user) throws Exception {
        String codeReservation = InputUtils.lireString(scanner,"saisir le code de reservation que tu vous avais annuller ");
        reservationService.cancelReservationService(codeReservation,user);
        Menus.menuApresLogin(scanner,user);
    }

}
