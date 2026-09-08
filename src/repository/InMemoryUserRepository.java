package repository;

import domain.Personne;
import domain.User;
import repository.impl.UserRepository;

import java.util.*;

public class InMemoryUserRepository implements UserRepository {

    HashMap<UUID,User> persons = new HashMap<>();

    public boolean save(User user){

            UUID id = UUID.randomUUID();
            persons.put(id,user);
            return true;
            //User person = persons.get(id);
            //System.out.println(person.getFullName()+" : "+person.getEmail()+" : "+person.getPhone());
    }

    @Override
    public User findByEmail(String email) {
        User user=null;
        for (Map.Entry<UUID,User> entry : persons.entrySet()){
            if (entry.getValue().getEmail().equals(email.toLowerCase())){
                user = entry.getValue();
            }
        }
        return user;
    }

    @Override
    public boolean existsByEmail(String email) {
        return false;
    }

    @Override
    public List<User> findAll() {
        return List.of();
    }
}
