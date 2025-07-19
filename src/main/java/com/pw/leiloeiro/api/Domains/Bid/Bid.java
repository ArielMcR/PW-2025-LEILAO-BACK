package com.pw.leiloeiro.api.Domains.Bid;

import com.pw.leiloeiro.api.Domains.Auction.Auction;
import com.pw.leiloeiro.api.Domains.User.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "tab_bid")
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Bid {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_bid;

    @Column(name = "value_bid", nullable = false)
    private Float value_bid;
    @Column(name = "date_time", nullable = false)
    private LocalDateTime date_time;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

    @ManyToOne
    @JoinColumn(name = "id_auction")
    private Auction auction;

}
