package com.pw.leiloeiro.api.Repositories;

import com.pw.leiloeiro.api.Domains.Feedback.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
}
