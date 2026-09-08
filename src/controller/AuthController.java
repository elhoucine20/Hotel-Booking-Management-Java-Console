package controller;

import exception.EmailAlreadyExistsException;
import service.AuthService;
import util.InputUtils;
import util.Menus;

import java.util.Scanner;

public class AuthController {

    public void registerController(Scanner scanner)throws Exception{
       try {
           String name = InputUtils.lireString(scanner,"saisir votre nom : ");
           String email = InputUtils.lireString(scanner,"saisir votre email : ");
           String phone = InputUtils.lireString(scanner,"saisir votre phone : ");
           String password = InputUtils.lireString(scanner,"saisir votre password : ");

        AuthService authService = new AuthService();
        authService.registerService(scanner,name,email,phone,password);
       }catch (Exception e){
            System.out.println("something is warning !!"+e.getMessage());
       }
    }

    public void loginController(Scanner scanner) throws Exception {
        String email = InputUtils.lireString(scanner,"saisir votre email : ");
        String password = InputUtils.lireString(scanner,"saisir votre mot de pass: ");
        AuthService authService = new AuthService();
        authService.loginService(email,password);
    }
}
