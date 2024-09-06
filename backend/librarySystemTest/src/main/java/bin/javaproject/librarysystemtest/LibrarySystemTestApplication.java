package bin.javaproject.librarysystemtest;

import bin.javaproject.librarysystemtest.dto.RegisterRequest;
import bin.javaproject.librarysystemtest.service.AuthenticationService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import static bin.javaproject.librarysystemtest.enums.Role.ADMIN;
import static bin.javaproject.librarysystemtest.enums.Role.MANAGER;

@SpringBootApplication
public class LibrarySystemTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(LibrarySystemTestApplication.class, args);
    }


    @Bean
    public CommandLineRunner commandLineRunner(
                AuthenticationService service
            ) {
        return args -> {
            var admin = RegisterRequest.builder()
                    .userName("Admin")
                    .phoneNumber("00001111")
                    .password("password")
                    .role(ADMIN)
                    .build();

            System.out.println("Admin token: " + service.register(admin).getAccessToken());



            var manager = RegisterRequest.builder()
                    .userName("manager")
                    .phoneNumber("00002222")
                    .password("password")
                    .role(MANAGER)
                    .build();
            System.out.println("Manager token: "+service.register(manager).getAccessToken());
        };
    }
}
