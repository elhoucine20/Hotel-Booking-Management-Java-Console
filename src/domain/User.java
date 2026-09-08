package domain;

import java.util.UUID;

public class User extends Personne {

    private String phone;
    //private UUID id;


    public User(String fullName, String email, String password, String phone) {
        super(fullName, email, password);
        setPhone(phone);
    }

    public User(String email, String password) {
        super(email, password);
    }

    // ===================== getters and setters ============================
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    @Override
    public void affichier() {
        System.out.println("this is user client ");
    }
}
