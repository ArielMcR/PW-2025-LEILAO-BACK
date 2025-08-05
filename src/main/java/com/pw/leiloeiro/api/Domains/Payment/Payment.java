package com.pw.leiloeiro.api.Domains.Payment;

import com.pw.leiloeiro.api.Domains.Auction.Auction;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
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
    @NotNull(message = "O valor não pode ser nulo")
    @Min(message = "o valor não pode ser menor que o minimo", value = 1)
    private Float value;
    @Column(name = "date_time")
    private LocalDateTime dateTime = LocalDateTime.now();
    @Column(name = "status")
    private String status;

    @OneToOne
    @JoinColumn(name="id_auction")
    private Auction auction;
}
