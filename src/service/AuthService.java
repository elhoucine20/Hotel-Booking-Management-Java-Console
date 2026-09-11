package service;

import com.sun.tools.javac.Main;
import domain.User;
import exception.EmailAlreadyExistsException;
import exception.InvalidCredentialsException;
import exception.InvalidPassword;
import repository.InMemoryUserRepository;
import repository.impl.UserRepository;
import util.Menus;
import util.ValidationUtils;

import java.util.Optional;
import java.util.Scanner;
import java.util.UUID;

public class AuthService {

    static InMemoryUserRepository userRepository = new InMemoryUserRepository();

    public void registerService(Scanner scanner,String name, String email, String phone, String password)throws Exception{
        //try {
            ValidationUtils.ValidateString(name) ;
            ValidationUtils.ValidateEmail(email.toLowerCase());
            ValidationUtils.ValidatePhone(phone) ;
            ValidationUtils.ValidatePassword(password);

                UUID id = UUID.randomUUID();
                User user = new User(name,email,password,id,phone);
                userRepository.save(id,user);
                Menus.menuApresLogin(scanner,user);


      /*}catch (IllegalArgumentException e){
            System.out.println("something is incorrect "+e.getMessage());
        }catch (EmailAlreadyExistsException e){
            System.out.println(e.getMessage());
        }catch (InvalidPassword e){
            System.out.println(e.getMessage());
        }catch (Exception e){
            e.getMessage();
        }*/
    }

    public User loginService(String email, String password) throws Exception {
        userRepository.fakeData();
        User user = null;
        try {
            if (userRepository.checkEmailAndPasswordd(email,password))
            {
                user = userRepository.findByEmail(email).get();
                return user;
           }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    return user;
    }


    public void changePasswordService(User user,String NPassword){
        try {
            ValidationUtils.ValidatePassword(NPassword);
            if (userRepository.changePasswordRepository(user,NPassword))
                System.out.println("password changed avec success");
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void verifierProfileService(User user, String name,String email,String phone){

        try {
            ValidationUtils.ValidateEmail(email);
            ValidationUtils.ValidatePhone(phone);
            if (ValidationUtils.ValidateString(name)){
                userRepository.verifierProfileRepository(user,name,email,phone);
                System.out.println("votre profile est verifier avec succes ");

            }}catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
