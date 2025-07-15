package com.pw.leiloeiro.api.Utils;

import com.pw.leiloeiro.api.Domains.User.User;
import com.pw.leiloeiro.api.Domains.User.UserRoles;
import com.pw.leiloeiro.api.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {
   @Autowired
   private UserRepository userRepository;
    @Bean
    CommandLineRunner initDatabase() {
        return args -> {
            if ((userRepository.findByEmail("admin@example.com")) == null) {
                User admin = new User();
                admin.setName("ADMIN");
                admin.setEmail("admin@example.com");
                String encryptedPassword = new BCryptPasswordEncoder().encode("admin123");
                admin.setPassword(encryptedPassword);
                admin.setRole(UserRoles.ROLE_ADMIN);
                userRepository.save(admin);
                System.out.println("Administrador cadastrado com sucesso!");
            }
        };
    }
}