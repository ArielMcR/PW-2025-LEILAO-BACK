package com.pw.leiloeiro.api.Domains.Standard;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@MappedSuperclass
@Data
public abstract class Standard {
    @Column(name = "dt_create")
    private LocalDateTime dt_create;

    @Column(name = "dt_update")
    private LocalDateTime dt_update;

    @Column(name = "dt_delete")
    private LocalDateTime dt_delete;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status = Status.active;

    @PrePersist
    protected void onCreate() {
        dt_create = LocalDateTime.now();;
    }

    @PreUpdate
    protected void onUpdate() {
        dt_update = LocalDateTime.now();
    }
}