package com.pw.leiloeiro.api.Repositories;

import com.pw.leiloeiro.api.Domains.Payment.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
