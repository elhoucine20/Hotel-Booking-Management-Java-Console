package repository;

import domain.Personne;
import domain.User;
import repository.impl.UserRepository;

import javax.swing.text.html.Option;
import java.util.*;

public class InMemoryUserRepository implements UserRepository {

    HashMap<UUID,User> persons = new HashMap<>();



    public  void fakeData(){
        User user = new User("ana","ana@gmail.com","00000000","0601667201");
        UUID id = UUID.randomUUID();
       persons.put(id,user);

     //  for (Map.Entry<UUID,User> entry : persons.entrySet()){
       //    System.out.println(entry.getValue().getPassword()+" "+entry.getValue().getEmail());
       //}
    }

    public boolean save(User user){

            UUID id = UUID.randomUUID();
            persons.put(id,user);
           // persons.entrySet().stream().forEach(u-> System.out.println(u.getValue().getFullName()));
            return true;
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return persons.entrySet().stream().map(User->User.getValue()).filter(User->User.getEmail().equals(email)).findFirst();
        //return Optional.ofNullable(user);
    }

    @Override
    public boolean existsByEmail(String email) {
        return  persons.entrySet().stream().filter(u->u.getValue().getEmail().equals(email)).findAny().isPresent();
    }

    @Override
    public List<User> findAll() {
        return List.of();
    }


    public boolean checkEmailAndPasswordd(String email, String passord){
        return findByEmail(email).get().getPassword().equals(passord) ;
    }
}
