package repository;

import domain.Personne;
import domain.User;
import repository.impl.UserRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class InMemoryUserRepository implements UserRepository {

    HashMap<UUID,User> persons = new HashMap<>();

    public void save(User user){

            UUID id = UUID.randomUUID();
            persons.put(id,user);

            User person = persons.get(id);
        System.out.println(person.getFullName()+" : "+person.getEmail()+" : "+person.getPhone());

    }
}
