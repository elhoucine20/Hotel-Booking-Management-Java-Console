package service;

import domain.Personne;
import domain.User;
import repository.InMemoryUserRepository;
import repository.impl.UserRepository;

public class AuthService {

    public void registerService(String name,String email,String phone,String password){
        User user = new User(name,email,phone,password);
        UserRepository userRepository = new InMemoryUserRepository();
        userRepository.save(user);
    }
}
