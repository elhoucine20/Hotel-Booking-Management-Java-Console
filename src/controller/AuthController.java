package controller;

import service.AuthService;

import java.util.Scanner;

public class AuthController {

    public void registerController(Scanner scanner){
       // try {
            String name="";
        System.out.println("saisir votre nom : ");

        while (name.isEmpty()){
                 name = scanner.nextLine();
            }
        System.out.println("saisir votre email : ");
        String email = scanner.nextLine();
        System.out.println("saisir votre phone : ");
        String phone = scanner.nextLine();
        System.out.println("saisir votre password : ");
        String password = scanner.nextLine();
        AuthService authService = new AuthService();
        authService.registerService(name,email,phone,password);
       // this.loginController();

       // }catch (Exception e){
     //       System.out.println("something is warning !!");
     //   }
    }

    public void loginController(){
        System.out.println("this is login controller ");
    }
}
