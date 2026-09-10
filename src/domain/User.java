package domain;

import java.util.UUID;

public class User extends Personne {

    private String phone;
    private UUID id;


    public User(String fullName, String email, String password,UUID id, String phone) {
        super(fullName, email, password);
        setPhone(phone);
        setId(id);
    }

    // ===================== getters and setters ============================
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Override
    public void affichier() {
        System.out.println("this is user client ");
    }
}
