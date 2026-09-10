package service;

import domain.Reservation;
import domain.Room;
import domain.User;
import enums.ReservationStatus;
import enums.RoomStatus;
import enums.RoomType;
import repository.InMemoryReservationRepository;
import repository.InMemoryRoomRepository;
import repository.impl.RoomRepository;
import util.Menus;
import util.ValidationUtils;

import java.math.BigDecimal;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class ReservationService {

    InMemoryReservationRepository reservationRepository = new InMemoryReservationRepository();

    public void myReservationsService(User user){
        reservationRepository.affichierReservationsUser(user);
    }

    public void createReservationService(InMemoryRoomRepository roomRepository,User user, String reservationCode, String roomNumber, int numberOfGuests, String dateDebut
    , String dateFin){


        for (Map.Entry<UUID,Reservation> res : reservationRepository.getReservationsByRoomNumber(roomNumber).entrySet()){
            System.out.println(res.getValue().getRoomNumber()+" : "+res.getValue().getTotalPrice()+" : "
                    +res.getValue().getReservationCode()+res.getValue().getStatus());
        }
        List<Reservation> reservations = new ArrayList<>();
        reservations.addAll(reservationRepository.getReservationsByRoomNumber(roomNumber).values());

        reservations.stream()
                .map(reservation -> reservation.getStatus().equals(ReservationStatus.COMPLETED) || reservation.getStatus().equals(ReservationStatus.CONFIRMED));

        try {
            ValidationUtils.ValidateCodeReservation(reservationCode);  // validate code de reservation
            if (!roomNumber.isEmpty() && numberOfGuests > 0 && numberOfGuests < 6){    // validation des inputs
                //System.out.println("hi12");
                ReservationStatus reservationStatus = ReservationStatus.CONFIRMED;
                UUID id = UUID.randomUUID();
                UUID UserId = user.getId();
                BigDecimal totalPrice;
                LocalDateTime createdAt = LocalDateTime.now();
                long numberOfNighits;
                Room room = roomRepository.getroomByNumber(roomNumber);
                if (!roomRepository.getroomByNumber(roomNumber).getStatus().equals(RoomStatus.MAINTENANCE)){   // condition pour verifier statu de room

                    // validate number of guests     SINGLE  DOUBLE  SUITE
                    if (numberOfGuests==1 && roomRepository.getroomByNumber(roomNumber).getType().equals(RoomType.SINGLE) ||
                            numberOfGuests==2 && roomRepository.getroomByNumber(roomNumber).getType().equals(RoomType.DOUBLE) ||
                            numberOfGuests>2 && numberOfGuests<=5  && roomRepository.getroomByNumber(roomNumber).getType().equals(RoomType.SUITE)
                    ){                                               // condition pour verifier numberGuests avec type de room
                        //System.out.println("hi1");
                        LocalDate checkIn = ValidationUtils.parseDate(dateDebut); // transform date to Localedate
                        LocalDate checkOut = ValidationUtils.parseDate(dateFin);

                       // validate les dates after or before
                        try {
                            ValidationUtils.ValidateLesDates(checkIn,checkOut);   // validate the dates  before or after else excetion
                        }catch (DateTimeException e) {
                            System.out.println(e.getMessage());
                            return;
                        }
                        ValidationUtils.ValidateIsAfetrLimit(checkIn);  // limit 4 months

                        numberOfNighits = ValidationUtils.ValidateDaysBetweenDates(checkIn,checkOut); // days between dates (nights) else exception
                        totalPrice = room.getPricePerNight().multiply(BigDecimal.valueOf(numberOfNighits));   // total price

                        Reservation reservation = new Reservation(id,reservationCode,UserId,roomNumber,checkIn,checkOut,
                                numberOfGuests,numberOfNighits,totalPrice,reservationStatus,createdAt);          // nes Reservation
                        // System.out.println("hi");
                        reservationRepository.saveReservationRepository(id,reservation);   // save in RepositoryReservation
                        //System.out.println("hi4");
                    } else {
                        System.out.println("vous avais saisir une chambre indisponible !!");
                    }
                }else {

                }
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
