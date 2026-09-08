package repository.impl;

import domain.Personne;
import domain.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    public void  save(User user);
    //Optional<User> findById(UUID id);
    //Optional<User> findByEmail(String email);
    //boolean existsByEmail(String email);
    //List<User> findAll();
}
