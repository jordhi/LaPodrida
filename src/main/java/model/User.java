package model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document
public class User  {
    @Id
    private String Id;
    private String email;
    private String password;
    private String fullName;

}
