package repository;

import domain.Personne;
import domain.User;
import repository.impl.UserRepository;

import javax.swing.text.html.Option;
import java.util.*;

public class InMemoryUserRepository implements UserRepository {

    HashMap<UUID,User> persons = new HashMap<>();



    public  void fakeData(){
        UUID id = UUID.randomUUID();
        User user = new User("ana","ana@gmail.com","00000000",id ,"0601667201");
       persons.put(id,user);
    }

    public boolean save(UUID id , User user){
            persons.put(id,user);
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
        if (findByEmail(email).isPresent()){
            if (findByEmail(email).get().getPassword().equals(passord)){
                System.out.println("login avec success ");
                return true;
            }
            else {
                throw new IllegalArgumentException("your password incoorect");
            }
        }else{
            throw new IllegalArgumentException("your email incoorect");
        }
    }


    public boolean changePasswordRepository(User user,String NPassword){
        for (User client: persons.values()){
            if (client.getEmail().equals(user.getEmail())){
                client.setPassword(NPassword);
                return true;
            }
        }
        return false;
    }
}
