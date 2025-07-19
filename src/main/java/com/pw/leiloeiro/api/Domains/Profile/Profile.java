package com.pw.leiloeiro.api.Domains.Profile;

import com.pw.leiloeiro.api.Domains.User.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tab_profile")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_profile;

    @Enumerated(EnumType.STRING)
    private EnumProfile tipo;

    @ManyToMany(mappedBy = "perfis")
    private Set<User> pessoas = new HashSet<>();
}
