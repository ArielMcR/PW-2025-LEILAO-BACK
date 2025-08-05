package com.pw.leiloeiro.api.Domains.Image;

import com.pw.leiloeiro.api.Domains.Auction.Auction;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "tab_image")
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_img;

    @Column(name = "dt_create")
    private LocalDateTime dt_create = LocalDateTime.now();

    @Column(name = "name_image", nullable = false)
    @NotNull(message = "o nome da imagem não pode ser nulo")
    private String name_image;

    @ManyToOne
    @JoinColumn(name="id_auction")
    private Auction auction;
}
