package com.pw.leiloeiro.api.Domains.Payment;

import com.pw.leiloeiro.api.Domains.Auction.Auction;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "tab_payment")
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_payment;
    @Column(name = "value", nullable = false)
    private Float value;
    @Column(name = "date_time")
    private LocalDateTime dateTime = LocalDateTime.now();
    @Column(name = "status")
    private String status;

    @OneToOne
    @JoinColumn(name="id_auction")
    private Auction auction;
}
