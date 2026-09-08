package util;

import controller.AuthController;

import java.util.Scanner;

public class Menus {

    public static void menuApresLogin(Scanner scan){
        boolean isTrue = true;
        while (isTrue){
            System.out.println("================================");
            System.out.println("Logged in as: Alice Dupont");
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
                case 1: System.out.println("Search available rooms");break;
                case 2: System.out.println("View all rooms");break;
                case 3: System.out.println("Create reservation");break;
                case 4: System.out.println("My reservations");break;
                case 5: System.out.println("Update reservation");break;
                case 6: System.out.println("Cancel reservation");break;
                case 7: System.out.println("Update profile");break;
                case 8: System.out.println("Change password");break;
                case 9: System.out.println("Logout"); isTrue = false; break;
                case 0: System.out.println("Exit"); isTrue = false; break;
                default:
                    System.out.println("s'il vous plais saisir une choix correct!!");break;

            }

        }
    }


    public static void menuAuth(Scanner scan) throws Exception {
        int choix;
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
                case 1: (new AuthController()).registerController(scan);break;

                case 2: (new AuthController()).loginController(scan);break;
                case 0: System.out.println("Bye Bye");break;
                default:
                    System.out.println("s'il vous plais saisir une choix correct!!");break;

            }
        }while (choix!=0 && choix!=1 && choix!=2);

    }

}
