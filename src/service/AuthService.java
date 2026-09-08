package service;

import com.sun.tools.javac.Main;
import domain.User;
import exception.EmailAlreadyExistsException;
import repository.InMemoryUserRepository;
import repository.impl.UserRepository;
import util.Menus;
import util.ValidationUtils;

import java.util.Scanner;

public class AuthService {

    public void registerService(Scanner scanner,String name, String email, String phone, String password)throws Exception{
        try {
            if (ValidationUtils.ValidateString(name) && ValidationUtils.ValidateEmail(email.toLowerCase()) && ValidationUtils.ValidatePhone(phone) && ValidationUtils.ValidatePassword(password))
            {
                User user = new User(name,email,phone,password);
                UserRepository userRepository = new InMemoryUserRepository();
                userRepository.save(user);
                Menus.menuApresLogin(scanner);
            }else{
                Menus.menuAuth(scanner);
            }
      }catch (IllegalArgumentException e){
            System.out.println("something is incorrect "+e.getMessage());
        }catch (EmailAlreadyExistsException e){
            System.out.println(e.getMessage());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    public void loginService(String email, String password) throws Exception {
        UserRepository user = new InMemoryUserRepository();
        User isUser = user.findByEmail(email);
        if (isUser != null){
            if (isUser.getPassword().equals(password)){
                System.out.println("login avec success ");
            }
            else{
                throw new IllegalArgumentException("sil vous plais saisir votre password !!");
            }
        }else {
            throw new EmailAlreadyExistsException("this email invalid !!!");
        }
    }
}
