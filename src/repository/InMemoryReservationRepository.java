package repository;

import domain.Reservation;
import domain.User;
import enums.ReservationStatus;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InMemoryReservationRepository {

    //ArrayList<Reservation> ou HashMap<UUID, Reservation>
    Map<UUID, Reservation> reservations = new HashMap<>();

    public void affichierReservationsUser(User user){
        if (reservations.isEmpty()){
            System.out.println("==== Aucun Reservation !! ====");
        } else {
            int count=0;
            for (Map.Entry<UUID,Reservation> reservation : reservations.entrySet()){
                Reservation res = reservation.getValue();
                if (user.getId().equals(res.getUserId()) ){

                    if (!res.getStatus().equals(ReservationStatus.CANCELLED)){
                        System.out.println("Code Reservation:"+res.getReservationCode()+" , RoomNumber:"+res.getRoomNumber()
                                +" , dateCheckIn:"+res.getCheckIn()+" , DateCheckOut:"+res.getCheckOut()+" , CreatedAt:"+res.getCreatedAt()+" ,NumberOfGuests:"+
                                res.getNumberOfGuests()+" , NumberOfNights:"+res.getNumberOfNights()+" , Total Price:"+res.getTotalPrice()+" , Statu:"+res.getStatus());
                        count++;
                    }
                }
            }
            if (count==0) System.out.println("==== Aucun Reservation !! ====");
        }
    }

    public boolean saveReservationRepository(UUID id,Reservation reservation){
        reservations.put(id,reservation);
        System.out.println("this is reservation : "+reservation.getUserId()+" : "+reservation.getReservationCode()+" : "+reservation.getTotalPrice());
        return true;
    }

    public Map<UUID,Reservation> getReservationsByRoomNumber(String roomNumber){
        return reservations.entrySet().stream().filter(res->res.getValue().getRoomNumber().
                equals(roomNumber) && res.getValue().getStatus().equals(ReservationStatus.CONFIRMED) ).collect(Collectors.toMap(
                Map.Entry::getKey,
                Map.Entry::getValue
        ));
    }


    public boolean cancelReservationRepository(String codeReservation,User user){
        for (Map.Entry<UUID,Reservation> res: reservations.entrySet()){
            if (res.getValue().getReservationCode().equals(codeReservation) && res.getValue().getUserId().equals(user.getId())){
                res.getValue().setStatus(ReservationStatus.CANCELLED);
                return true;
            }
        }
        return false;
    }
}
