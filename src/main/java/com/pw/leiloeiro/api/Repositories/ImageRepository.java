package com.pw.leiloeiro.api.Repositories;

import com.pw.leiloeiro.api.Domains.Image.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {
}
