package com.pw.leiloeiro.api.Repositories;

import com.pw.leiloeiro.api.Domains.User.User;
import com.pw.leiloeiro.api.DTO.UserSummaryDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
    User findByEmailAndPassword(String email, String password);
    UserDetails findByName(String name);

    @Query("SELECT new com.pw.leiloeiro.api.DTO.UserSummaryDTO(u.name, u.id_user) FROM User u")
    List<UserSummaryDTO> findUsers();
}
