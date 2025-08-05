package com.pw.leiloeiro.api.Domains.Category;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.pw.leiloeiro.api.Domains.Auction.Auction;
import com.pw.leiloeiro.api.Domains.User.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tab_category")
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_category;

    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "observation", nullable = false)
    private String observation;

    @ManyToOne
    @JoinColumn(name = "id_user")
    @NotNull(message = "usuário não pode ser nulo")

    private User user;

}
