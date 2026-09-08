package service;

import com.sun.tools.javac.Main;
import domain.User;
import exception.EmailAlreadyExistsException;
import exception.InvalidCredentialsException;
import repository.InMemoryUserRepository;
import repository.impl.UserRepository;
import util.Menus;
import util.ValidationUtils;

import java.util.Optional;
import java.util.Scanner;

public class AuthService {

    static UserRepository userRepository = new InMemoryUserRepository();

    public void registerService(Scanner scanner,String name, String email, String phone, String password)throws Exception{
        try {
            if (ValidationUtils.ValidateString(name) && ValidationUtils.ValidateEmail(email.toLowerCase())
                    && ValidationUtils.ValidatePhone(phone) && ValidationUtils.ValidatePassword(password))
            {
                User user = new User(name,email,phone,password);
                if (userRepository.save(user))
                Menus.menuApresLogin(scanner,user);

            }
      }catch (IllegalArgumentException e){
            System.out.println("something is incorrect "+e.getMessage());
        }catch (EmailAlreadyExistsException e){
            System.out.println(e.getMessage());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    public User loginService(String email, String password) throws Exception {
        userRepository.fakeData();
        User user = null;
        if (userRepository.checkEmailAndPasswordd(email,password)){
             user = userRepository.findByEmail(email).get();
                System.out.println("login avec success ");
                return user;
        }
        return user;
    }
}
