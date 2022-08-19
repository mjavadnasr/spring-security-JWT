package ir.javad.jwttutorialspringboot;

import ir.javad.jwttutorialspringboot.Model.Role;
import ir.javad.jwttutorialspringboot.Model.User;
import ir.javad.jwttutorialspringboot.service.UserServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class JwtTutorialSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(JwtTutorialSpringBootApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner run(UserServiceImpl userService)
    {
        return args -> {
            userService.saveRole(new Role(null,"ROLE_USER"));
            userService.saveRole(new Role(null,"ROLE_MANAGER"));
            userService.saveRole(new Role(null,"ROLE_ADMIN"));
            userService.saveRole(new Role(null,"ROLE_SUPER_ADMIN"));

            userService.saveUser(new User(null , "Javad nasrolla" , "javad" , "1234",new ArrayList<>()));
            userService.saveUser(new User(null , "ali nasrolla" , "ali" , "1234",new ArrayList<>()));
            userService.saveUser(new User(null , "hasan haghgoo" , "hasan" , "1234",new ArrayList<>()));
            userService.saveUser(new User(null , "reza nasrolla" , "reza" , "1234",new ArrayList<>()));

            userService.addRoleToUser("javad","ROLE_USER");
            userService.addRoleToUser("javad","ROLE_MANAGER");
            userService.addRoleToUser("ali","ROLE_MANAGER");
            userService.addRoleToUser("hasan","ROLE_ADMIN");
            userService.addRoleToUser("reza","ROLE_SUPER_ADMIN");
        };
    }

}
