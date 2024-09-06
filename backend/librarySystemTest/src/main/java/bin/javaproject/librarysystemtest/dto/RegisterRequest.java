package bin.javaproject.librarysystemtest.dto;

import bin.javaproject.librarysystemtest.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private String userName;
    private String phoneNumber;
    private String password;
    private Role role;
}
