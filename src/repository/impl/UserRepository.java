package repository.impl;

import domain.Personne;
import domain.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository {
    public boolean save(User user);
    //User findById(UUID id);
    User findByEmail(String email);
    boolean existsByEmail(String email);
    List<User> findAll();
}
