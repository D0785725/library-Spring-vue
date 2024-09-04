package bin.javaproject.librarysystemtest.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;



@Data
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    public User(String userName, String phoneNumber, String password) {
        this.userName = userName;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name", nullable = false)
    private String userName;

    @Column(name = "phone_number", unique = true, nullable = false)
    @NotEmpty(message = "Phone number is required")
    private String phoneNumber;

    @Column(name = "password", nullable = false)
    @NotEmpty(message = "Password is required")
    @Size(min = 6, message = "Password must be at least 6 characters")
    private String password;

    @Column(name = "registration_time")
    private LocalDateTime registrationTime;

    @Column(name = "last_login_time")
    private LocalDateTime lastLoginTime;


    @PrePersist
    protected void onCreate() {
        this.registrationTime = LocalDateTime.now();
        this.lastLoginTime = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.lastLoginTime = LocalDateTime.now();
    }
}
