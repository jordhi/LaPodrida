package model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class User  {
    @Id private String Id;
    private String email;
    private String password;
    private String fullName;

    public User() {}

    public User(String id, String fullName) {
        Id = id;
        this.fullName = fullName;
    }

    public User(String id) {
        Id = id;
    }
}
