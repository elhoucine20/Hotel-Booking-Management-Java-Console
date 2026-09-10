package controller;

import domain.User;
import exception.EmailAlreadyExistsException;
import exception.InvalidCredentialsException;
import service.AuthService;
import util.InputUtils;
import util.Menus;

import java.util.Scanner;

public class AuthController {
    AuthService authService = new AuthService();

    public Boolean registerController(Scanner scanner)throws Exception{
       try {
           String name = InputUtils.lireString(scanner,"saisir votre nom : ");
           String email = InputUtils.lireString(scanner,"saisir votre email : ");
           String phone = InputUtils.lireString(scanner,"saisir votre phone : ");
           String password = InputUtils.lireString(scanner,"saisir votre password : ");

        authService.registerService(scanner,name,email,phone,password);
       }catch (Exception e){
            System.out.println(e.getMessage());

       }
        return true ;
    }

    public Boolean loginController(Scanner scanner) throws Exception {
        try{
            String email = InputUtils.lireString(scanner,"saisir votre email : ");
            String password = InputUtils.lireString(scanner,"saisir votre mot de pass: ");
            User user = authService.loginService(email,password);

            if (user == null) return null;
            Menus.menuApresLogin(scanner,user);
        } catch (InvalidCredentialsException e) {
            System.out.println(e.getMessage());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return true;
    }
}
