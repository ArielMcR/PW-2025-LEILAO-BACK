package com.pw.leiloeiro.api.Domains.Auction;

import com.pw.leiloeiro.api.Domains.Category.Category;
import com.pw.leiloeiro.api.Domains.User.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Entity
@Table(name = "tab_auction")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Auction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAuction;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "detail_description")
    private String detailedDescription;

    @Column(name = "start_time")
    private LocalDateTime startTime;

    @Column(name = "end_time")
    private LocalDateTime endTime;

    @Column(name = "observation")
    private String observation;

    @Column(name = "value_increment", nullable = false)
    private Float valueIncrement;

    @Column(name = "minimum_bid", nullable = false)
    private Float minimumBid;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EnumAuction status;

    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false)
    private User user;

    @OneToOne
    @JoinColumn(name = "id_category")
    private Category category;
}

