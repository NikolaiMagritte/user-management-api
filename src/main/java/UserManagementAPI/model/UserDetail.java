package UserManagementAPI.model;

import UserManagementAPI.model.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "user_detail")
public class UserDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String address;
    private String city;
    private String country;
    private String hobbies;
    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "user_id", updatable = false)
    private User user;
}
