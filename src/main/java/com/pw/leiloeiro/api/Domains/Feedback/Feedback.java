package com.pw.leiloeiro.api.Domains.Feedback;

import com.pw.leiloeiro.api.Domains.User.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "tab_feedback")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_feedback;

    @Column(nullable = false)
    private String comment;

    @Column(nullable = false)
    private Integer note;

    @Column(name = "date_time", nullable = false)
    private LocalDateTime dateTime = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "id_author", nullable = false)
    private User author;

    @ManyToOne
    @JoinColumn(name = "id_recipient", nullable = false)
    private User recipient;
}
