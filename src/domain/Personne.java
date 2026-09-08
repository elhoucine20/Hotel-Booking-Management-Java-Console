package domain;

import java.util.UUID;

abstract public class Personne {
    protected UUID id;
    protected String fullName;
    protected String email;
    protected String password;
    //protected String type;

// ========================= constructers ======================
    public Personne(String fullName, String email, String password) {
        setFullName(fullName);
        setEmail(email);
        setPassword(password);
    }

    public Personne(String email, String password) {
        setEmail(email);
        setPassword(password);
    }

    // ========================= getters and setters ======================
    public UUID getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

     public abstract void affichier();
}
