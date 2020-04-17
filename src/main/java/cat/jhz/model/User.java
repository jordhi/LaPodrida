package cat.jhz.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Data
//@Document mongodb annotation
public class User  {
    //@Id mongodb property
    private String id;

    private String email;
    private String password;
    private String fullName;

    private List<Card> cartes = new ArrayList<>();

    public User() {}

    public User(String id, String fullName) {
        this.id = id;
        this.fullName = fullName;
    }

    public User(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public List<Card> getCartes() {
        return cartes;
    }

    public void setCartes(List<Card> cartes) {
        this.cartes = cartes;
    }

    //Create card from a single id
    public void addCard(String idcard) {
        Card card;
        if(idcard.length() == 2) card = new Card(idcard,idcard.substring(0,1),idcard.substring(1,2));
        else card = new Card(idcard,idcard.substring(0,2),idcard.substring(2,3));
        this.cartes.add(card);
    }
    public void addCard(Card card) {
        this.cartes.add(card);
    }


    @Override
    public String toString() {
        return "User{" +
                "Id='" + id + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", fullName='" + fullName + '\'' +
                '}';
    }
}
