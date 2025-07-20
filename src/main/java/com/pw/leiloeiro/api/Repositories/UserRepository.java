package com.pw.leiloeiro.api.Repositories;

import com.pw.leiloeiro.api.Domains.User.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
    User findByEmailAndPassword(String email, String password);
    UserDetails findByName(String name);


}
