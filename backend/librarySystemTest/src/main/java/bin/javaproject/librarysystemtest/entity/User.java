package bin.javaproject.librarysystemtest.entity;

import bin.javaproject.librarysystemtest.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;


@Builder
@Data
@NoArgsConstructor
@Entity
@Table(name = "users")
@AllArgsConstructor
public class User implements UserDetails {


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

    @OneToMany(mappedBy = "user")
    private List<Token> tokens;

    @Enumerated(EnumType.STRING)
    private Role role;

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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getUsername() {
        return phoneNumber;  // jwt test case
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // jwt test case
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // jwt test case
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // jwt test case
    }

    @Override
    public boolean isEnabled() {
        return true; // jwt test case
    }
}
