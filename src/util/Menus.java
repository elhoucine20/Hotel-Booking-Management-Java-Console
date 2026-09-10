package util;

import controller.AuthController;
import controller.ReservationController;
import controller.RoomController;
import domain.User;
import repository.InMemoryRoomRepository;
import repository.impl.RoomRepository;

import java.util.Scanner;

public class Menus {

    static  AuthController  authController = new AuthController();
    static RoomController roomController = new RoomController();
    static ReservationController reservationController = new ReservationController();
    static  InMemoryRoomRepository inMemoryRoomRepository = new InMemoryRoomRepository();


    public static void menuApresLogin(Scanner scan, User user) throws Exception {
        boolean isTrue = true;
        while (isTrue){
            System.out.println("================================");
            System.out.println("Logged in as: "+user.getFullName());
            System.out.println("================================");

            System.out.println("1. Search available rooms");
            System.out.println("2. View all rooms");
            System.out.println("3. Create reservation");
            System.out.println("4. My reservations");
            System.out.println("5. Update reservation");
            System.out.println("6. Cancel reservation");
            System.out.println("7. Update profile");
            System.out.println("8. Change password");
            System.out.println("9. Logout");
            System.out.println("0. Exit");
            int choixBeforLogin = scan.nextInt();

            switch (choixBeforLogin){
                case 1: roomController.serviceAffichierRoomsAvailable( inMemoryRoomRepository); Menus.menuApresLogin(scan,user); break;
                case 2: roomController.serviceAffichierRooms( inMemoryRoomRepository); Menus.menuApresLogin(scan,user); break;
                case 3: reservationController.createReservationController(scan,user, inMemoryRoomRepository);break;
                case 4: reservationController.reservationServiceAffichier(user);break;
                case 5: System.out.println("Update reservation");break;
                case 6: System.out.println("Cancel reservation");break;
                case 7: System.out.println("Update profile");break;
                case 8: System.out.println("Change password");break;
                case 9: System.out.println("Logout"); Menus.menuAuth(scan) ; break;
                case 0: System.out.println("Exit"); isTrue = false; break;
                default:
                    System.out.println("s'il vous plais saisir une choix correct!!");break;

            }

        }
    }


    public static void menuAuth(Scanner scan) throws Exception {
        int choix;
        boolean isTrue = true;
        do {
            System.out.println("========================");
            System.out.println("HOTEL BOOKING");
            System.out.println("========================");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("0. Exit");
            System.out.print("Choice: ");
            choix = scan.nextInt();

            switch (choix){
                case 1: authController.registerController(scan);break;
                case 2: authController.loginController(scan);break;
                case 0: System.out.println("Bye Bye"); isTrue=false; break;
                default:
                    System.out.println("s'il vous plais saisir une choix correct!!");break;

            }
        }while (isTrue);
    }
}
