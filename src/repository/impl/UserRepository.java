package repository.impl;

import domain.Personne;
import domain.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository {
    public boolean save(UUID id,User user);
    //User findById(UUID id);
    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);
    List<User> findAll();
    public boolean checkEmailAndPasswordd(String email, String passord);

    public  void fakeData();
}
