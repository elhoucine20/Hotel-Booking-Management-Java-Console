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

    static UserRepository userRepository = new InMemoryUserRepository();

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
}
