package util;

import exception.EmailAlreadyExistsException;

public class ValidationUtils {

    public static boolean ValidateEmail(String email){
        if (email.isEmpty() || !email.contains("@gmail.com")){
            System.out.println("s'il vous plais saisir email correct !!");
            return false;
        }else return true;
    }

    public static boolean ValidateString(String name){
        if (name.isEmpty() || name.length() <= 2){
            System.out.println("s'il vous plais saisir votre nom !!");
            return false;
        }else return true;
    }
    public static boolean ValidatePhone(String phone){
        if (phone.isBlank() || phone.length() < 10){
            System.out.println("s'il vous plais saisir votre phone !!");
            return false;
        }else return true;
    }
    public static boolean ValidatePassword(String pass){
        if (pass.isBlank() || pass.length() < 8){
            System.out.println("s'il vous plais saisir une password correct !!");
            return false;
        }else return true;
    }



}
